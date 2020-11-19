package com.sist.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.*;
@Repository
public class BoardDAO {
	@Autowired
    private DBConnection dbConn;
	private CallableStatement cs;
	public List<BoardVO> boardListData(int page)
	{
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
    
}






