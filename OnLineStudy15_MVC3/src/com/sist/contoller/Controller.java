package com.sist.contoller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// XML ==> Annotation
import java.util.*;
import com.sist.model.*;
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /*
     *   매칭  ==> ListModel == list.jsp   (list.jsp)
     *           DetailModel == detail.jsp (detail.jsp)
     *                                    요청처리 (Model)
     *   클라이언트 =============> Controller ======> Model <=====> DAO
     *          요청 (request)    (request)        결과값을 request에 담는다
     *                              |       <===== 
     *                              |      request
     *                              |
     *                             JSP    request.setAttribute()
     *                             => request.getAttribute() ===> ${}
     *                             
     *       request       request    request       request  ==> session(로그인,장바구니)
     *   JSP ==> Controller ==> Model ==> Controller ==> JSP
     *   ======                =======    ==========     ===
     *    요청                                     요청처리        결과값                 출력
     */
	// 1. 클라이언트가 Controller 요청을 하면 ==> 요청을 처리하는 Model클래스 찾기
	// Controller가 어떤 요청인지 알 수가 없다 => 인식
	// list ==> ListModel 
	// detail ==> DetailModel
	private Map clsMap=new HashMap();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청을 받는다  ==> list,detail
		// 2. http://localhost/OnLineStudy15_MVC/(list).do
		// 3. http://localhost/OnLineStudy15_MVC/(detail).do
		// 4. http://localhost/OnLineStudy15_MVC/Controller?cmd=list
		String cmd=request.getRequestURI();///OnLineStudy15_MVC/(list).do 
		// URI ==> /OnLineStudy15_MVC/list.do(?page=2)=> request에 따로 설정
		System.out.println(cmd);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		clsMap.put("list",new ListModel());
		clsMap.put("detail", new DetailModel());// 싱글턴 
	}
    
   

}


