package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
/*
 *    public class CreateSqlSessionFactory
 *    {
 *          private static SqlSessionFactory ssf;
			static 
			{
				try
				{
					Reader reader=Resources.getResourceAsReader("Config.xml");
					ssf=new SqlSessionFactoryBuilder().build(reader);
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			} 
			public static SqlSessionFactory getSsf()
			{
			    return ssf;
			}
 *    }
 *    
 *    
 *    오늘 ==> 액션 태그 : 자바문법을 태그형으로 제작 
 *    3가지 기억
 *    1) <jsp:include page="첨부할 JSP파일명">
 *    2) <jsp:useBean id="dao" class="MemberDAO">
 *       ============================ 메모리 할당
 *         => 자바코드 
 *            MemberDAO dao=new MemberDAO()
 *                     ====
 *                       id  ==> id가 객체명이 된다
 *    3) <jsp:setProperty name="객체명" property="">
 *                        =========== ============
 *                        name: => id명칭 
 *                        property : 변수명  ==> setXxx()에 값을 채워준다
 *        예)
 *           JSP => Bean , MyBatis => DTO , Spring => VO
 *           Bean = DTO = VO는 동일한 개념 
 *             => 영화 한개의 전체정보 => 브라우저에 넘겨줄 목적 
 *             => 기능이 두가지 
 *                읽기 / 쓰기 
 *                getter / setter
 *           public class MemberVO
 *           {
 *               private int no;
 *               private String name;
 *               // 쓰기 => 메모리에 저장
 *               public void setNo(int no)
 *               {
 *                  this.no=no;
 *               }
 *               // 읽기 => 저장된 값 읽기
 *               public int getNo()
 *               {
 *                   return no;
 *               }
 *               public void setName(String name)
 *               {
 *                   this.name=name;
 *               }
 *               public void getName()
 *               {
 *                  return name;
 *               }
 *           }
 *           
 *           VO => 메모리에 클래스를 저장 
 *           MemberVO vo=new MemberVO();
 *           => <jsp:useBean id="vo" class="MemberVO">
 *              useBean : 메모리 할당 
 *           => 싱클턴 
 *           => HTML과 자바코딩을 분리 
 *              <c:forEach> <c:if> <c:forTokenes> : JSTL
 *              <% %> => 제거 
 *           vo.setName("홍길동"),vo.setNo(1)
 *           => <jsp:setProperty name="vo" property="no" value="1">
 *              vo.setNo(1)
 *                             ==========
 *              <jsp:setProperty name="vo" property="name" value="홍길동">
 *              vo.setName("홍길동")
 *              
 *              setProperty => setXxx()에 값을 채워준다
 *              
 *           => <jsp:setProperty name="vo" property="*">
 *              모든 setXxx()에 전송된 값을 채워라
 */
public class BoardDAO{
	private static SqlSessionFactory ssf;
	/*
	 *   마이바티스 , 스프링 : 먼저 XML을 읽기 때문에 XML이 틀릴경우에는 
	 *   구동이 안된다
	 *   => id가 같은 경우에는 오류가 없게 
	 *   => id => 앞에 테이블명 
	 *   databoardTotalPage
	 *   freeboardTotalPage
	 */
	static 
	{
		try
		{
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// <select id="freeBoardListData" resultType="com.sist.dao.BoardVO" parameterType="hashmap">
	public static List<BoardVO> freeBoardListData(Map map)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			list=session.selectList("freeBoardListData",map);
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
	// <insert id="freeBoardInsert" parameterType="com.sist.dao.BoardVO">
	public static void freeBoardInsert(BoardVO vo)
	{
		SqlSession session=null;
		try
		{
			// 연결 객체 (Connection)=> SqlSession => getConnection
			// 스프링 => 분리 , 중복없이 => annotation
			session=ssf.openSession(true);//insert => commit (autoCommit)
			session.insert("freeBoardInsert", vo);
		}catch(Exception ex)
		{
			 ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close(); //connection닫기(반환)
		}
	}
}











