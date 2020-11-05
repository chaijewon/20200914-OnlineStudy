<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- SimpleDateFormat --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:900px;
}
h1 {
    text-align: center;
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
       <h1>스프링 게시판(MyBatis:Annotation)</h1>
       <table class="table">
         <tr>
           <td>
             <a href="insert.do" class="btn btn-sm btn-primary">새글</a>
           </td>
         </tr>
       </table>
       <table class="table table-striped">
         <tr class="danger">
           <th class="text-center" width=10%>번호</th>
           <th class="text-center" width=45%>제목</th>
           <th class="text-center" width=15%>이름</th>
           <th class="text-center" width=20%>작성일</th>
           <th class="text-center" width=10%>조회수</th>
         </tr>
         <%-- 데이터 출력 위치 --%>
         <%--
               for(BoardVO vo:request.getAttribute("list"))
               => request.setAttribute("list",list);
               ${list}=request.getAttribute("list")
          --%>
         <c:forEach var="vo" items="${list }">
           <tr>
               <td class="text-center" width=10%>${vo.no }</td>
	           <td class="text-left" width=45%>
	             <a href="detail.do?no=${vo.no }">${vo.subject }</a>
	           </td>
	           <td class="text-center" width=15%>${vo.name }</td>
	           <td class="text-center" width=20%>
	             <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
	           </td>
	           <td class="text-center" width=10%>${vo.hit }</td>
           </tr>
         </c:forEach>
       </table>
       <table class="table">
         <td class="text-center">
          <a href="#" class="btn btn-sm btn-primary">이전</a>
          ${curpage } page / ${totalpage } pages
          <a href="#" class="btn btn-sm btn-primary">다음</a>
         </td>
       </table>
     </div>
   </div>
</body>
</html>



