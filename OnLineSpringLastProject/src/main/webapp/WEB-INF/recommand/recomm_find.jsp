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
         <c:forEach var="vo" items="${fList }">
	          <div class="col-md-4">
	            <div class="product-item">
	              <a href="../food/food_detail.do?no=${vo.no }"><img src="${vo.poster }" width=350 height=300></a>
	              <div class="down-content">
	                <a href="../food/food_detail.do?no=${vo.no }"><h4>${vo.title }</h4></a>
	              </div>
	            </div>
	          </div>
         </c:forEach>
</body>
</html>