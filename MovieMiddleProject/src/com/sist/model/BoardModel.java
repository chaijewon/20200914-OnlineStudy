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
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;
import com.sist.vo.ReplyVO;
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
	   for(BoardVO vo:list)
	   {
		   int rc=BoardDAO.replyCount(vo.getNo());
		   vo.setReplyCount(rc);
	   }
	   
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
   
   @RequestMapping("board/detail.do")
   public String board_detail(HttpServletRequest request)
   {
	   String no=request.getParameter("no");
	   // DB연동
	   BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
	   // 데이터 전송
	   request.setAttribute("vo", vo);
	   // 화면 
	   request.setAttribute("main_jsp", "../board/detail.jsp");
	   
	   List<ReplyVO> list=BoardDAO.replyListData(Integer.parseInt(no));
	   
	   request.setAttribute("rList", list);
	   return "../main/main.jsp";
   }
   // 게시물에 댓글 
   @RequestMapping("board/reply_insert.do")
   public String reply_insert(HttpServletRequest request)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
		   
	   }catch(Exception ex) {}
	   String bno=request.getParameter("bno");
	   String msg=request.getParameter("msg");
	   HttpSession session=request.getSession();
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   // VO에 담아서 => DAO
	   ReplyVO vo=new ReplyVO();
	   vo.setBno(Integer.parseInt(bno));
	   vo.setId(id);
	   vo.setMsg(msg);
	   vo.setName(name);
	   // DAO연결 
	   BoardDAO.replyInsert(vo);
	   return "redirect:../board/detail.do?no="+bno;
   }
   @RequestMapping("board/reply_reply_insert.do")
   public String reply_reply_insert(HttpServletRequest request)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex) {}
	   String no=request.getParameter("no");
	   System.out.println("no="+no);
	   String bno=request.getParameter("bno");
	   System.out.println("bno="+bno);
	   String msg=request.getParameter("msg");
	   ReplyVO vo=new ReplyVO();
	   //vo.setRoot(Integer.parseInt(no));
	   vo.setBno(Integer.parseInt(bno));
	   vo.setMsg(msg);
	   HttpSession session=request.getSession();
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   vo.setId(id);
	   vo.setName(name);
	   // DB연동 
	   BoardDAO.replyReplyInsert(Integer.parseInt(no), vo);
	   return "redirect:../board/detail.do?no="+bno;
   }
   
   @RequestMapping("board/reply_update.do")
   public String reply_update(HttpServletRequest request)
   {
	   // 데이터 받기
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex) {}
	   String no=request.getParameter("no");
	   String bno=request.getParameter("bno");
	   String msg=request.getParameter("msg");
	   // DB => UPDATE
	   ReplyVO vo=new ReplyVO();
	   vo.setNo(Integer.parseInt(no));
	   vo.setMsg(msg);
	   
	   BoardDAO.replyUpdate(vo);
	   return "redirect:../board/detail.do?no="+bno;
   }
   
   @RequestMapping("board/reply_delete.do")
   public String reply_delete(HttpServletRequest request)
   {
	   // 데이터 받기
	  
	   String no=request.getParameter("no");
	   String bno=request.getParameter("bno");
	   BoardDAO.replyDelete(Integer.parseInt(no));
	   return "redirect:../board/detail.do?no="+bno;
   }
}






