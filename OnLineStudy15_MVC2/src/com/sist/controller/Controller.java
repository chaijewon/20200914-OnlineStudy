package com.sist.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//////////////////////////////////////////////////
	String[] strCmd={
		"list",
		"detail",
		"insert"
	};
	String[] strClass={
		"com.sist.model.ListModel",
		"com.sist.model.DetailModel",
		"com.sist.model.InsertModel"
	};
	////////////////////////////////////////////////// XML
	// <bean id="list" class="com.sist.model.ListModel">
	private Map clsMap=new HashMap();
	public void init(ServletConfig config) throws ServletException {
		try
		{
			for(int i=0;i<strClass.length;i++)
			{
				Class cls=Class.forName(strClass[i]);
				Object obj=cls.newInstance();// 메모리 할당 (리플렉션)
				// 클래스명을 받아서 메모리 할당 => 모든 정보를 제어(메소드,생성자,멤버변수 제어)
				System.out.println(strCmd[i]+":"+obj);
				clsMap.put(strCmd[i], obj);
			}
		}catch(Exception ex){}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 사용자의 요청처리 
		 String cmd=request.getRequestURI();
		 System.out.println("cmd:"+cmd);
		 cmd=cmd.substring(request.getContextPath().length()+1,cmd.lastIndexOf("."));
		 System.out.println("cmd2:"+cmd);
		 
	}

}




