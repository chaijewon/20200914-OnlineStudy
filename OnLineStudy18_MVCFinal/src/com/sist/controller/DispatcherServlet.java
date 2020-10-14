package com.sist.controller;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *   MVC 
 *   M = Model => 요청처리(데이터베이스 연결) 결과값을 가지고 오는 역할 (request에 값을 담는다)
 *   V = View  => 요청 결과값을 받아서 출력 
 *   C = Controller => Model을 연결해서 결과값을 가지고 온후에 JSP 결과값을 전송
 *   
 *   일반 자바 (Model) <========> JSP,서블릿 통신
 *                 request,session
 *                 request.setAttribute(),session.setAttribute()
 *                 ====================== ======================
 *                   한개의 JSP에서 사용              프로젝트 전체 JSP에서 공유
 *                                                              request
 *    사용자 요청 (.do)  ========> Controller(DispatcherServlet) ============= 
 *                      ##service메소드 => 톰캣에 의해 호출 => 쓰레드로 제작 
 *                    request       service(HttpServletRequest request)
 *                    
 *                             데이터 요청 
 *    Model (request)     <===============> DAO,Manager
 *     요청데이터를 받아서 처리           처리된 결과값을 보내준다
 *     요청결과값을 받아서 
 *      request에 첨부 
 *      ============
 *      request.setAttribute() ===========> Controller ==========> 해당 JSP전송 ==== JSP에서는 
 *                                                                          request에 있는 데이터 출력
 *                                          ==> 해당 JSP에 request
 *                                          forward(request,response)
 *                                          sendRedirect("파일명") ==> _ok.jsp
 *                         ==> request에 있는 데이터를 출력  forward(request를 전송)
 *                             request에 있는 데이터를 출력하지 않는 경우 request를 버리고 다른 파일로 이동 
 *                             
 *    Controller : Model에 있는 메소드를 찾기 ==> 실행  ==> 메소드실행결과를 JSP로 전송
 *                 ====================
 *                 조건문 , Annotataion (자유롭다:메소드명을 통일하지 않는다) 
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // Model를 저장 => 사용자 요청 => 찾아주는 역할 
	public void init(ServletConfig config) throws ServletException {
		
	}
    // 요청 결과값 ==> 해당 JSP로 전송 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
