package com.sist.model;
import com.sist.dao.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
public class RecipeModel {
    public void recipeListData(HttpServletRequest request)
    {
    	// request => 사용자의 요청 정보 , 필요한 데이터를 첨부해서 사용 (setAttribute()) ==> JSP로 전송 
    	// 사용자가 요청한 페이지를 받는다 
    	String page=request.getParameter("page");
    	if(page==null)
    		page="1";
    	
    	// 데이터 읽기 
    	int curpage=Integer.parseInt(page); // 현재 보고 있는 페이지
    	Map map=new HashMap();
    	int rowSize=20;
    	int start=(rowSize*curpage)-(rowSize-1);
    	int end=rowSize*curpage;
    	
    	//map에 묵어서 전송 ==> mybatis가 읽어서 처리
    	map.put("start",start);
    	map.put("end", end);
    	List<RecipeVO> list=RecipeDAO.recipeListData(map);
    	for(RecipeVO vo:list)
    	{
    		String str=vo.getTitle();
    		if(str.length()>20)
    		{
    			str=str.substring(0,20);
    			str+="...";
    		}
    		vo.setTitle(str);
    	}
    	// 총페이지 
    	int totalpage=RecipeDAO.recipeTotalPage();
    	
    	// JSP로 받은 결과값을 전송 
    	request.setAttribute("list", list);
    	request.setAttribute("curpage", curpage);
    	request.setAttribute("totalpage", totalpage);
    	
    }
    
    public void chefListData(HttpServletRequest request)
    {
    	// 사용자 요청정보 받기 => page
    	String page=request.getParameter("page");
    	if(page==null)
    		page="1";
    	// 현재 페이지 
    	int curpage=Integer.parseInt(page);
    	// 현재 페이지 출력할 데이터 읽기
    	Map map=new HashMap();
    	int rowSize=50;
    	int start=(rowSize*curpage)-(rowSize-1);
    	int end=rowSize*curpage;
    	
    	map.put("start", start);
    	map.put("end",end);
    	List<ChefVO> list=RecipeDAO.chefListData(map);// 시작위치 , 마지막 위치
    	// 총페이지 
    	
    	int totalpage=RecipeDAO.chefTotalPage();
    	// curpage,totalpage,list => JSP
    	
    	request.setAttribute("list", list);
    	request.setAttribute("curpage", curpage);// 현재 페이지
    	request.setAttribute("totalpage", totalpage);// 총페이지
    	
    }
}









