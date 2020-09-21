package com.sist.dao;
import java.sql.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	String url="jdbc:oracle:thin:@211.238.142.183:1521:XE";
        	//                                        181(X), 조별 IP
        	Connection conn=DriverManager.getConnection(url,"hr","happy");
        	PreparedStatement ps=conn.prepareStatement("SELECT * FROM dept");
        	ResultSet rs=ps.executeQuery();
        	while(rs.next())
        	{
        		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        	}
        }catch(Exception ex) 
        {
        	System.out.println(ex.getMessage());
        }
	}

}
