<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%--
      6장 에러페이지 
      ===========
      1) error가 났을 경우에 페이지 이동 ==> errorPage="error.jsp"
                     모든 에러가 같은 파일을 이용한다  
      2) error가 났을 경우에 ==> 종류별로 처리 
         500,404 ==> web.xml이용처리
                 파일을 여러개 만들어서 처리   
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
      int a=10/0; // 500에러 => 지정된 파일이 없는 경우 ==> 서버 자체에서 처리하는 500에 대한 파일을 전송 
  %>
</body>
</html>