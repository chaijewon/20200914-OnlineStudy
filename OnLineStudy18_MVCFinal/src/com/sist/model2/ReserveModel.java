package com.sist.model2;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

public class ReserveModel {
	 @RequestMapping("reserve/reserve.do")
	  public String main_page(HttpServletRequest request)
	  {
		  request.setAttribute("msg", "Reserve.jsp");
		  return "../reserve/reserve.jsp";
	  }
}
