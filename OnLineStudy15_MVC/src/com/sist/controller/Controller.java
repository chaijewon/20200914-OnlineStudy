package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // XML파싱 , 파일읽기 => 생성자 역할 
	public void init(ServletConfig config) throws ServletException {
		//ServletConfig config => 등록 web.xml에 등록 (등록된 데이터를 읽을 수 있다)
	}

    /*
     *    사용자가 전송하는 방식(GET / POST) 
     *      메소드 처리가 달라 진다 
     *      GET ==> doGet()
     *      POST ==> doPost()
     *      ==================
     *        doGet()+doPost() => service()
     *        
     *      ### Servlet => 프로그래머가 구동하는 것이 아니라 톰캣이 구동한다 
     *         ================================================
     *         톰캣이 구동 => web.xml에 등록 (스프링=>web.xml에 등록)
     */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// /Controller?cmd=list  ==> ListModel ==> list.jsp
		String cmd=request.getParameter("cmd");
		String jsp="";
		if(cmd.equals("list"))
		{
			ListModel model=new ListModel();
			model.execute(request);
			jsp="view/list.jsp";
		}
		else if(cmd.equals("find"))
		{
			FindModel model=new FindModel();
			model.execute(request);
			jsp="view/find.jsp";
		}
		else if(cmd.equals("detail"))
		{
			DetailModel model=new DetailModel();
			model.execute(request);
			jsp="view/detail.jsp";
		}
		
		// 해당 JSP로 request전송 
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}

}

















