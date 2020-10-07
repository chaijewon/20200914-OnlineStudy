<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="model" class="com.sist.model.RecipeModel"/>
<%
     model.chefRecipeData(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto; /*가운데 정렬*/
}
h1 {
     text-align: center;
}
</style>
</head>
<body>
   <div class="container-fluid">
     <div class="row">
       <h1>${param.chef_name }님의 레시피 목록</h1>
       <c:forEach var="vo" items="${list }">
		   <div class="col-md-3">
		    <div class="thumbnail">
		        <img src="${vo.poster }" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p>${fn:length(vo.title)>20?fn:substring(vo.title,0,20)+="...":vo.title }</p>
		          <p>${vo.chef }</p>
		        </div>
		    </div>
		   </div>
		 </c:forEach>
     </div>
   </div>
</body>
</html>






