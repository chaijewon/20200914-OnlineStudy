<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.tabContent').click(function(){
		let no=$(this).attr("value");
		let offset=$('#'+no).offset();
		$('html,body').animate({scrollTop:offset.top},400);
	});
	
});
</script>

</head>
<body>
<div class="latest-products">
      <div style="height: 130px"></div>
      <div class="container">
        <div class="row">
          <div style="margin: 0px auto">
           <span class="btn btn-lg btn-success tabContent" value="r1">믿고 보는 맛집 리스트</span>
           <span class="btn btn-lg btn-danger tabContent" value="r2">지역별 인기 맛집</span>
           <span class="btn btn-lg btn-info tabContent" value="r3">메뉴별 인기 맛집</span>
          </div>
        </div>
        <div style="height: 50px"></div>
        <div class="row" id="r1">
          <div class="col-md-12">
            <div class="section-heading">
              <h2 style="color:#CCCCFF">믿고 보는 맛집 리스트</h2>
            </div>
          </div>
          <c:forEach var="vo" items="${list }">
            <c:if test="${vo.no>=1 && vo.no<=12 }">
	          <div class="col-md-4">
	            <div class="product-item">
	              <a href="../food/food_category.do?no=${vo.no }"><img src="${vo.poster }" alt="" class="img-rounded"></a>
	              <div class="down-content">
	                <a href="../food/food_category.do?no=${vo.no }"><h4>${vo.title }</h4></a>
	                <p>${vo.subject }</p>
	              </div>
	            </div>
	          </div>
	         </c:if>
          </c:forEach>
          <div class="row" id="r2">
          <div class="col-md-12">
            <div class="section-heading">
              <h2 style="color:#CCCCFF">지역별 인기 맛집</h2>
            </div>
          </div>
          <c:forEach var="vo" items="${list }">
            <c:if test="${vo.no>=13 && vo.no<=18 }">
	          <div class="col-md-4">
	            <div class="product-item">
	              <a href="../food/food_category.do?no=${vo.no }"><img src="${vo.poster }" alt="" class="img-rounded"></a>
	              <div class="down-content">
	                <a href="../food/food_category.do?no=${vo.no }"><h4>${vo.title }</h4></a>
	                <p>${vo.subject }</p>
	              </div>
	            </div>
	          </div>
	         </c:if>
          </c:forEach>
          <div class="row" id="r3">
          <div class="col-md-12">
            <div class="section-heading">
              <h2 style="color:#CCCCFF">메뉴별 인기 맛집</h2>
            </div>
          </div>
          <c:forEach var="vo" items="${list }">
            <c:if test="${vo.no>=19 && vo.no<=30 }">
	          <div class="col-md-4">
	            <div class="product-item">
	              <a href="../food/food_category.do?no=${vo.no }"><img src="${vo.poster }" alt="" class="img-rounded"></a>
	              <div class="down-content">
	                <a href="../food/food_category.do?no=${vo.no }"><h4>${vo.title }</h4></a>
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