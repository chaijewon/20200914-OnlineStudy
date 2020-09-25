package com.sist.dao;
//XML파싱후에 => 실행된 결과를 받는 위치=>DAO에서 메소드 호출 
import java.io.*;//XML파일 읽기 => Reader (한글파일)
import java.util.*;//List => 구현 (ArrayList)
/*
*    IO (Input,Output) : 데이터 입출력 
*    ==============================
*      1. 메모리 입출력 
*      2. 파일 입출력 
*      3. 네트워크 입출력 
*    ==============================
*    IO의 종류 (1byte,2byte)
*    1byte=> 바이트 스트림(파일 업로드,다운로드) => ~InputStream,~OutputStream
*    2byte=> 문자 스트림 (한글포함된 데이터 읽기) => ~Reader , ~Writer
*/

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class BoardDAO {
// XML을 파싱(데이터 읽기) => 읽은 데이터 저장 ==> SqlSesionFactory
private static SqlSessionFactory ssf;
// 초기화 => XML을 읽기(자동으로 셋팅)
static 
{
	   try
	   {
		   // 1. XML파일 읽기
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   // Config에 등록되어 있는 모든 XML파일 읽는다 
		   // 파일명에 대소문자를 구분한다
		   // 2. XML을 파싱 : 필요한 데이터 읽어 간다 (마이바티스 라이브러리가 읽어 간다) => 저장을 하고 사용한다
		   ssf=new SqlSessionFactoryBuilder().build(reader);
		   // 파싱 => SAX(읽기전용) => 태그를 한개씩 읽어와서 필요데이터를 저장하는 방식
		   /*
		    *    JAXP 
		    *      DOM :수정,읽기,삭제,추가 (메모리에서 저장)
		    *           => 속도가 늦다 
		    *      SAX : 읽기 => 일반적으로 모든 라이브러리는 SAX방식을 사용한다
		    *                   MyBatis,Spring...
		    *           => 속도가 빠르다 
		    *    JAXB : 빅데이터 (데이터 자바에 값을 채워준다)
		    *      binding
		    */
	   }catch(Exception ex)
	   {
		   // 에러처리 
		   System.out.println(ex.getMessage());
	   }   
}
// 목록 출력 ==> id="boardListData"
//            리턴형 : resultType            //매개변수 : parameterType
// select ==> selectList() : row가 여러개 일때 ,  selectOne() : row가 한개일때 
// 오라클==> 한줄 => row(record)
// <select id="boardListData" resultType="DataBoardVO" parameterType="hashmap">
public static List<BoardVO> boardListData(Map map)
{
	   List<BoardVO> list=new ArrayList<BoardVO>();
	   // Connection을 사용한 다음에 반드시 반환 ==> SqlSession
	   SqlSession session=null;
	   // SqlSession => Connection과 동일한 역할 수행 
	   // 컴파일 예외처리는 없다 => 초반에 에러처리하기 위해서 => 예외처리를 하는 것이 좋다 => null
	   try
	   {
		   // 실행 : 정상수행 : try수행 => finally수행
		   //      비정상  : 중간에 catch수행 => finally수행
		   // 1. 미리 만든 Connection객체를 얻어 온다 
		   session=ssf.openSession();
		   // 2. XML에 있는 SQL문장을 실행후에 결과값을 달라
		   list=session.selectList("freeboardListData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();//실행하는 과정을 보여준다 
	   }
	   finally
	   {
		   // 반환 => Connection=>close()
		   if(session!=null)
			   session.close(); 
		   /*
		    *   close()
		    *   {
		    *     if(ps!=null) ps.close();
		    *     if(conn!=null) conn.close(); ==> disConnection()
		    *   }
		    */
	   }
	   return list;
  }
}