<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table class="table">
    <tr>
      <td>
       성인:
       <c:forEach var="i" begin="1" end="10">
         <span class="btn btn-xs btn-info">${i }</span>
       </c:forEach>
      </td>
    </tr>
    <tr>
      <td>
       소인:
       <c:forEach var="i" begin="1" end="10">
         <span class="btn btn-xs btn-warning">${i }</span>
       </c:forEach>
      </td>
    </tr>
  </table>
</body>
</html>



