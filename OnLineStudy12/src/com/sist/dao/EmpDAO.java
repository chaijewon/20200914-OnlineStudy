package com.sist.dao;
import java.sql.*;
import java.util.*;
public class EmpDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@211.238.142.181:1521:XE";
   // 드라이버 등록
   public EmpDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");// 대소문자 구분 
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   // 오라클 연결
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {}
   }
   // 오라클 연결 해제
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null)
			   ps.close();
		   if(conn!=null)
			   conn.close();
	   }catch(Exception ex) {}
   }
   // Mybatis => Config.xml => Connection
   // 데이터 처리 => emp-mapper.xml에 존재 (SQL) => PreparedStatement
   /*
    *   Mybatis 
    *   ======= XML,Annotation
    */
   /*
    *     저장 방법 
    *     List (interface) => 자신이 생성이 불가능 => 인터페이스를 구현하고 있는 클래스를 이용해서 메모리 할당    
    *     ====          
    *      |  
    *    ArrayList(비동기 => 데이터베이스 연결시)   List<EmpVO> list=new ArrayList<EmpVO>();
    *    Vector(동기화 => 네트워크 사용자 정보)     List<EmpVO> list=new Vector<EmpVO>();
    *    LinkedList(C 언어와 호환)             List<EmpVO> list=new LinkedList<EmpVO>();
    *    => 순서가 존재 
    *    => 중복된 데이터를 저장 
    *    
    *    Set (interface)
    *    ===
    *     |
    *    TreeSet
    *    HashSet
    *    => 순서가 없다
    *    => 중복된 데이터를 사용할 수 없다 (사용빈도가 낮다)
    *    
    *    Map (interface)
    *    ===
    *     |
    *    HashMap => Hashtable의 단점을 보완 
    *    Hashtable 
    *    => 키와 값을 나눠서 저장 
    *    => 키는 중복이 없고 값은 중복이 가능 
    *    => 클래스를 미리 메모리할당을 하고 키를 이용해서 할당된 주소를 찾아서 사용 (Spring)
    *    => 웹에서 사용되는 request,response,session,cookie ==> Map방식을 이용 (키,값)
    *    
    *    ===============> Collection Framework : 데이터를 모아서 처리하기 쉽게 제공 (자료구조)
    *                     = 라이브러리 => 표준화
    */
   public List<EmpVO> empListData()
   {
	   List<EmpVO> list=new ArrayList<EmpVO>();// 순서가 필요 , 데이터를 중복 
	   // 예외처리 => 비정상 종료를 방지하는 프로그램 (에러 발생시 => 회피,점프)
	   try
	   {
		   // 정상수행문장 
		   // 연결
		   getConnection();
		   // SQL문장 전송 
		   String sql="SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD'),sal,dname,loc "
				     +"FROM emp,dept "
				     +"WHERE emp.deptno=dept.deptno";
		   ps=conn.prepareStatement(sql);
		   // 실행후에 결과값 읽기
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   EmpVO vo=new EmpVO();
			   vo.setEmpno(rs.getInt(1));
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
			   vo.setDbday(rs.getString(4));
			   vo.setSal(rs.getInt(5));
			   vo.setDname(rs.getString(6));
			   vo.setLoc(rs.getString(7));
			   
			   // 전체 => list에 첨부
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   //에러발생시 => 복구 
		   System.out.println(ex.getMessage());//에러 확인 => 프로그램을 수정할 목적 
	   }
	   finally
	   {
		   // 서버,데이터베이스 닫는 경우에 사용(무조건 수행문장)
		   disConnection();
	   }
	   return list;
   }
}







