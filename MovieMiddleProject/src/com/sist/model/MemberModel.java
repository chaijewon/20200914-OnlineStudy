package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;
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
	   return "../main/main.jsp";
   }
}
