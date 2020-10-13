package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

/*
 *   1. 회원가입
 *   2. 로그인 
 */
public class MemberModel {
	@RequestMapping("member/join.do")
    public String memberJoin(HttpServletRequest request)
    {
    	request.setAttribute("msg", "회원가입");
    	return "../member/join.jsp";
    }
	@RequestMapping("member/login.do")
    public String memberLogin(HttpServletRequest request)
    {
    	request.setAttribute("msg", "로그인");
    	return "../member/login.jsp";
    }
}
