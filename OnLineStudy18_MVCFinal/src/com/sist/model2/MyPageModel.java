package com.sist.model2;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

public class MyPageModel {
	  @RequestMapping("mypage/mypage.do")
	  public String main_page(HttpServletRequest request)
	  {
		  request.setAttribute("msg", "MyPage.jsp");
		  return "../mypage/mypage.jsp";
	  }
}
