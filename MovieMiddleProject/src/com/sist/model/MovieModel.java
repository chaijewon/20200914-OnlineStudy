package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class MovieModel {
   @RequestMapping("movie/real.do")
   public String movie_real(HttpServletRequest request)
   {
	   // 두개의 데이터를 받는다 (페이지,카테고리번호)
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   String cateno=request.getParameter("cateno");
	   // Map 
	   // 현재 페이지 
	   int curpage=Integer.parseInt(page);
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   // Map에 저장 
	   Map map=new HashMap();
	   map.put("cateno", cateno);
	   map.put("start", start);
	   map.put("end", end);
	   // 데이터베이스 연결 
	   List<MovieVO> list=MovieDAO.movieListData(map);
	   // 총페이지 
	   int totalpage=MovieDAO.movieTotalPage(Integer.parseInt(cateno));
	   
	   // JSP에서 필요한 데이터를 보내기 시작 
	   // request에 값을 채운다 
	   request.setAttribute("list", list);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   // include 파일 지정
	   request.setAttribute("main_jsp", "../movie/real.jsp");
	   return "../main/main.jsp";
   }
   @RequestMapping("movie/sch.do")
   public String movie_sch(HttpServletRequest request)
   {
	// 두개의 데이터를 받는다 (페이지,카테고리번호)
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   String cateno=request.getParameter("cateno");
	   // Map 
	   // 현재 페이지 
	   int curpage=Integer.parseInt(page);
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   // Map에 저장 
	   Map map=new HashMap();
	   map.put("cateno", cateno);
	   map.put("start", start);
	   map.put("end", end);
	   // 데이터베이스 연결 
	   List<MovieVO> list=MovieDAO.movieListData(map);
	   // 총페이지 
	   int totalpage=MovieDAO.movieTotalPage(Integer.parseInt(cateno));
	   
	   // JSP에서 필요한 데이터를 보내기 시작 
	   // request에 값을 채운다 
	   request.setAttribute("list", list);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	// include 파일 지정
	   request.setAttribute("main_jsp", "../movie/sch.jsp");
	   return "../main/main.jsp";
   }
   @RequestMapping("movie/box.do")
   public String movie_box(HttpServletRequest request)
   {
	// 두개의 데이터를 받는다 (페이지,카테고리번호)
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   String cateno=request.getParameter("cateno");
	   // Map 
	   // 현재 페이지 
	   int curpage=Integer.parseInt(page);
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   // Map에 저장 
	   Map map=new HashMap();
	   map.put("cateno", cateno);
	   map.put("start", start);
	   map.put("end", end);
	   // 데이터베이스 연결 
	   List<MovieVO> list=MovieDAO.movieListData(map);
	   // 총페이지 
	   int totalpage=MovieDAO.movieTotalPage(Integer.parseInt(cateno));
	   
	   // JSP에서 필요한 데이터를 보내기 시작 
	   // request에 값을 채운다 
	   request.setAttribute("list", list);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	// include 파일 지정
	   request.setAttribute("main_jsp", "../movie/box.jsp");
	   return "../main/main.jsp";
   }
   @RequestMapping("movie/news.do")
   public String movie_news(HttpServletRequest request)
   {
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=20;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   map.put("start",start);
	   map.put("end", end);
	   List<NewsVO> nList=MovieDAO.movieNewsData(map);
	   // 총페이지 
	   int totalpage=MovieDAO.newsTotalPage();
	   
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   request.setAttribute("nList", nList);
	   // include => news.jsp
	   request.setAttribute("main_jsp", "../movie/news.jsp");// ${}
	   return "../main/main.jsp";
   }
   @RequestMapping("movie/total.do")
   public String movie_total(HttpServletRequest request)
   {
	   // 데이터 읽어서 => jsp 전송(데이터베이스)
	   // 페이지 
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end",end);
	   List<MovieVO> list=MovieDAO.movieTotalData(map);
	   int totalpage=MovieDAO.movieTotalPage2();
	   
	   int BLOCK=5;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   /*
	    *   1 , 2 , 3 , 4 , 5 ==> 1
	    *   ==> 12345
	    *   2/5
	    *   4/5 => 0
	    *   
	    *   6 7  8  9  10  ==> 6
	    */
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   /*
	    *    1 2 3 4 5 ==> 5
	    *    6 7  8  9  10  ==> 10
	    */
	   // 12 => totalpage  11 ~ 15
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   request.setAttribute("list", list);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   request.setAttribute("BLOCK", BLOCK);
	   request.setAttribute("startPage", startPage);
	   request.setAttribute("endPage", endPage);
	   request.setAttribute("main_jsp", "../movie/total.jsp");
	   return "../main/main.jsp";
   }
   @RequestMapping("movie/detail.do")
   public String movie_detail(HttpServletRequest request)
   {
	   // 사용자가 보내준 데이터 읽기
	   String no=request.getParameter("no");
	   String page=request.getParameter("page");
	   String cno=request.getParameter("cno");
	   if(page==null)
		   page="1";
	   /*
	    *    detail.do
	    *    ==> page==null
	    *    if(page==null)
	    *    detail.do? page= 10   ==>  " 10"  ${ vo.no }
	    *    ==> page ""
	    *    if(page.equals(""))
	    */
	   // 상세보기 데이터 읽기 
	   // DataBase연결
	   
	   request.setAttribute("main_jsp", "../movie/detail.jsp");
	   return "../main/main.jsp";
   }
}







