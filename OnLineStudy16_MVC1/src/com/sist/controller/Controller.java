package com.sist.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /*
     *    서블릿 동작 
     *      = 메모리 할당 (생성자 호출) 
     *      = init() : 파일 읽기 , 서버연결 
     *      = service() : 사용자가 요청시 처리하는 메소드 
     *        ========= GET/POST ==> 동시에 처리가 가능한 메소드 
     *           GET  => doGet()
     *           POST => doPost()
     *      = destroy() : 할당된 메모리를 회수한다 
     *      
     *      == 새로고침,화면이동 ==> destroy() 호출 ==> 메모리 회수
     *         ==========================================  다시 원상복귀 (새로운 서블릿,JSP 생성)
     *         
     *         A a=new A(); ==> destroy() => 메모리는 사라진다 
     *         새로고침 , 화면이동 
     *         A a=new A(); ==> 새로운 메모리를 다시 만든다 (초기화)
     */
	// XML의 데이터를 읽어서 map에 저장 (Controller가 기억하고 있다가 => 요청 => 바로 모델클래스를 찾을 수 있게 한다)
	// Callback함수다 
	public void init(ServletConfig config) throws ServletException {
		
	}
    // 사용자 요청 처리하는 메소드 
	// Callback함수다 
	// Callback => 프로그래머가 호출하는 메소드가 아니라 시스템에 위해서 자동 호출되는 메소드 
	// main()
	// 윈도우 => 이벤트 (콜백)
	// 프로그래머는 콜백을 함수를 만들 수 없어서 => 반드시 호출을 해야 한다 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
    
}
