<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.manager.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
       request.getParameter() : 사용자가 요청한 데이터 
       request.setAttribute() => request.getAttribute()
       ================================================
               사용자가 요청한 데이터 외에 다른 데이터 추가해서 사용 
               
        => id , pwd 로그인 ===> 서버에서는 개인정보 여러개 추가 
                              name , 주소
       
 --%>
 <%-- BoardManager => 메모리 할당 --%>
<jsp:useBean id="mgr" class="com.sist.manager.BoardManager"/>
<%-- 데이터 받는다 --%>
<%
     mgr.boardListData(request);// Controller
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
   <div class="row">
     <h1 class="text-center">자유게시판</h1>
     <table class="table">
       <tr>
         <td>
           <a href="#" class="btn btn-sm btn-primary">새글</a>
         </td>
       </tr>
     </table>
     <table class="table table-striped">
       <tr class="danger">
         <th class="text-center" width=10%>번호</th>
         <th class="text-center" width=45%>제목</th>
         <th class="text-center" width=15%>이름</th>
         <th class="text-center" width=20%>작성일</th>
         <th class="text-center" width=10%>조회수</th>
       </tr>
       <c:forEach var="vo" items="${list }">
        <tr>
          <td class="text-center" width=10%>${vo.no }</td>
          <td class="text-left" width=45%>${vo.subject }</td>
          <td class="text-center" width=15%>${vo.name }</td>
          <td class="text-center" width=20%>${vo.regdate }</td>
          <td class="text-center" width=10%>${vo.hit }</td>
        </tr>
       </c:forEach>
      </table>
     </div>
    </div>
</body>
</html>