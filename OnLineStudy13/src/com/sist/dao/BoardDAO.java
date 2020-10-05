package com.sist.dao;
import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class BoardDAO {
   // XML파일 읽기
   private static SqlSessionFactory ssf;
   // 자동 초기화 => 블록
   static 
   {
	   try
	   {
		   // 파일 읽기
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   // XML 파싱 => 필요한 데이터를 저장한다 
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // 목록 읽기 
   // <select id="boardListData" resultType="BoardVO" parameterType="hashmap">
   public static List<BoardVO> boardListData(Map map)
   {
	   List<BoardVO> list=new ArrayList<BoardVO>();//list=> 값을 채운다
	   // Connection => Sqlession
	   SqlSession session=null;
	   try
	   {
		   // 연결 객체 
		   session=ssf.openSession();
		   // SQL문장 실행 요청
		   list=session.selectList("boardListData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
}










