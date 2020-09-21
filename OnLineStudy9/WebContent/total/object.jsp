<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%--
       1) 내장 객체 
          request
            getParameter() : 단일 값을 받는 경우
            getParameterValues() : 다중값 (체크박스)
            setCharacterEncoding() : 디코딩 (인코딩 =>디코딩)
          response
            setHeader() : 실제데이터를 보내기전에 전송하는 데이터 (header:IP,Method)
                                               다운로드
            sendRedirect() : 서버에서 사용자 요청한 파일로 이동 => GET방식을 이용한다         
          out
                       기본 메모리 크기 : 8kb
            println() : 화면에 출력 ==> <%= %>
          pageContext
            include(): 특정부분에 다른 JSP를 포함 
                       <jsp:include>
            forward() : 원래 => 모든 JSP (request를 따로 가지고 있다)
                        화면이 변경이 되면 request가 초기화 (기존에 보냈던 모든 데이터 잃어 버린다)
                        잃어 버리지 않게 하는 방식 => forward(MVC,Spring)
                        
          application
            web.xml을 읽을 경우 : getInitParamter()
            log() => 모든 서버에서 로그파일 기록하고 
            getRealPath() : 실제 톰캣이 읽어가는 경로명 (모든 그림 파일에 여기에 존재)
            
         error 처리 
         =========
            errorPage 처리 
            web.xml에 처리하는 방식 
              <error-page>
                <error-code>404<error-code>
                <location>처리하는 파일의 위치</location>
              <error-page>
              404 : 파일이 존재하지 않는 경우
              500 : 소스에 컴파일,인터프리터에러 
              415 : 한글변환 코드 오류 (UTF-8 => UFT-8)
              400 : 데이터 전송 (인터넷=>한글을 포함해서 보내면 400)
              200(정상수행) ==> 정상수행 
              ====================== ajax에 등장 
          => session/cookie(내장 객체)
   --%>
</body>
</html>






