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
      <div style="height: 130px"></div>
        <div class="container">
         <div class="row">
			  <div class="col-md-8">
			    <h3 class="text-center">삭제하기</h3>
			    <form method=post action="../board/delete_ok.do">
			    <table class="table">
			      <tr>
			        <td width=30% class="text-right">비밀번호</td>
			        <td width=70%>
			          <input type=password name=pwd class="input-sm" size=15>
			          <input type=hidden name=no value="${no }">
			        </td>
			      </tr>
			      <tr>
			        <td colspan="2" class="text-center">
			          <input type=submit value="삭제" class="btn btn-sm btn-primary">
			          <input type=button value="취소" class="btn btn-sm btn-danger"
			           onclick="javascript:history.back()">
			        </td>
			      </tr>
			    </table>
			    </form>
			  </div>
			  <div class="col-md-4">
			    <h3>맛집 Top5</h3>
		     <table class="table">
		       <c:forEach var="fvo" items="${fList }">
		         <tr>
		           <td>
		            <img src="${fvo.poster }" width=35 height=35>
		           </td>
		           <td>${fvo.title }</td>
		         </tr>
		       </c:forEach>
		     </table>
		     <h3>레시피 Top5</h3>
		     <table class="table">
		       <c:forEach var="rvo" items="${rList }">
		         <tr>
		           <td>
		            <img src="${rvo.poster }" width=35 height=35>
		           </td>
		           <td>${rvo.title }</td>
		         </tr>
		       </c:forEach>
		     </table>
			  </div>
		  </div>
		 </div>
</div>
</body>
</html>


