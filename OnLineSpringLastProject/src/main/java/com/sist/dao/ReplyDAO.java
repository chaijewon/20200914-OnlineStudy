package com.sist.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;

import java.sql.*;
@Repository
public class ReplyDAO {
  private Connection conn;
  private CallableStatement cs;
  private PreparedStatement ps;
  private final String URL="jdbc:oracle:thin:@211.238.142.181:1521:XE";
  public ReplyDAO()
  {
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	  }catch(Exception ex){}
  }
  public void getConnection()
  {
	  try
	  {
		  conn=DriverManager.getConnection(URL,"hr","happy");
	  }catch(Exception ex){}
  }
  public void disConnection()
  {
	  try
	  {
		  if(cs!=null) cs.close();// procedure 
		  if(ps!=null) ps.close();// 일반 sql
		  if(conn!=null) conn.close();
	  }catch(Exception ex){}
  }
  // LOGIN => 일반 SQL 
  public String isLogin(String id,String pwd)
  {
	  String result="";
	  try
	  {
		  getConnection();
		  String sql="SELECT COUNT(*) FROM member "
				    +"WHERE id=?";
		  ps=conn.prepareStatement(sql);
		  ps.setString(1, id);
		  ResultSet rs=ps.executeQuery();
		  rs.next();
		  int count=rs.getInt(1);
		  rs.close();
		  if(count==0)
		  {
			  result="NOID";
		  }
		  else
		  {
			  sql="SELECT pwd,name FROM member "
			     +"WHERE id=?";
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, id);
			  rs=ps.executeQuery();
			  rs.next();
			  String db_pwd=rs.getString(1);
			  String name=rs.getString(2);
			  rs.close();
			  if(db_pwd.equals(pwd))
			  {
				  result=id+"|"+name;
			  }
			  else
			  {
				  result="NOPWD";
			  }
		  }
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
	  return result;
  }
  // 댓글 
  /*
   *    create or replace PROCEDURE replyInsert(
		   pType project_reply.type%TYPE,
		   pCno project_reply.cno%TYPE,
		   pId project_reply.id%TYPE,
		   pName project_reply.name%TYPE,
		   pMsg project_reply.msg%TYPE
		)
		IS
		  vNo project_reply.no%TYPE;
		BEGIN
		  SELECT NVL(MAX(no)+1,1) INTO vNo
		  FROM project_reply;
		
		  INSERT INTO project_reply(no,type,cno,id,name,msg)
		  VALUES(vNo,pType,pCno,pId,pName,pMsg);
		  COMMIT;
		END;

   */
  public void replyInsert(ReplyVO vo)
  {
	  try
	  {
		  getConnection();
		  String sql="{CALL replyInsert(?,?,?,?,?)}";
		  cs=conn.prepareCall(sql);
		  cs.setInt(1, 1);
		  cs.setInt(2, vo.getCno());
		  cs.setString(3, vo.getId());
		  cs.setString(4, vo.getName());
		  cs.setString(5, vo.getMsg());
		  
		  cs.executeQuery();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
  }
  /*
   *    create or replace PROCEDURE replyListData(
		   pType project_reply.type%TYPE,
		   pCno project_reply.cno%TYPE,
		   pStart NUMBER,
		   pEnd NUMBER,
		   pResult OUT SYS_REFCURSOR
		)
		IS
		BEGIN
		   OPEN pResult FOR
		    SELECT no,type,cno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),num
		    FROM (SELECT no,type,cno,id,name,msg,regdate,rownum as num
		    FROM (SELECT no,type,cno,id,name,msg,regdate
		    FROM project_reply WHERE type=pType AND cno=pCno ORDER BY no DESC))
		    WHERE num BETWEEN pStart AND pEnd;
		END;
   */
  public List<ReplyVO> replyListData(int cno,int page)
  {
	  List<ReplyVO> list=new ArrayList<ReplyVO>();
	  try
	  {
		  getConnection();
		  String sql="{CALL replyListData(?,?,?,?,?)}";
		  cs=conn.prepareCall(sql);
		  cs.setInt(1, 1);
		  cs.setInt(2, cno);
		  int rowSize=10;
		  int start=(rowSize*page)-(rowSize-1);
		  int end=rowSize*page;
		  cs.setInt(3, start);
		  cs.setInt(4, end);
		  cs.registerOutParameter(5, OracleTypes.CURSOR);
		  cs.executeQuery();
		  // 결과값 받기 
		  ResultSet rs=(ResultSet)cs.getObject(5);
		  // no,type,cno,id,name,msg,dbday
		  while(rs.next())
		  {
			  ReplyVO vo=new ReplyVO();
			  vo.setNo(rs.getInt(1));
			  vo.setType(rs.getInt(2));
			  vo.setCno(rs.getInt(3));
			  vo.setId(rs.getString(4));
			  vo.setName(rs.getString(5));
			  vo.setMsg(rs.getString(6));
			  vo.setDbday(rs.getString(7));
			  list.add(vo);
		  }
		  rs.close();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
	  return list;
  }
  /*
   *  create or replace PROCEDURE replyDelete(
		   pNo project_reply.no%TYPE
		)
		IS
		BEGIN
		  DELETE FROM project_reply
		  WHERE no=pNo;
		  COMMIT;
		END;
   */
  public void reply_delete(int no)
  {
	  try
	  {
		  getConnection();
		  String sql="{CALL replyDelete(?)}";
		  cs=conn.prepareCall(sql);
		  cs.setInt(1, no);
		  cs.executeQuery();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
  }
  /*
   * create or replace PROCEDURE replyUpdate(
	   pNo project_reply.no%TYPE,
	   pMsg project_reply.msg%TYPE
	)
	IS
	BEGIN
	  UPDATE project_reply SET
	  msg=pMsg
	  WHERE no=pNo;
	  COMMIT;
	END;
   */
  public void reply_update(int no,String msg)
  {
	  try
	  {
		  getConnection();
		  String sql="{CALL replyUpdate(?,?)}";
		  cs=conn.prepareCall(sql);
		  cs.setInt(1, no);
		  cs.setString(2, msg);
		  cs.executeQuery();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
  }
}







