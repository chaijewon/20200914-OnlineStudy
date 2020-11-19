package com.sist.board.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection conn;
    private CallableStatement cs;
    private String driver,url,username,password;
    public DBConnection(String driver,String url,String username,String password)
    {
    	this.driver=driver;
    	this.url=url;
    	this.username=username;
    	this.password=password;
    	
    	try
    	{
    		Class.forName(driver);
    	}catch(Exception ex){}
    }
    public void getConnection()
    {
    	try
    	{
    		conn=DriverManager.getConnection(url,username,password);
    	}catch(Exception ex){}
    }
    public void disConnection()
    {
    	try
    	{
    		if(conn!=null) conn.close();
    		if(cs!=null) cs.close();
    	}catch(Exception ex){}
    }
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public CallableStatement getCs() {
		return cs;
	}
	public void setCs(CallableStatement cs) {
		this.cs = cs;
	}
    
}





