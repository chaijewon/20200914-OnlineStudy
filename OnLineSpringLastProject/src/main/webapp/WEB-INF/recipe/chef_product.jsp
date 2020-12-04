<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="latest-products">
      <div style="height:130px"></div>
      <div class="container">
        <div class="row">
          <form method="post" action="../recipe/chef_product.do">
	          <input type=hidden name="chef" value="${chef}">
	          <input type=text name="fd" class="input-sm" size=20>
	          <button class="btn btn-sm btn-primary">검색</button>
          </form>
          <a href="../recipe/chef_product.do?chef=${chef }" class="btn btn-sm btn-success">전체목록</a>
          <a href="../recipe/chef_list.do" class="btn btn-sm btn-danger">쉐프목록</a>
        </div>
        <div style="height: 30px"></div>
        <div class="row">
          <c:forEach var="vo" items="${list }">
	          <div class="col-md-3">
	            <div class="product-item">
	              <a href="#"><img src="${vo.poster }" alt="" class="img-rounded"></a>
	              <div class="down-content">
	                <a href="#"><h4 style="font-size:8pt">${vo.title }</h4></a>
	                <p>${vo.chef }</p>
	              </div>
	            </div>
	          </div>
          </c:forEach>
        </div>
      </div>
      
</div>
</body>
</html>




