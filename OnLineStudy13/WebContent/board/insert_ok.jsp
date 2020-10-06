<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.manager.*"%>
<jsp:useBean id="mgr" class="com.sist.manager.BoardManager"/>
<%
    // BoardManager => request로 전송 => 처리
    mgr.boardInsert(request, response);
%>
