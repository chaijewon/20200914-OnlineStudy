package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// DispatcherServlet : Spring 실제 Controller명
// XML에 등록된 클래스를 읽어서 메모리 할당 
import javax.xml.parsers.*;
import org.w3c.dom.*; //dom => 트리형태 
import java.util.*;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> clsList=new ArrayList<String>();

	/*
	 *    1. web.xml
	 *        = Framework 
	 *        = Spring , Struts , 사용자 , jsf
	 *    2. server.xml
	 *    3. Model ======> DAO 
	 *    4. JSP
	 */
	public void init(ServletConfig config) throws ServletException {
		// web.xml에 등록된 내용을 읽기 시작 (ServletConfig)
		/*
		 *   <init-param>
		      <param-name>contextConfigLocation</param-name>
		      <param-value>
		        <!-- 설정된 XML파일의 경로 -->
		        C:\Users\채제분\git\online\OnLineStudy17_MVC2\WebContent\WEB-INF\application-context.xml
		      </param-value>
		    </init-param>
		 */
		/*
		 *    <servlet>
				  <servlet-name>salesServlet</servlet-name>
				  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
				  <!-- contextLoader가 해당 위치의 설정 파일을 읽어, 해당 파일을 dispatcher servlet으로 만든다. -->
				  <init-param>
				    <param-name>contextConfigLocation</param-name>
				    <param-value>/WEB-INF/salesServlet-servlet.xml</param-value>
				  </init-param>
				  <load-on-startup>1</load-on-startup>
				</servlet>
				
				<!-- /sales로 시작하는 url 요청을 받아 salesServlet에서 처리한다. -->
				<servlet-mapping>
				  <servlet-name>salesServlet</servlet-name>
				  <url-pattern>*.naver</url-pattern>
				</servlet-mapping>
				
				.jsp .asp .aspx .php
				
				a.do/admin/1234  ==> node.js
				a.do?id=admin&pwd=1234

		 */
		String path=config.getInitParameter("contextConfigLocation");
		System.out.println(path);
		
		// 파싱 
		try
		{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();// 파싱하는 클래스 생성
			DocumentBuilder db=dbf.newDocumentBuilder();// 실제 XML파싱 
			// 파싱 => 메모리에 트리형태로 저장 ==> 필요한 데이터를 추가,수정,삭제,읽기
			// 파싱한 저장하는 공간 Document
			Document doc=db.parse(new File(path));
			// 최상위 태그 <beans> ==> 데이터베이스 (테이블)
			Element root=doc.getDocumentElement(); // root => beans
			// bean태그를 모아서 관리 ==> NodeList
			NodeList list=root.getElementsByTagName("bean");
			for(int i=0;i<list.getLength();i++)
			{
				Element bean=(Element)list.item(i); //bean태그를 한개씩 가지고 온다 
				String cls=bean.getAttribute("class");
				System.out.println(cls);
				clsList.add(cls);
			}
		}catch(Exception ex) {}
	}
    // 사용자가 요청할때 호출되는 메소드 => Model Class <==> JSP
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			// 사용자 요청값 받기  ==> movie/list.do
			String cmd=request.getRequestURI();
			// http://localhost/OnLineStudy17_MVC2/main/main.do  ==> URL
			// /OnLineStudy17_MVC2/main/main.do  ==> URI
			// /OnLineStudy17_MVC2  => ContextPath
			cmd=cmd.substring(request.getContextPath().length()+1);
			
			// 해당 모델 클래스를 찾는다 ==> 메소드를 호출한다 (invoke())
			// invoke() ==> 메소드는 프로그래머 마음대로 만들 수 있다
			for(String strCls:clsList) // clsList에 클래스명이 등록 (application-context.xml)
			{
				// 메모리 할당 
				// Class.forName() , new  ==> 리플렉션  
				// 리플렉션 ==> 클래스의 이름으로 정보를 읽어와서 제어 (젼수,메소드 호출...)
				// 단점 : OOP를 파괴
				Class clsName=Class.forName(strCls);
				Object obj=clsName.newInstance();
				// obj가 가지고 있는 메소드를 찾아서 호출 ==> request를 값을 담아준다 
				Method[] methods=clsName.getDeclaredMethods();
				// Annotation을 찾아서 밑에 있는 메소드를 호출 
				for(Method m : methods)
				{
					/*
					 *   @RequestMapping("main/main.do")
					 *   public String disp()
					 */
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					if(cmd.equals(rm.value()))
					{
						// invoke(Object obj, Object... args) => 다변매개변수 
						String jsp=(String)m.invoke(obj, request,response);
						
						// sendRedirect => request가 필요가 없는 경우 
						// forward => request에 들어가 있는 데이터 출력 
						// 화면 이동 
						if(jsp.startsWith("redirect"))
						{
							// return "redirect:list.do"
							// response
							response.sendRedirect(jsp.substring(jsp.indexOf(":")+1));
						}
						else
						{
							// return "main/main.jsp";
							// request전송 => RequestDispatcher
							RequestDispatcher rd=request.getRequestDispatcher(jsp);
							rd.forward(request, response);
						}
						return; // service 메소드 종료 
					}
				}
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}

}






