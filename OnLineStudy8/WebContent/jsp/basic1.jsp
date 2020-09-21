<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      default => EUC-KR 
           반드시 변경(UTF-8) : java,css,jsp,html,xml => github시 한글이 정상적으로 된다 
      contenType ==> 톰캣이 실행하고 => 결과값 ?
      ========== text/html,text/xml
                 ========= ========
                                 화면을 출력   문서만 저장 
      import : 기존에 있는 클래스를 읽어 올때 
      errorPage : 에러가 났을 경우에 지정된 파일로 이동 
                  프로그램을 만들때 : 서버에서 보내는 파일 출력 
              404 : 사용자가 파일명을 보내줄때 => 서버에 파일이 존재하지 않는 경우
                                     프로그래머가 실수로 링크시에 파일명을 틀리게 만드 경우가 많다 
              500 : 톰캣이 jsp파일을 자바로 변경후에 컴파일 에러 
                                     소스코딩의 문제 발생 
              400 : 데이터 전송시에 잘못된 데이터가 전송된 경우
                                   예) IE에서는 URL뒤에 한글을 보내면 400(셋팅하기전에는 크롬을 이용)
                      ArrayList,클래스주소를 전송 
              415 : UTF-8 , EUC-KR 한글 변환 코드가 틀릴 경우 
                                   예) UFT-8 ECU-KR
              200 : 정상 수행을 했을 경우 => 브라우저로 서버에서 200을 보내주면 
                                     화면에 바로 출력 
                  배포를 할 때        : 에러파일을 만들어서 처리  
                  
                  
                  실행 순서                  http://localhost/OnLineStudy8/jsp/basic1.jsp
                                          ============================ 파일명을 보내준다 
            클라이언트가 브라우저 요청 ============================================
                             톰캣이 ==> 어떤 브라우저에서 요청했는 여부 확인 
                        *** 파일을 요청하기전에 클라이언트 정보를 먼저 전송 
                                          ===========
                                          1) IP
                                          2) GET/POST
                                          3) XML,HTML
                                          =========== header정보
                             톰캣이 받아서 파일을 찾은 후 ==> 
                   basic1.jsp ===> basic1_jsp.java파일 생성 ===> 컴파일 
                              ===> basic1_jsp.class생성  ===> 가상머신(JVM)
                              ===> 한줄씩 읽어서 번역 ====> 메모리에 <html>만 출력한다
                                                      =====================
                                                                                        클라이언트 브라우저가 읽어서 출력 화면 생성  
                             클라이언트가 파일을 요청시에 어떤 화면을 보여줄건지를 만드는 사람 : 웹프로그래머 (99page)
                JSP => out.println("<html>")
                      =============
                                                생략 
                          => 녹색으로 출력되는 부분에 out.println()
                          => 녹색부분이 => 클라이언트 브라우저에서 읽어 가는 부분
               JSP => Java+HTML
                    =============
                                          구분 ==> 스크립트릿 
                              ======== 자바만 사용이 가능 
                              <%
                                                              메소드안의 사용하는 일반 자바 
                                                              변수선언
                                                              메소드 호출 
                                                              제어문 , 연산자 사용  
                              %>
                              <%= 출력내용만 설정 %> 
                              out.println("데이터");
                   => HTML , JAVA , CSS 
                      ================= html부분 , java를 나눠서 처리 (MV) => 연결 (C)
                                        ======================================== MVC
                                        
            ==> JSP를 사용하게 되면 (JSP에서 지원하는 객체) => 미리 만들어져 있다 (필요시마다 사용가능)
                JSP 내장객체(기본객체)
                ***= request : HttpServletRequest
                     1. 클라이언트가 요청한 데이터 
                     2. 브라우저 정보 
                     3. 데이터 추가 정보 
                     
                     ==> getRemoteAddr() : 클라이언트의 IP
                     ==> getParameter() : 요청값을 가지고 온다
                     ==> getParamterValues() : 여러개의 요청값이 있는 경우
                     ==> setCharacterEncoding() : 한글 (POST)
                     ==> setAttribute() : 기존의 요청값 + 추가 => 전송 (MVC)
                     
                ***= response : HttpServletResponse 
                     1. 응답 정보 
                        sendRedirect() 
                     2. header 정보
                        setHeader() => 다운로드 할때
                = out : JspWriter
                     1. 출력 (메모리 크기 설정)
                        ==> out.println() => 화면 출력 
                            <%= %>
                        ==> out.getBufferSize() : 출력하는 메모리의 실제 크기
                        ==> out.getRemainning() : 사용하고 남아 있는 버퍼 크기 확인 
                *= application : ServletContext
                     1. 서버 정보
                     2. 로그 정보 (*****)
                        ==> log , getInitParameter()
                     3. 실제 저장되는 폴더 정보 
                        ==> getRealPath() : 그림 파일 올릴 경우에 (새로고침) => 톰캣이 실행하는 실제 경로 
                = pageContext : PageContext : 제어흐름(include,forward) 
                                  태그형으로 변경해서 사용 
                    <jsp:include> <jsp:forward>
                ***= session : HttpSession : 서버에 클라이언트 정보를 저장 
                                      로그인처리,장바구니,예매처리 
                                      모든 JSP에서 사용해야되는 데이터가 있는 경우   
                     setAttribute(): 저장 
                     getAttribute() : 값을 읽어 올때
                     invalidate () : 서버에서 저장된 모든 데이터 삭제 
                     removeAttribute() : 원하는 부분만 삭제         
                = page : Object => 일반 자바 => this
                
                = config : 환경설정 ServletConfig ==> web.xml로 대체 
                
                = exception : Exception : 예외처리 
                  => jsp => try~catch
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%-- 출력하는 메모리 크기 : getBufferSize() 
        8kb => 8*1024  => 16kb => 16*1024
   --%>
   <h1>출력하는 메모리 크기:<%= out.getBufferSize() %></h1>
   <%-- 현재 남아 있는 버퍼의 크기 : getRemaining() --%>
   <h1>남아 있는 버퍼(메모리) 크기:<%=out.getRemaining() %> </h1>
   <h1>현재중인 버퍼(메모리) 크기:<%= out.getBufferSize()-out.getRemaining() %></h1>
   <%-- 메모리 크기 , 출력하는 메모리를 정리 : 서버개발자가 주로 사용하는 내장 객체  --%>
   <%
       out.println("버퍼크기:8kb"); // 서블릿 (복잡한 자바 코딩인 경우에만 사용 권장: )
   %>
   <h1>버퍼 처리(전송=>메모리 전체 비워준다):<%=out.isAutoFlush() %></h1>
   <%--
      clear() : 메모리에 저장된 모든 데이터를 지울 경우 , flush(): 버퍼의 내용을 클라이언트로 전송 
      ==> 자동으로 처리가 된다  => 전송 => 메모리에 저장된 데이터를 다 지운다 autoFlush(JSP에서 자동 설정)
      ==> 클라이언트가 서버에 접속을 하게 되면 서버는 HTML,XML을 보내기 위해서 메모리 공간을 생성 
                  클라이언트당 한개만 생성  (메모리에 저장 , 전송완료 => 지워준다)
      ==>118page
         =======
    --%>
</body>
</html>








