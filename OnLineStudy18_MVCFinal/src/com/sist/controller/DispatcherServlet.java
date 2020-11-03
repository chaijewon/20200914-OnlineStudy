package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
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
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
// C:\\Users\\채제분\\git\\online\\OnLineStudy18_MVCFinal\\src
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // Model를 저장 => 사용자 요청 => 찾아주는 역할 
	// Model class를 모아서 메모리 할당 => 찾기 
	List<String> clsList=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		String xmlPath=config.getInitParameter("contextConfigLocation");
		String path=config.getInitParameter("path");
		System.out.println("xml-path:"+xmlPath);
		System.out.println("path:"+path);
		try
		{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();// 파서기 생성
			Document doc=db.parse(new File(xmlPath));
			// 루트 태그
			Element root=doc.getDocumentElement();
			// 회원가입 , 로그인(세션) => 상세 => 쿠키 => 찜하기 , 예매처리 
			NodeList list=root.getElementsByTagName("component-scan");
			ComponentScan com=new ComponentScan();
			for(int i=0;i<list.getLength();i++)
			{
				Element cs=(Element)list.item(i);
				String pack=cs.getAttribute("base-package");
				List<String> cList=com.fileConfig(pack, path);
				for(String s:cList)
				{
					System.out.println(s);
					clsList.add(s);
				}
			}
			
		}catch(Exception ex) {}
		System.out.println("DispatcherServlet");
		for(String s:clsList)
		{
			System.out.println(s);
		}
	}
    // 요청 결과값 ==> 해당 JSP로 전송 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 메소드 찾아서 수행 => 결과값을 JSP로 전송
		// 사용자가 요청한 내용을 받는다 
		// http://localhost
		String cmd=request.getRequestURI();
		// main/main.do
		cmd=cmd.substring(request.getContextPath().length()+1);
		System.out.println(cmd);
		///OnLineStudy18_MVCFinal/
		try
		{
			// 메모리 할당  (Model클래스 메모리 할당) => clsList
			// new MainModel() ==> Controller (한개) ==> 공유 (수정을 하면 => 유지보수가 어렵다) => 고정
			// XML => C/Java/C#/JavaScript
			for(String cls:clsList)
			{
				Class clsName=Class.forName(cls);
				Object obj=clsName.newInstance();
				// MainModel m=new MainModel();
				/*
				 *     class A
				 *     class B
				 *     
				 *     //A a=new A();
				 *    // a=new B();
				 *    Object obj=new A();
				 *    obj=new B();
				 *    
				 *    public void display(int a,String s)
				 *    
				 *    display(10)
				 */
				// 메소드를 찾아서 호출 (invoke())
				Method[] methods=clsName.getDeclaredMethods();
				// 클래스에 선언된 모든 메소드를 가지고 온다 
				for(Method m:methods)
				{
					/*
					 *      public class A
					 *      {
					 *         public void display()
					 *         {
					 *         }
					 *      }
					 *      
					 *      A a=new A();
					 *      a.display();
					 *      
					 *      Class clasName=Class.forName("A")
					 *      Object obj=clsName.newInstance();
					 *      
					 *      Method[] m=clsName.getDeclareMethods();
					 *      m.invoke()
					 */
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					if(cmd.equals(rm.value()))
					{
						 String jsp="";
						 if(rm.value().equals("movie/detail_before.do"))
						 {
						     jsp=(String)m.invoke(obj, request,response);
						     // request=> cookie,session 생성 
						     
						     // response => cookie , upload
						 }
						 else
						 {
							 jsp=(String)m.invoke(obj, request);
						 }
								// a.display()
						if(jsp.startsWith("redirect"))
						{
							response.sendRedirect(jsp.substring(jsp.indexOf(":")+1));
							// return redirect:list.do
							// return "../main/main.jsp"
						}
						else
						{
							// request전송 
							RequestDispatcher rd=request.getRequestDispatcher(jsp);
							rd.forward(request, response);
						}
						return;// 종료 (response=>사용자에게 데이터 전송시 한번만 수행)
						
					}
				}
			}
			
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
	}

}





