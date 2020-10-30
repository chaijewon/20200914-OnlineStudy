package com.sist.model;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
/*
 *   1. table 제작 (오라클)
 *   2. mapper , Config에 등록 
 *   3. DAO 셋팅
 *   ============================
 *   4. jsp
 *   5. Model
 *   
 *   Controller (DispatcherServlet)
 *     |
 *   Model <===> DAO
 *     | request,session
 *    jsp(View)   ============> MVC
 *    === 출력
 *            request               request  
 *    list.do  ===> DispatcherServlet ==> Model  ====> DAO
 *                                    <==
 *             <===                  request
 *             request
 *    =======
 *      요청 
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;
public class BoardModel {
   @RequestMapping("board/list.do")
   public String board_list(HttpServletRequest request)
   {
	   // jsp => 데이터 전송 (오라클 연동 => DAO)
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*curpage)-(rowSize-1);// rownum (0=>1)
	   int end=rowSize*curpage;
	   
	   map.put("start", start);
	   map.put("end",end);
	   
	   List<BoardVO> list=BoardDAO.boardListData(map);
	   
	   // 총페이지 읽기
	   int totalpage=BoardDAO.boardTotalPage();
	   
	   // board/list.jsp => List를 전송 
	   request.setAttribute("list", list);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   // include
	   request.setAttribute("main_jsp", "../board/list.jsp");
	   
	   Date date=new Date();
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	   String today=sdf.format(date);
	   
	   request.setAttribute("today", today);
	   return "../main/main.jsp";//include
   }
   @RequestMapping("board/insert.do")
   public String board_insert(HttpServletRequest request)
   {
	   request.setAttribute("main_jsp", "../board/insert.jsp");
	   return "../main/main.jsp";
   }
   
   @RequestMapping("board/insert_ok.do")
   public String board_insert_ok(HttpServletRequest request)
   {
	   try {
			request.setCharacterEncoding("UTF-8");
		   } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	    String name=request.getParameter("name");
	    String subject=request.getParameter("subject");
	    String content=request.getParameter("content");
	    String pwd=request.getParameter("pwd");
	   
	    BoardVO vo=new BoardVO();
	    vo.setName(name);
	    vo.setSubject(subject);
	    vo.setContent(content);
	    vo.setPwd(pwd);
	    
	    // DAO로 전송 
	    BoardDAO.boardInsert(vo);
	   return "redirect:../board/list.do";
   }
}






