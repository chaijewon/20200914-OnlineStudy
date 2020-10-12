package com.sist.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/////// XML 파싱
import javax.xml.parsers.*;
import org.w3c.dom.*;
//////////////////////////
import com.sist.model.*;
// 연결 (Model <====> JSP)
/*
 *   Controller 등록 => web.xml
 */
import java.util.*;

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
	// 저장 (모델클래스 저장)
	private Map clsMap=new HashMap(); // 키 , 값
	public void init(ServletConfig config) throws ServletException {
		// web.xml에 등록된 => applicationContext.xml파일을 읽기 
		// web.xml에 설정된 데이터를 읽어오는 클래스 => ServletConfig
		String path=config.getInitParameter("contextConfigLocation");
		System.out.println(path);
		try
		{
			// XML읽기
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			// XML을 파싱할 수 있게 클래스 생성 
			DocumentBuilder db=dbf.newDocumentBuilder(); // 파싱기 
			// XML , WML , HDML (무선)
			// XML 읽어서 메모리에 저장 (저장공간 :Document)
			Document doc=db.parse(new File(path));
			// 최상위 태그 ==> 트리형태로 저장 
			Element root=doc.getDocumentElement();
			System.out.println(root.getTagName());// <beans>
			
			// bean => 태그 읽기
			// bean태그를 묶어서 사용 
			// 같은 태그를 묶을때 ==> NodeList
			NodeList list=root.getElementsByTagName("bean");
			/*
			 *    <bean id="list.do" class="com.sist.model.ListModel"/>
				  <bean id="detail.do" class="com.sist.model.DetailModel"/>
				  <bean id="insert.do" class="com.sist.model.InsertModel"/>
			 */
			for(int i=0;i<list.getLength();i++)
			{
				// bean 읽기 
				Element bean=(Element)list.item(i);
				String cmd=bean.getAttribute("id");
				String cls=bean.getAttribute("class");
				System.out.println("cmd="+cmd+",class="+cls);
				// 저장 
				// 클래스를 메모리 할당을 한다음에 키,주소
				Class clsName=Class.forName(cls);
				Object obj=clsName.newInstance(); // 클래스이름을 읽어서 메모리 할당 
				System.out.println("할당된 주소:"+obj);
				
				// 저장(Map)
				clsMap.put(cmd, obj);
			}
			/*
			 *   XML 파싱  => Spring,Mybatis ==> 파싱 클래스 
			 *   SI , SM , 솔루션 , 프레임워크 
			 *   =======   ============== xml을 파싱 
			 *   이미 만들어진 클래스 => 제작 
			 */
		}catch(Exception ex){}
	}
    // 사용자 요청 처리하는 메소드 
	// Callback함수다 
	// Callback => 프로그래머가 호출하는 메소드가 아니라 시스템에 위해서 자동 호출되는 메소드 
	// main()
	// 윈도우 => 이벤트 (콜백)
	// 프로그래머는 콜백을 함수를 만들 수 없어서 => 반드시 호출을 해야 한다 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 요청시에 처리가 되는 영역
		// http://localhost/OnLineStudy16_MVC1/list.do URL
		// 1. 사용자 요청을 받는다 
		String cmd=request.getRequestURI();// /OnLineStudy16_MVC1/list.do ==> URI
		//                                   =================== contextPath
		// 2. Model클래스 찾기 
		cmd=cmd.substring(request.getContextPath().length()+1); // list.do , detail.do
		
		Model model=(Model)clsMap.get(cmd); // if을 사용하지 않아도 된다 
		// 1,2을 처리하기 위해서 ==> 관련된 데이터를 Map에 저장 ==> clsMap에 저장된 클래스를 찾는다 
		// 3. Model를 통해서 요청처리 ==> 결과값을 request,session에 담는다
		String jsp=model.handlerRequest(request);// 처리후에 request에 값을 담아 준다 
		// 4. JSP를 찾는다 
		// 5. JSP로 request를 전송한다
		// request를 해당 JSP로 전송하는 클래스 => RequestDispatcher
		/*
		 *      Model 
		 *      
		 *      ==> return "board/list.jsp"
		 *      ==> return "redirect:list.do" => Spring
		 *      
		 *      insert_ok.jsp ==> list.jsp
		 *      update_ok.jsp
		 */
		if(jsp.startsWith("redirect"))
		{
			response.sendRedirect(jsp.substring(jsp.indexOf(":")+1));
			// 화면 이동 ==> sendRedirect() => request가 초기화 
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher(jsp);
			rd.forward(request, response);
			// 화면 이동 ==> forward  ===> request를 전송 => jsp에서 request에 담은 데이터를 받아서 출력 
		}
		
	}
    
}







