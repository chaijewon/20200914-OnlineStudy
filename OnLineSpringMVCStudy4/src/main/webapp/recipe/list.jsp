<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <div class="row">
      <h3 class="text-center">레시피 목록</h3>
      <h5 class="text-right">
        ${curpage } page / ${totalpage } pages
      </h5>
      <c:forEach var="vo" items="${list }">
        <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="#">
	          <img src="${vo.poster }" alt="Lights" style="width:100%">
	        </a>
	          <div class="caption">
	            <p style="font-size: 8pt">${vo.title }</p>
	            <p style="font-size: 8pt">
	             <a href="chef.do?chef=${vo.chef }">${vo.chef }</a>
	            </p>
	          </div>
	        
	      </div>
	    </div>
      </c:forEach>
    </div>
    <div class="row">
       <ul class="pager">
		  <li class="previous"><a href="list.do?page=${curpage>1?curpage-1:curpage }">이전</a></li>
		  <li class="next"><a href="list.do?page=${curpage<totalpage?curpage+1:curpage }">다음</a></li>
		</ul>
    </div>
  </div>
</body>
</html>