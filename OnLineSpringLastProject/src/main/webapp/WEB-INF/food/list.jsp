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
<div class="latest-products">
      <div style="height: 130px"></div>
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <h2>믿고 보는 맛집 리스트</h2>
            </div>
          </div>
          <c:forEach var="vo" items="${list }">
            <c:if test="${vo.no>=1 && vo.no<=12 }">
	          <div class="col-md-4">
	            <div class="product-item">
	              <a href="#"><img src="${vo.poster }" alt=""></a>
	              <div class="down-content">
	                <a href="#"><h4>${vo.title }</h4></a>
	                <p>${vo.subject }</p>
	              </div>
	            </div>
	          </div>
	         </c:if>
          </c:forEach>
          <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <h2>지역별 인기 맛집</h2>
            </div>
          </div>
          <c:forEach var="vo" items="${list }">
            <c:if test="${vo.no>=13 && vo.no<=18 }">
	          <div class="col-md-4">
	            <div class="product-item">
	              <a href="#"><img src="${vo.poster }" alt=""></a>
	              <div class="down-content">
	                <a href="#"><h4>${vo.title }</h4></a>
	                <p>${vo.subject }</p>
	              </div>
	            </div>
	          </div>
	         </c:if>
          </c:forEach>
          <div class="row">
          <div class="col-md-12">
            <div class="section-heading">
              <h2>메뉴별 인기 맛집</h2>
            </div>
          </div>
          <c:forEach var="vo" items="${list }">
            <c:if test="${vo.no>=19 && vo.no<=30 }">
	          <div class="col-md-4">
	            <div class="product-item">
	              <a href="#"><img src="${vo.poster }" alt=""></a>
	              <div class="down-content">
	                <a href="#"><h4>${vo.title }</h4></a>
	                <p>${vo.subject }</p>
	              </div>
	            </div>
	          </div>
	         </c:if>
          </c:forEach>
          </div>
         </div>
</body>
</html>