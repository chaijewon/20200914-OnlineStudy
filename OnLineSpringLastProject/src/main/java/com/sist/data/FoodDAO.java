package com.sist.data;
import java.util.*;
import java.sql.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.181:1521:XE";
	public FoodDAO()
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
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex){}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex){}
	}
    public void foodGategoryInsert(FoodCategoryVO vo)
    {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO food_category VALUES("
				  +"?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getTitle());
		   ps.setString(3, vo.getPoster());
		   ps.setString(4, vo.getSubject());
		   ps.setString(5, vo.getLink());
		   
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
    /*
     *   NO     NOT NULL NUMBER         
		CATENO          NUMBER         
		POSTER NOT NULL VARCHAR2(1000) 
		TITLE  NOT NULL VARCHAR2(200)  
		SCORE  NOT NULL VARCHAR2(5)    
		ADDR   NOT NULL VARCHAR2(200)  
		TEL    NOT NULL VARCHAR2(15)   
		TYPE   NOT NULL VARCHAR2(200)  
		PRICE           VARCHAR2(100)  
		MENU            VARCHAR2(500)  
		GOOD            NUMBER         
		SOSO            NUMBER         
		BAD             NUMBER 
     */
    public void foodDetailInsert(FoodVO vo)
    {
    	try
    	{
    		getConnection();
    		String sql="INSERT INTO food_detail VALUES("
    				  +"(SELECT NVL(MAX(no)+1,1) FROM food_detail),"
    				  +"?,?,?,?,?,?,?,?,?,?,?,?)";
    		ps=conn.prepareStatement(sql);
    		ps.setInt(1, vo.getCateno());
    		ps.setString(2, vo.getPoster());
    		ps.setString(3, vo.getTitle());
    		ps.setString(4, vo.getScore());
    		ps.setString(5, vo.getAddr());
    		ps.setString(6, vo.getTel());
    		ps.setString(7,vo.getType());
    		ps.setString(8, vo.getPrice());
    		ps.setString(9,vo.getMenu());
    		ps.setInt(10, vo.getGood());
    		ps.setInt(11, vo.getSoso());
    		ps.setInt(12, vo.getBad());
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
    public List<FoodCategoryVO> foodCategoryListData()
    {
    	List<FoodCategoryVO> list=
    			new ArrayList<FoodCategoryVO>();
    	try
    	{
    		getConnection();
    		String sql="SELECT no,link FROM food_category";
    		ps=conn.prepareStatement(sql);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			FoodCategoryVO vo=new FoodCategoryVO();
    			vo.setNo(rs.getInt(1));
    			vo.setLink(rs.getString(2));
    			list.add(vo);
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
}
