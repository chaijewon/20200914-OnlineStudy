package com.sist.model;
import javax.servlet.http.HttpServletRequest;

import com.sist.controller.*;
public class MainModel {
  @RequestMapping("main/main.do")
  public String main_page(HttpServletRequest request)
  {
	  request.setAttribute("msg", "Main.jsp");
	  return "../main/main.jsp";
  }
}
