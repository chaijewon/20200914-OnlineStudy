<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.manager.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- BoardManager mgr=new BoardManager() : 태그 --%>
<jsp:useBean id="mgr" class="com.sist.manager.BoardManager"/>
<%
    // BoardManager로 request를 전송하면  => 처리 => 결과값을 jsp로 전송
    // JSP : 요청한 결과값을 출력만 담당 (View) : 프리젠테이션 로직
    // 처리 => Java로 처리 (Model) : 비지니스로직  => Manager,DAO,VO
    // View <===> Model (연결하는 클래스 : Controller) => Spring
    mgr.boardUpdate(request); // request => bCheck
%>
<%--
    <c:if>
    <c:else>(X)
 --%>
<c:choose><%-- switch , 다중 if , 선택 if(if~else) --%>
  <c:when test="${bCheck==true }"><%-- if(조건문) --%>
   <c:redirect url="detail.jsp?no=${no }"/>
   <%-- response.sendRedirect("detail.jsp?no=1") --%>
  </c:when>
  <c:otherwise><%-- default , else --%>
   <script>
   alert("비밀번호가 틀립니다!!");
   history.back();
   </script>
  </c:otherwise>
</c:choose>






