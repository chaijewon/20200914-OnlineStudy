<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.manager.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="mgr" class="com.sist.manager.BoardManager"/>
<%
     // BoardManager => 사용자가 요청한 pwd,no => 전송
     // 결과값을 받아서 화면 이동 
     mgr.boardDelete(request);
%>
<c:choose>
  <c:when test="${bCheck==true }">
   <c:redirect url="list.jsp"/>
  </c:when>
  <c:otherwise>
    <script>
     alert("비밀번호가 틀립니다");
     history.back();// delete.jsp
    </script>
  </c:otherwise>
</c:choose>
