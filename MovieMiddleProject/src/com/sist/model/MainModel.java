package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

public class MainModel {
  @RequestMapping("main/main.do")
  public String main_page(HttpServletRequest request)
  {
	  request.setAttribute("msg", "Main페이지");
	  return "../main/main.jsp";
  }
}
