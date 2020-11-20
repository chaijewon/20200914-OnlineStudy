package com.sist.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
@Repository
public class BoardDAO {
	@Autowired
    private DBConnection dbConn;
	private CallableStatement cs;//Procedure
	private PreparedStatement ps;//SQL
	public List<BoardVO> boardListData(int page)
	{
		System.out.println("BoardDAO:"+dbConn);
		List<BoardVO> list=new ArrayList<BoardVO>();
		// dbConn.getConnection()
		/*
		 *   CREATE OR REPLACE PROCEDURE projetBoardListData(
			   pStart NUMBER,
			   pEnd NUMBER,
			   pResult OUT SYS_REFCURSOR,
			   pTotal OUT NUMBER
			)
		 */
		try
		{
			String sql="{CALL projetBoardListData(?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			cs.setInt(1, start);
			cs.setInt(2, end);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			// 실행
			cs.executeQuery();
			// 데이터 받기
			ResultSet rs=(ResultSet)cs.getObject(3);
			while(rs.next())
			{
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setRegdate(rs.getDate(4));
				vo.setName(rs.getString(3));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex){}
		// dbConn.disConnection
		return list;
	}
	/*
	 *   CREATE OR REPLACE PROCEDURE projectBoardInsert(
		   pName project_board.name%TYPE,
		   pSubject project_board.subject%TYPE,
		   pContent project_board.content%TYPE,
		   pPwd project_board.pwd%TYPE
		)
		IS
	 */
	public void boardInsert(BoardVO vo)
	{
		try
		{
			String sql="{CALL projectBoardInsert(?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setString(1, vo.getName());
			cs.setString(2, vo.getSubject());
			cs.setString(3, vo.getContent());
			cs.setString(4, vo.getPwd());
			
			cs.executeQuery();
		}catch(Exception ex){}
	}
	/*
	 *   CREATE OR REPLACE PROCEDURE projectBoardDetailData(
		   pNo project_board.no%TYPE,
		   pResult OUT SYS_REFCURSOR
		)
	 */
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		// getConnection() => @Before
		try
		{
			String sql="{CALL projectBoardDetailData(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			// 데이터 받기
			ResultSet rs=(ResultSet)cs.getObject(2);
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		}catch(Exception ex){}
		// disConnection() => @After
		return vo;
	}
	/*
	 *   수정 데이터 읽기
	 *   CREATE OR REPLACE PROCEDURE projectBoardUpdateData(
		   pNo project_board.no%TYPE,
		   pResult OUT SYS_REFCURSOR
		)
		IS
		BEGIN
		   OPEN pResult FOR
		     SELECT no,name,subject,content 
		     FROM project_board
		     WHERE no=pNo;
		END;
		/
	 */
	public BoardVO boardUpdateData(int no)
	{
		BoardVO vo=new BoardVO();
		// getConnection() => Before
		try
		{
			String sql="{CALL projectBoardUpdateData(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			// 실행 요청 ?에 값을 채운다 
			cs.setInt(1, no);
			// OUT => 저장 공간을 만들어 준다 
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			// 저장공간에서 값을 가지고 온다 
			ResultSet rs=(ResultSet)cs.getObject(2);
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			rs.close();
			// Client => DAO(X)
			// Client <===> Model <===> DAO
		}catch(Exception ex){/*AfterThrowing*/} // AOP에서 처리 
		// disConnection() => After
		return vo; // AfterReturning
	}
	/*
	 *  CREATE OR REPLACE PROCEDURE projectBoardUpdate(
		   pNo project_board.no%TYPE,
		   pName project_board.name%TYPE,
		   pSubject project_board.subject%TYPE,
		   pContent project_board.content%TYPE,
		   pPwd project_board.pwd%TYPE,
		   pResult OUT project_board.name%TYPE
		)
		IS
		  vPwd project_board.pwd%TYPE;
		BEGIN 
		  SELECT pwd INTO vPwd
		  FROM project_board
		  WHERE no=pNo;
		  
		  IF(vPwd=pPwd) THEN
		   pResult:='true';
		   UPDATE project_board SET
		   name=pName,subject=pSubject,content=pContent
		   WHERE no=pNo;
		   COMMIT;
		  ELSE
		   pResult:='false';
		  END IF;
		END;
		/
	 */
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		// dbConn.getConnection()
		try
		{
			String sql="{CALL projectBoardUpdate(?,?,?,?,?,?)}";
			// 전송 => 오라클 
			
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getNo());
			cs.setString(2, vo.getName());
			cs.setString(3, vo.getSubject());
			cs.setString(4, vo.getContent());
			cs.setString(5, vo.getPwd());
			cs.registerOutParameter(6, OracleTypes.VARCHAR);
			cs.executeQuery();
			String result=cs.getString(6);
			// Cursor => 자바(X) => ResultSet
			bCheck=Boolean.parseBoolean(result);
			// "10"
		}catch(Exception ex){/*ex.printStackTrace();*/}
		// dbConn.disConnection()
		// System.out.println("obj="+obj);
		return bCheck;
	}
	/*
	 *   CREATE OR REPLACE PROCEDURE projectBoardDelete(
			   pNo project_board.no%TYPE,
			   pPwd project_board.pwd%TYPE,
			   pResult OUT project_board.name%TYPE
			)
			IS
			  vPwd project_board.pwd%TYPE;
			BEGIN
			  SELECT pwd INTO vPwd
			  FROM project_board
			  WHERE no=pNo;
			  
			  IF(vPwd=pPwd) THEN
			    pResult:='true';
			    DELETE FROM project_board 
			    WHERE no=pNo;
			    COMMIT;
			  ELSE
			    pResult:='false';
			  END IF;
			END;
			/
	 */
	public boolean boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		try
		{
			String sql="{CALL projectBoardDelete(?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, pwd);
			cs.registerOutParameter(3, OracleTypes.VARCHAR);
			cs.executeQuery();
			String result=cs.getString(3);
			bCheck=Boolean.parseBoolean(result);
		}catch(Exception ex){}
		return bCheck;
	}
	
	public int boardTotalPage()
	{
		int total=0;
		try
		{
			String sql="SELECT boardTotalPage() FROM project_board";
			ps=dbConn.getConn().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			ps.close();
			/*
			 *   PROCEDURE => {CALL pro_name()}
			 *   FUNCTION => SELECT func_name() ~
			 */
		}catch(Exception ex){}
		return total;
	}
	// 댓글 
	/*
	 *   CREATE OR REPLACE PROCEDURE replyListData(
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
		/
	 */
	public List<ReplyVO> replyListData(int type,int cno,int page)
	{
		List<ReplyVO> list=
				new ArrayList<ReplyVO>();
		// dbConn.getConnection()
		try
		{
			String sql="{CALL replyListData(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, type);
			cs.setInt(2, cno);
			int rowSize=5;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			cs.setInt(3, start);
			cs.setInt(4, end);
			cs.registerOutParameter(5, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(5);
			//no,type,cno,id,name,msg,TO_CHAR(regdate
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
		}catch(Exception ex){}
		// dbConn.disConnection()
		return list;
	}
	/*
	 *   CREATE OR REPLACE PROCEDURE replyInsert(
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
		/
	 */
	public void replyInsert(ReplyVO vo)
	{
		// dbConn.getConnection()
		try
		{
			String sql="{CALL replyInsert(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getType());
			cs.setInt(2, vo.getCno());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			
			cs.executeQuery();
		}catch(Exception ex){}
		//dbConn.disConnection()
	}
	/*
	 *   CREATE OR REPLACE PROCEDURE replyUpdate(
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
		/
	*/
	public void replyUpdate(int no,String msg)
	{
		try
		{
			String sql="{CALL replyUpdate(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery();
		}catch(Exception ex){}
	}
	/*
		-- 삭제 
		CREATE OR REPLACE PROCEDURE replyDelete(
		   pNo project_reply.no%TYPE
		)
		IS
		BEGIN
		  DELETE FROM project_reply
		  WHERE no=pNo;
		  COMMIT;
		END;
		/
	 */
	public void replyDelete(int no)
	{
		try
		{
			String sql="{CALL replyDelete(?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		}catch(Exception ex){}
	}
	
	// 로그인 
	public MemberVO memberLogin(String id,String pwd)
	{
		MemberVO vo=new MemberVO();
		try
		{
			dbConn.getConnection();
			String sql="SELECT COUNT(*) FROM member "
					  +"WHERE id=?";
			ps=dbConn.getConn().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			
			if(count==0)//ID가 없는 상태
			{
				vo.setMessage("NOID");
			}
			else // ID가 존재하는 상태 
			{
				sql="SELECT pwd,name FROM member "
				   +"WHERE id=?";
				ps=dbConn.getConn().prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				rs.close();
				
				if(db_pwd.equals(pwd))//로그인
				{
					vo.setId(id);
					vo.setName(name);
					vo.setMessage("OK");
				}
				else//비밀번호가 틀린 경우
				{
					vo.setMessage("NOPWD");
				}
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			dbConn.disConnection();
		}
		return vo;
	}
    
}






