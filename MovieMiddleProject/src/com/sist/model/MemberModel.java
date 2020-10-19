package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;
import com.sist.dao.MemberDAO;
/*
 *     request ==> main.jsp
 *     ** 파일이 include가 되면 request를 공유
 *     ** request => forward,include
 */
public class MemberModel {
   @RequestMapping("member/join.do")
   public String member_join(HttpServletRequest request)
   {
	   request.setAttribute("main_jsp", "../member/join.jsp");//include(메인에 들어갈 파일 지정)
	   return "../main/main.jsp";//include
   }
   @RequestMapping("member/idcheck.do")
   public String member_idcheck(HttpServletRequest request)
   {
	   return "../member/idcheck.jsp";// 새로운 창을 연다 ==> Ajax 
   }
   @RequestMapping("member/idcheck_ok.do")
   public String member_idcheck_ok(HttpServletRequest request)
   {
	    String id=request.getParameter("id");
	    // DB연동
	    int count=MemberDAO.memberIdCheck(id);
	    request.setAttribute("count", count);
	    return "../member/idcheck_ok.jsp";
   }
   @RequestMapping("member/join_ok.do")
   public String member_join_ok(HttpServletRequest request)
   {
	   return "redirect:../main/main.do";
   }
}






