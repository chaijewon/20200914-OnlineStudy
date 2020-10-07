<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
     List<String> list=new ArrayList<String>();
     list.add("홍길동");// 0  list.get(0) ==> varStatus
     list.add("심청이");// 1
     list.add("박문수");// 2
     List<Integer> list2=new ArrayList<Integer>();
     list2.add(30);// 0
     list2.add(25);// 1
     list2.add(33);// 2
%>
<c:set var="names" value="<%=list %>"/>
<c:set var="ages" value="<%=list2 %>"/>
<%--
     홍길동(30)
     심청이(25)
     박문수(33)
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <c:forEach var="name" items="${names }" varStatus="s">
  <%-- varStatus => index번호  --%>
     ${ s.index }:${name }(${ages[s.index]})<br>
  </c:forEach>
</body>
</html>





