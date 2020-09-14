package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDAO {
  // 오라클 연결
  private Connection conn;
  // SQL문장 전송 
  private PreparedStatement ps;
  // 오라클 주소 설정 
  private final String URL="jdbc:oracle:thin:@211.238.142.181:1521:XE";
  // 오라클 연결 => 드라이버를 등록 (한번만 수행 => 생성자)
  public EmpDAO()
  {
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	  }catch(Exception ex) {}
  }
  // 연결 
  public void getConnection()
  {
	  try
	  {
		  // 오라클에 conn hr/happy
		  conn=DriverManager.getConnection(URL,"hr","happy");
	  }catch(Exception ex) {}
  }
  // 닫기 
  public void disConnection()
  {
	  try
	  {
		  if(ps!=null)ps.close();
		  if(conn!=null) conn.close();
	  }catch(Exception ex) {}
  }
  
  public ArrayList<EmpVO> empListData()
  {
	  ArrayList<EmpVO> list=
			  new ArrayList<EmpVO>();
	  try
	  {
		  getConnection();
		  String sql="SELECT empno,ename,job,hiredate,sal "
				    +"FROM emp";
		  // 전송
		  ps=conn.prepareStatement(sql);
		  // 실행 결과 값 받기
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  EmpVO vo=new EmpVO();
			  vo.setEmpno(rs.getInt(1));
			  vo.setEname(rs.getString(2));
			  vo.setJob(rs.getString(3));
			  vo.setHiredate(rs.getDate(4));
			  vo.setSal(rs.getInt(5));
			  
			  list.add(vo);
		  }
		  rs.close();
	  }catch(Exception ex) {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  disConnection();
	  }
	  return list;
  }
}
