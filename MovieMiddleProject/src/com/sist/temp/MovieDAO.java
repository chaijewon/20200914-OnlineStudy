package com.sist.temp;
import java.util.*;
import java.sql.*;
public class MovieDAO {
   private Connection conn;
   private PreparedStatement ps;
   public MovieDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex){}
   }
   public void getConnection()
   {
	   try
	   {
		   String url="jdbc:oracle:thin:@211.238.142.181:1521:XE";
		   conn=DriverManager.getConnection(url,"hr","happy");
	   }catch(Exception ex) {}
   }
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   public List<Integer> movieData()
   {
	   List<Integer> list=new ArrayList<Integer>();
	   try
	   {
		   getConnection();
		   String sql="SELECT no FROM movie_info";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   int no=rs.getInt(1);
			   list.add(no);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }
   public void theaterInsert(int no,String theater_no)
   {
	   try
	   {
		   getConnection();
		   String sql="UPDATE movie_info SET "
				     +"theater_no=? "
				     +"WHERE no=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1,theater_no);
		   ps.setInt(2, no);
		   ps.executeUpdate();
	   }catch(Exception ex) 
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   public String theaterInfoData(int no)
   {
	   String result="";
	   try
	   {
		   getConnection();
		   String sql="SELECT tname,tloc FROM theater_info "
				     +"WHERE tno=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   String tname=rs.getString(1);
		   String tloc=rs.getString(2);
		   result=tname+"("+tloc+")";
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   return result;
   }
}






