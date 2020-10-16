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
    <c:forEach var="vo" items="${list }">
      <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="../movie/detail.do?no=${vo.no }&page=${curpage}&cno=2">
	        <img src="${vo.poster }" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p>${vo.title }</p>
	        </div>
	      </a>
       </div>
     </div>
    </c:forEach>
  </div>
  <div class="row">
    <div class="text-center">
      <a href="../movie/sch.do?cateno=2&page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-info">이전</a>
       ${curpage } page / ${totalpage } pages
      <a href="../movie/sch.do?cateno=2&page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-success">다음</a>
    </div>
  </div>
</body>
</html>