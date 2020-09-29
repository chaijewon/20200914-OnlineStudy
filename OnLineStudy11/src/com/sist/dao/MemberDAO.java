package com.sist.dao;
import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MemberDAO {
   // XML을 읽어서 데이터를 저장하는 객체
   private static SqlSessionFactory ssf;
   static 
   {
	   try
	   {
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
		   // getConnection,disConnection
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   
   // 기능 처리
   // 1. login처리 => session => 1.id,2.name,3.admin
   // <select id="memberIdCheck" resultType="int" parameterType="String">
   // <select id="memberGetInfoData" resultType="com.sist.dao.MemberVO" parameterType="String">
   // public static String 
   
}







