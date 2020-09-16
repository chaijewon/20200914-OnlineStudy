package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
/*
 *     클래스 제작 
 *     ========
 *       프로그램 => 데이터를 조작 
 *                ======
 *                 데이터를 저장 : 초기값을 부여 
 *                 =======================
 *                 = 명시적 초기화
 *                   private int a=10;
 *                 = 초기블록
 *                   = 인스턴스 블록
 *                   
 *                   = static 블록 
 *                 ======================== 자동 인식 
 *                 = 생성자 : 호출할때 변수가 초기화 
 *                   new 생성자()
 */
public class MusicDAO {
   private static SqlSessionFactory ssf;
   // ssf => XML을 읽어오는 역할 => 오라클연결 (JDBC) , XML(파싱), HTML(크롤링)
   static {
	   // 자동 초기화
	   try
	   {
		   Reader reader=Resources.getResourceAsReader("config.xml");
		   // XML 파싱 
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   public static List<MusicVO> musicAllData()
   {
	   return ssf.openSession().selectList("musicAllData");//<select id="musicAllData">
   }
}
