package com.sist.dao;
import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MovieDAO {
    private static SqlSessionFactory ssf; // XML을 읽기
    // 자동 초기화 ==> 클래스를 읽을때 자동으로 처리 
    static 
    {
    	try
    	{
    		// XML읽기 => 주석 => 한글을 읽기 (한글:2byte => Reader)
    		Reader reader=Resources.getResourceAsReader("Config.xml");
    		// Config => movie-mapper.xml,databoard-mapper.xml을 포함 
    		// Config.xml에 ~mapper.xml을 반드시 등록
    		// 파싱 : XML에 등록되어 있는 데이터중에 필요한 데이터를 읽어가는 과정 ==>SqlSessionFactory
    		ssf=new SqlSessionFactoryBuilder().build(reader);
    		// 프로그래머가 XML파싱을 하지 않고 => 라이브러리에 파싱 메소드가 있다 
    		// build ==> 파싱하는 메소드 (SAX) => 태그를 한개씩 읽어서 데이터만 추출 
    		// mybatis가 제공해준 태그,속성를 반드시 사용 ==> dtd (태그,속성 정의)
    		// Spring => XML에 필요한 데이터 저장 => Spring 라이브러리가 읽어가서 웹을 동작
    		/*
    		 *   XML을 이용하는 목적 
    		 *   => 자바 소스를 제공하지 않는다 => 동작에 필요한 데이터를 XML에 올려주면 읽어간다
    		 *   => 모든 라이브러리는 소스를 공개하지 않는다 (실행할수 있는 파일만 제공 .class)
    		 *   => 실무에도 배포할때 자바소스는 제공하지 않는다 (컴파일 .class만 제공)
    		 *   => 배포 (war) => jar(.class)
    		 */
    	}catch(Exception ex)
    	{
    		// XML에 에러를 처리
    		ex.printStackTrace();
    	}
    }
    // SQL문장을 읽어서 실행 => 요청한 데이터를 넘겨준다 (SQL => movie-mapper.xml)
    // <select id="movieListData" resultType="com.sist.dao.MovieVO" parameterType="hashmap">
    // sql문장 돌려서 출력된 결과랑 vo에 담긴 변수들이 어떻게 연결돼요
    /*
     *   SELECT no,poster,title
     *   FROM daum_movie;
     *   
     *   ==> no,poster,title ==> StringTokenizer => no,poster,title
     */
    public static List<MovieVO> movieListData(Map map)
    {
    	// map => start번호 , end번호
    	List<MovieVO> list=new ArrayList<MovieVO>();
    	// list에 값을 채운다 ==> home.jsp에 채워진 list값을 출력 
    	// 오라클 연결 
    	SqlSession session=null;
        // 실행 => 결과값 모아서 처리
    	try
    	{
    		// 연결
    		session=ssf.openSession(); // COMMIT을 사용여부 
    		/*
    		 *   INSERT,UPDATE,DELETE :오라클 저장된 데이터가 변경 => 다시 저장 요청 : COMMIT
    		 *   ssf.openSession() => COMMIT(X)
    		 *   ssf.openSession(true) => COMMIT(O)
    		 */
    		// SQL문장을 실행후에 데이터를 읽어서 list에 저장 
    		list=session.selectList("movieListData",map);
    	}catch(Exception ex)
    	{
    		// XML => 에러가 났을 경우에 어디서 발생했는지 확인
    		ex.printStackTrace();
    	}
    	finally
    	{
    		// 미리 생성된 Connection을 다시 사용하지 위해 반환 => DBCP
    		// DataBase Connection Pool(Connection을 관리하는 영역)
    		if(session!=null)
    			session.close();
    	}
    	return list;
    }
    // 총페이지 
    // <select id="movieTotalPage" resultType="int">
    public static int movieTotalPage()
    {
    	int total=0;
    	// 연결 
    	SqlSession session=null;
    	try
    	{
    		// 연결
    		session=ssf.openSession();
    		// SQL문장 실행한 결과값 받기
    		total=session.selectOne("movieTotalPage");
    	}catch(Exception ex)
    	{
    		// 에러 처리
    		ex.printStackTrace();
    	}
    	finally
    	{
    		// 닫기 => 자동으로 반환 
    		if(session!=null)
    			session.close();
    	}
    	return total;
    }
    // <select id="movieCategoryData" resultType="com.sist.dao.MovieVO" parameterType="int">
    public static List<MovieVO> movieCategoryData(int cateno)
    {
    	List<MovieVO> list=new ArrayList<MovieVO>();
    	// 연결
    	SqlSession session=null;
    	try
    	{
    		// 연결할 객체 얻기 
    		session=ssf.openSession();
    		// SQL문장 실행한후에 결과값을 받는다 
    		list=session.selectList("movieCategoryData",cateno);
    	}catch(Exception ex)
    	{
    		// 에러 처리
    		ex.printStackTrace();
    	}
    	finally
    	{
    		// 닫기
    		if(session!=null)
    			session.close();
    	}
    	return list;
    }
    // 상세보기 : XML에 코딩 => Mybatis에 처리 요청
    // <select id="movieDetailData" resultType="com.sist.dao.MovieVO" parameterType="int">
    // 처리는 DAO(자바) ==> 처리된 결과 브라우저에 전송 ==> JSP가 받아서 화면에 출력
    // JSP(링크) ==> movie-mapper.xml(SQL) ==> MovieDAO에서 SQL문장 실행 결과 ==> JSP
    // home                                                                detail
    public static MovieVO movieDetailData(int no)
    {
    	MovieVO vo=new MovieVO();
    	// 연결
    	SqlSession session=null;
    	try
    	{
    		// 연결 시도
    		session=ssf.openSession();
    		// SQL문장을 실행 => 결과값을 저장 
    		vo=session.selectOne("movieDetailData", no);
    	}catch(Exception ex)
    	{
    		// 에러 처리
    		ex.printStackTrace();
    	}
    	finally
    	{
    		// 닫기 ==> 재사용이 가능하게 반환
    		if(session!=null)
    			session.close();
    	}
    	return vo;
    }
}










