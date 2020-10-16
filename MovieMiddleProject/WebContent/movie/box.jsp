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
  <div style="height:30px"></div>
  <div class="row">
    <div class="text-center">
      <a href="../movie/box.do?cateno=3" class="btn btn-sm btn-primary">주간</a>
      <a href="../movie/box.do?cateno=4" class="btn btn-sm btn-success">월간</a>
      <a href="../movie/box.do?cateno=5" class="btn btn-sm btn-danger">연간</a>
    </div>
  </div>
  <div style="height:10px"></div>
  <div class="row">
    <c:forEach var="vo" items="${list }">
      <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="../movie/detail.do?no=${vo.no }&cno=3">
	        <img src="${vo.poster }" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p>${vo.title }</p>
	        </div>
	      </a>
       </div>
     </div>
    </c:forEach>
  </div>
</body>
</html>