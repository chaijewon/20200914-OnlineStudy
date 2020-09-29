<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // session에 등록된 데이터 전체 삭제
    session.invalidate();
    // main.jsp로 이동 
    response.sendRedirect("../main/main.jsp"); // id=null (login.jsp)
%>