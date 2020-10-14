<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
     <h1 class="text-center">사원 목록</h1>
     <table class="table table-bordered">
       <tr class="success">
         <th>사번</th>
         <th>이름</th>
         <th>직위</th>
         <th>입사일</th>
         <th>급여</th>
         <th>부서명</th>
         <th>근무지</th>
       </tr>
       <c:forEach var="vo" items="${list }">
         <tr>
           <td>${vo.empno }</td>
           <td>${vo.ename }</td>
           <td>${vo.job }</td>
           <td>${vo.hiredate }</td>
           <td>${vo.sal }</td>
           <td>${vo.dvo.dname }</td>
           <td>${vo.dvo.loc }</td>
         </tr>
       </c:forEach>
     </table>
    </div>
  </div>
</body> 
</html>





