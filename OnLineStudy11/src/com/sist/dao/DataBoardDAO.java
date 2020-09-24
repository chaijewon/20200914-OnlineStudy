package com.sist.dao;
// XML파싱후에 => 실행된 결과를 받는 위치=>DAO에서 메소드 호출 
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
public class DataBoardDAO {
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
   public static List<DataBoardVO> boardListData(Map map)
   {
	   List<DataBoardVO> list=new ArrayList<DataBoardVO>();
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
		   list=session.selectList("boardListData",map);
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
   // 총페이지 ==> id="boardTotalPage"
   // <select id="boardTotalPage" resultType="int">
   public static int boardTotalPage()
   {
	   // 지역변수는 반드시 초기화 
	   /*
	    *    클래스 => null
	    *    String => null
	    */
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   // 1. connection 객체를 가지고 온다 
		   session=ssf.openSession();
		   total=session.selectOne("boardTotalPage");
	   }catch(Exception ex)
	   {
		    ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)//연결이 되어 있다면 
			   session.close(); // 연결을 종료 (자동으로 반환 => 반환 다시 사용이 가능)
	   }
	   return total;
   }
   // 데이터 추가 
   //          resultType        parameterType
   public static void boardInsert(DataBoardVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   // 미리 만들어 둔 Connection
		   /*
		    *   autoCommit설정 
		    *   ssf.openSession(); // commit이 없는 경우
		    *   ssf.openSession(true);..autoCommit설정 
		    */
		   session=ssf.openSession(true);// commit을 실행한다 
		   // INSERT,UPDATE,DELETE => 데이터베이스 변경 => 반드시 COMMIT
		   session.insert("boardInsert",vo);
		   // 여러개의 SQL문장을 실행하면 
		   //session.commit();
	   }catch(Exception ex)
	   {
		   // 에러 처리 
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null) // 오라클에 연결되어 있다면 
			   session.close();
	   }
   }
   // 상세보기 
   /*
    *   상세보기 => VO (VO:게시물 한개에 전체 정보)
    *   목록,찾기 => VO가 여러개 => ArrayList
    *   no => Primary Key (중복이 없는 데이터)
    *   =================================================================
    *   오라클 : 데이터 저장 (영구적) => 모든 유저가 공통으로 볼 수 있는 내용 저장 => 저장용도 
    *          => 필요한 데이터를 가지고 오려면 SQL문장  
    *   자바 : 오라클 ,웹 연결해서 사용자가 요청한 데이터 가지고 오는 역할 => 데이터 관리 
    *   JSP : 사용자 요청한 데이터를 출력 
    *   =================================================================
    *   웹안에서 처리 (자바로 사용할 수 없다 , 자바스크립트) : Modal(팝업창), 입력이 안된 경우 처리 , 실시간
    */
   public static DataBoardVO boardDetailData(int no)
   {
	   // 데이터를 받을 변수 설정 
	   DataBoardVO vo=new DataBoardVO();
	   // 오라클 연결 
	   SqlSession session=null;// Connection => SqlSession안에 Connection기능을 가지고 있다 
	   // 데이터를 가지고 오는 과정 에러가 발생할 수 있다 => 사전에 에러방지 프로그램 => 예외처리 
	   /*
	    *    예외처리 
	    *     = 직접 처리 (에러가 발생하면 바로 처리해서 사용) try~catch
	    *     = 간접처리 (시스템 에러발생여부만 확인하고 에러 회피) throws 
	    */
	   try
	   {
		   // 정상적으로 실행 => 에러 => catch를 수행하고 점프 
		   // 연결 
		   session=ssf.openSession(); // Commit을 포함하지 않는다 
		   // 작업 수행 
		   // 1. 조회수 증가 
		   // <update id="hitIncrement" parameterType="int">
		   session.update("hitIncrement",no);
		   session.commit();// 포함이 안되면 조회수가 증가를 하지 않는다 
		   // 2. 증가된 조회수를 포함해서 데이터 가지고 오기
		   // <select id="boardDetailData" resultType="DataBoardVO" parameterType="int">
		   vo=session.selectOne("boardDetailData", no);
		   /*
		    *   COMMIT => 저장된 데이터가 변경,추가 ,삭제  => 다시 저장 
		    *             SELECT : 검색 
		    */
		   /*
		    *   <select> 
		    *      = 목록(여러개) => selectList("id명")
		    *      = 한개 => selectOne("id명")
		    *   =================================
		    *   <insert>
		    *      = insert("id명")
		    *   <update>
		    *      = update("id명")
		    *   <delete>
		    *      = delete("id명")
		    *   ================================= 반드시 COMMIT처리를 해야된다 
		    */
	   }catch(Exception ex)
	   {
		   // 에러가 났을 경우에 처리 (복구) 
		   ex.printStackTrace();//어떤 에러가 났는지 확인 
	   }
	   finally
	   {
		   // 정상수행 ,비정상 수행 상관없이 => 무조건 수행 (서버연결 해제,데이터베이스 연결 해제)
		   if(session!=null) // 연결되어 있다면
			   session.close();  // ps.close(), conn.close() => disConnection()
	   }
	   
	   return vo;// 사용자가 요청한 데이터를 받아 볼 수 있다
   }
}









