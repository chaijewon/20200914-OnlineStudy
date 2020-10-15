package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

public class ReserveModel {
  @RequestMapping("reserve/reserve.do")
  public String reserve_main(HttpServletRequest request)
  {
	  request.setAttribute("main_jsp", "../reserve/reserve.jsp");
	  return "../main/main.jsp";
  }
}
