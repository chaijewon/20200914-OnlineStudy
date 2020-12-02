package com.sist.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import java.text.*;
import com.mongodb.*;
@Repository
public class BoardDAO {
   private MongoClient mc; // Connection
   private DB db;//XE(데이터베이스) => mydb
   private DBCollection dbc; // 테이블 
   public BoardDAO()
   {
	   try
	   {
		   // 연결 
		   mc=new MongoClient("localhost",27017);
		   // 데이터베이스 연결 
		   db=mc.getDB("mydb");
		   // 테이블 연결 
		   dbc=db.getCollection("board");
	   }catch(Exception ex){}
   }
   // 추가
   public void boardInsert(BoardVO vo)
   {
	   try
	   {
		   int max=0;
		   DBCursor cursor=dbc.find();
		   // DBCursor => ResultSet 
		   // dbc.find() => ps.executeQuery("SELECT * FROM board");
		   while(cursor.hasNext())
		   {
			   // {},{},{}
			   BasicDBObject obj=(BasicDBObject)cursor.next();
			   int no=obj.getInt("no");
			   if(max<no)
				   max=no;
		   }
		   cursor.close();
		   // Sequence => 자동 증가번호 (SELECT MAX(no) FROM board)
		   // 추가
		   BasicDBObject obj=new BasicDBObject();// {}
		   obj.put("no", max+1 );// {no:1,name:'',sub:''}
		   obj.put("name", vo.getName());
		   obj.put("subject", vo.getSubject());
		   obj.put("content", vo.getContent());
		   obj.put("pwd", vo.getPwd());
		   obj.put("regdate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		   obj.put("hit", 0);
		   
		   dbc.insert(obj);
	   }catch(Exception ex){System.out.println(ex.getMessage());}
   }
   // 데이터 읽기
   public List<BoardVO> boardListData(int page)
   {
	   List<BoardVO> list=new ArrayList<BoardVO>();
	   try
	   {
		   int rowSize=10;
		   int skip=(rowSize*page)-rowSize;
		   /*
		    *   0
		    *   1
		    *   2
		    *   3
		    *   4
		    *   5
		    *   -
		    *   9
		    *   10
		    *   11
		    *   12
		    *   -
		    *   20
		    *   21
		    *   22
		    */
		   // -1:DESC , 1:ASC
		   DBCursor cursor=dbc.find().skip(skip).limit(rowSize).sort(new BasicDBObject("no",-1));
		   while(cursor.hasNext())
		   {
			   BasicDBObject obj=(BasicDBObject)cursor.next();
			   BoardVO vo=new BoardVO();
			   vo.setNo(obj.getInt("no"));
			   vo.setSubject(obj.getString("subject"));
			   vo.setName(obj.getString("name"));
			   vo.setRegdate(obj.getString("regdate"));
			   vo.setHit(obj.getInt("hit"));
			   list.add(vo);
		   }
		   cursor.close();
	   }catch(Exception ex){}
	   return list;
   }
   // 상세보기
   public BoardVO boardDetailData(int no,int type)
   {
	   BoardVO vo=new BoardVO();
	   try
	   {
		   BasicDBObject where=new BasicDBObject();
		   where.put("no", no);
		   
		   BasicDBObject obj=(BasicDBObject)dbc.findOne(where);
		   //   dbc.findOne => SELECT * FROM board WHERE no=1; => {no:1},
		   if(type==1)
		   {
			   int hit=obj.getInt("hit");
			   BasicDBObject up=new BasicDBObject("$set",new BasicDBObject("hit",hit+1));
			   dbc.update(where, up);
		   }
		   // 조회수 증가 
		   obj=(BasicDBObject)dbc.findOne(where);
		   vo.setNo(obj.getInt("no"));
		   vo.setName(obj.getString("name"));
		   vo.setSubject(obj.getString("subject"));
		   vo.setContent(obj.getString("content"));
		   vo.setRegdate(obj.getString("regdate"));
		   vo.setHit(obj.getInt("hit"));
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return vo;
   }
   // 수정하기
   public boolean boardUpdate(BoardVO vo)
   {
	   boolean bCheck=false;
	   try
	   {
		   // 몽고디비에 저장된 비밀번호 읽기
		   BasicDBObject where=new BasicDBObject();
		   where.put("no", vo.getNo());//{no:1}
		   
		   BasicDBObject obj=(BasicDBObject)dbc.findOne(where);
		   // find(): DBCursor => 여러개 {} ,findOne():BasicDBObject => 한개 {}
		   if(vo.getPwd().equals(obj.getString("pwd")))
		   {
			   bCheck=true;
			   BasicDBObject updateObj=new BasicDBObject();
			   updateObj.put("name", vo.getName());
			   updateObj.put("subject", vo.getSubject());
			   updateObj.put("content", vo.getContent());
			   
			   BasicDBObject update=new BasicDBObject("$set",updateObj);
			   // 몽고비디에 전송
			   dbc.update(where, update);
		   }
		   else
		   {
			   bCheck=false;
		   }
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return bCheck;
   }
   // 삭제하기 
   public boolean boardDelete(int no,String pwd)
   {
	   boolean bCheck=false;
	   try
	   {
		   BasicDBObject where=new BasicDBObject();
		   where.put("no", no);
		   
		   // 비밀번호 가지고 오기 
		   BasicDBObject obj=(BasicDBObject)dbc.findOne(where);
		   
		   // 조건 
		   if(pwd.equals(obj.getString("pwd")))
		   {
			   bCheck=true;
			   dbc.remove(where);
		   }
		   else
		   {
			   bCheck=false;
		   }
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return bCheck;
   }
   // 총페이지 
   public int boardTotalPage()
   {
	   int total=0;
	   try
	   {
		   DBCursor cursor=dbc.find();
		   total=cursor.count();// SELECT CEIL(COUNT(*)/10.0) FROM board
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return (int)Math.ceil(total/10.0);
   }
}






