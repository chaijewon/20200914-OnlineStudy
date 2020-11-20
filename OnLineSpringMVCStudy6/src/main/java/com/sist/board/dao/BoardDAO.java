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
    
}






