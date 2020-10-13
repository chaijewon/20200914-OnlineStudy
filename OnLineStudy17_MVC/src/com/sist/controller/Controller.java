package com.sist.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<String> list=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		list.add("com.sist.model.MovieModel");
		list.add("com.sist.model.ReserveModel");
		list.add("com.sist.model.MemberModel");
	}
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd=request.getRequestURI();
		// /OnLineStudy17_MVC/movie/detail.jsp
		// movie/detail.do
		cmd=cmd.substring(request.getContextPath().length()+1);
		// Annotation찾는 방법 
	}

}




