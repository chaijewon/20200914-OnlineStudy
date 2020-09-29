package com.sist.dao;
import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
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
   /*
    *     게시판 / 댓글  => PL/SQL
    *     Spring으로 프로젝트 
    *     JSP : Spring을 제작 
    */
   public static MemberVO memberLogin(String id,String pwd)
   {
	   MemberVO vo=new MemberVO();
	   // 연결 
	   SqlSession session=null;
	   try
	   {
		   // 연결
		   session=ssf.openSession();
		   // 오라클에 SQL문장 전송 
		   int count=session.selectOne("memberIdCheck",id);
		   if(count==0) // ID가 없는 상태
		   {
			   vo.setMsg("NOID");
		   }
		   else // ID가 존재하는 상태
		   {
			   // 비밀번호 검사
			   vo=session.selectOne("memberGetInfoData", id);
			   if(pwd.equals(vo.getPwd()))// 로그인
			   {
				   vo.setMsg("OK");
			   }
			   else // 비밀번호가 틀린 상태
			   {
				   vo.setMsg("NOPWD");
			   }
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // 재사용 => 반환 (POOL) => false(다시 사용)
		   /*
		    *   jdbc/oracle
		    *   ==========================
		    *    new Connection() false ==> true (close=> false)
		    *   ==========================
		    *    new Connection() false
		    *   ==========================
		    *    new Connection() false
		    *   ==========================
		    *   
		    *   _jspInit() : 환경 설정 (web.xml)
		    *   _jspService() : 사용자 요청한 파일 실행
		    *   _jspDestory() : 메모리 해제 => GC()
		    */
	   }
	   return vo;
   }
   
}







