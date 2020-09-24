<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     request.setCharacterEncoding("UTF-8");//utf-8
     String fd=request.getParameter("fd");
     String ss=request.getParameter("ss");
     
     // DAO로 전송 결과값을 받아 온다  ==> 검색한 내용 가지고 오기 위해서 SQL => databoard-mapper.xml => DAO처리
     // DAO로부터 처리된 결과를 받아 온다 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1 class="text-center">검색결과</h1>
</body>
</html>