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
		  <div class="col-md-9">
		   <h3 class="text-center">몽고디비 게시판</h3>
		   <table class="table">
		     <tr>
		       <td>
		        <a href="../board/insert.do" class="btn btn-sm btn-danger">새글</a>
		       </td>
		     </tr>
		   </table>
		   <table class="table table-striped">
		     <tr class="success">
		      <th class="text-center" width=10%>번호</th>
		      <th class="text-center" width=45%>제목</th>
		      <th class="text-center" width=15%>이름</th>
		      <th class="text-center" width=20%>작성일</th>
		      <th class="text-center" width=10%>조회수</th>
		     </tr>
		     <c:forEach var="vo" items="${bList }">
		       <tr class="success">
			      <td class="text-center" width=10%>${vo.no }</td>
			      <td class="text-left" width=45%>
			        <a href="../board/detail.do?no=${vo.no }">${vo.subject }</a>
			      </td>
			      <td class="text-center" width=15%>${vo.name }</td>
			      <td class="text-center" width=20%>${vo.regdate }</td>
			      <td class="text-center" width=10%>${vo.hit }</td>
			     </tr>
		     </c:forEach>
		   </table>
		  </div>
		  <div class="col-md-3">
		  
		  </div>
		</div>
</div>
</body>
</html>