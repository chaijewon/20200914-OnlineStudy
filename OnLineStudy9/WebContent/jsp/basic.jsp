<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- basic.jsp 
     1. appication 객체 
        ServletContext의 객체명 
        = 서버와 관련 
                   서버에 대한 정보 
        = 로그정보 (log())
        = 디렉토리 정보 (getRealPath()) => 톰캣이 읽어가는 실제 경로명 
        = 서버파일을 읽을 수 있는 권한 (web.xml) => 서블릿 등록 , 에러등록 
          getInitParamter() 
          
        ====== 프로젝트 (MVC) 
        1. 이번주까지 (9.25) DB완료 => 데이터수집
        2. 다음주 (28,29) => 템플릿 (크롬=>무료 웹템플릿)
        3. 10.5~10.9 => Controller
                        ==========
                        model 1 => JSP안에서 자바+HTML
                        ===============================> 바로 스프링의 구조
                        model 2 => HTML ==> View
                                   JAVA ==> Model
                                   ===== 연결 => Controller(서블릿) ==> MVC
                      =================================================== JSP
                                            프로젝트가 종료 => Spring(11부터)
                        Spring 형식(구조)       
                      ====================================================
                      11월 아이템 설정 ==> 실제 Spring(새롭게)
                      ================================= Kotlin에 올리면
                      JSP ==> 포폴 => 올려준다 
                      1. JSP (MVC) *************
                         => MyBatis (DB 연동)
                      2. Spring    *************
                         => 최신 기술 (React,Vue,NodeJS) : 지능형 웹
                      3. 개인 프로젝트(Kotlin) *****
                      ==================================
                           
        4. 10.12~10말까지 구현 
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%--
         Application 객체 : 서버 정보 
                 서버 관련 메소드
           getServerInfo() : 서버의 이름을 가지고 올때  ==> Tomcat8.5
           getMajorVersion() 
           getMinorVersion() 
           
           3.1 Minor
          == ==
          Major
   --%>
   <center>
     <h1>서버 정버</h1>
     <ul>
      <li>서버정보:<%=application.getServerInfo() %></li>
      <li>메이저:<%=application.getMajorVersion() %></li>
      <li>마이너:<%=application.getMinorVersion() %></li>
     </ul>
     <h1>web.xml에 존재하는 데이터베이스 정보를 출력</h1>
     <ul>
       <%--
            <param-name>driver</param-name> : 키
            <param-value>oracle.jdbc.driver.OracleDriver</param-value> : 값
        --%>
       <li>데이터베이스(Driver):<%= application.getInitParameter("driver") %></li>
       <li>데이터베이스(URL):<%=application.getInitParameter("url") %></li>
       <li>데이터베이스(USERNAME):<%=application.getInitParameter("username") %></li>
       <li>데이터베이스(Password):<%=application.getInitParameter("password") %></li>
     </ul>
     <%--
                   서버 => 로그파일 ==> 로그를 만드는 방식 : application
      --%>
      <%
          String driver=application.getInitParameter("driver");
          String url=application.getInitParameter("url");
          String username=application.getInitParameter("username");
          String password=application.getInitParameter("password");
          
          application.log("driver:"+driver);
          application.log("url:"+url);
          application.log("username:"+username);
          application.log("password:"+password);
      %>
     <%--
        C:\webDev\webStudy\OnLineStudy9\WebContent\jsp\basic.jsp : 가상주소
        => 프로그래머가 편집이 가능하게 만들어 주는 위치 
        
        C:\webDev\webStudy\.metadata\.plugins\org.eclipse.wst.server.core\
        tmp0\wtpwebapps\OnLineStudy9\jsp\basic.jsp
        => 톰캣이 읽어가는 실제 경로명 (그림)
      --%>
      <h1>실제 경로명</h1>
      <%= application.getRealPath("/jsp") %>
      
      <%--
           application 
            = getInitParameter()
            = getRealPath()
            = log()
       --%>
   </center>
</body>
</html>






