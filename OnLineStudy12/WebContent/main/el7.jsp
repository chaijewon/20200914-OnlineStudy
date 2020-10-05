<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
     core : 변수설정 , 제어문 , 화면이동
     fmt : format => 날짜 변환  ==> 오라클  => TO_CHAR
 --%>
<%
     String id="admin";
     String admin="n";
     // and(&&) , or(||) , not(!) 
%>
<%-- 변수 설정 --%>
<c:set var="id" value="<%=id %>"/>
<%--
      request.setAttribute("id","admin"); 
      => request.getAttribute("id")
      <%= request.getAttribute("id") %> ==> ${id}
 --%>
<c:set var="admin" value="<%=admin %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--
      ==  eq
      !=  ne
      <   lt
      >   gt
      <=  le
      >=  ge
      
      && and
      || or
      ! not
      
      / div
      % mod
 --%>
<body>
   <h1>EL연산자 논리 연산자(&&,||,!)</h1>
   <%--
        문자열 비교 ==> ==
        문자열 표현  ==> ''
    --%>
   <c:if test="${ id == 'admin'  and  admin eq 'y'}">
     <b>관리자입니다</b>
   </c:if>
   <c:if test="${ not (id eq 'admin'  and  admin eq 'y')}">
     <b>일반유저입니다</b>
   </c:if>
   <br>
   <c:set var="sex" value="1"/>
   <!--  삼항연산자 
         조건 ?  값1 : 값2
     ==== true => 값1
          false=> 값2   ==> if~else
   -->
   ${sex==1?"남자":"여자" }<br>
   <c:set var="msg1" value="Hello"/>
   <c:set var="msg2" value=" JSP(JSTL,EL)"/>
   ${msg1 += msg2 } <%-- 문자열 결합 연산자 --%>
</body>
</html>





