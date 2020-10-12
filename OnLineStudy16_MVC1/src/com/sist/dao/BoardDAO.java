package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class BoardDAO {
   // 파싱(XML) => SqlSessionFactory
	private static SqlSessionFactory ssf;
	// 구동하기전에 자동으로 파싱을 한다 => 초기화블럭 (static => static{} , instance => {})
	static
	{
		// 오류 처리  => Mybatis (컴파일 오류(X) => 에러가 발생시에 찾기 어렵다)
		try
		{
			// IO => 파일경로 , 파일명이 틀릴경우에 처리(컴파일예외=>반드시 예외처리를 한다)
			// 파일 읽기
			Reader reader=Resources.getResourceAsReader("Config.xml");
			// MyBatis,Spring => classpath(자동으로 인식하는 경로 : src) 
			// XML 파싱 
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	/*
	 *   <select id="boardListData" resultType="BoardVO" parameterType="hashmap">
		   SELECT no,subject,name,regdate,hit,num
		   FROM (SELECT no,subject,name,regdate,hit,rownum as num
		   FROM (SELECT no,subject,name,regdate,hit 
		   FROM freeboard ORDER BY no DESC))
		   WHERE num BETWEEN #{start} AND #{end}
		  </select>
		  <select id="boardTotalPage" resultType="int">
		   SELECT CEIL(COUNT(*)/10.0) FROM freeboard
		  </select>
	 */
	//            resultType                parameterType
	public static List<BoardVO> boardListData(Map map)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		SqlSession session=ssf.openSession();// Connection얻기
		list=session.selectList("boardListData",map);
		session.close();//Connection반환
		return list;// null 
	}
	public static int boardTotalPage()
	{
		int total=0;
		SqlSession session=ssf.openSession();
		total=session.selectOne("boardTotalPage");
		session.close();
		return total;
	}
}






