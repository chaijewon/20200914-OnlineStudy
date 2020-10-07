<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="model" class="com.sist.model.RecipeModel"/>
<%
    model.chefListData(request);
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
       <h1>Chef 목록</h1>
       <%-- 목록 출력 --%>
       <table class="table">
         <tr>
           <td>
             <c:forEach var="vo" items="${list }">
              <table class="table table-striped">
                <tr>
                  <td width=35% rowspan="2" class="text-center">
                    <img src="${vo.poster }" class="img-circle" width=60 height=60>
                  </td>
                  <td colspan="4" style="font-size:13pt;color:#FC6"><b>
                   <a href="chef_detail.jsp?chef_name=${vo.chef }">${vo.chef }</a>
                  </b></td>
                </tr>
                <tr>
                  <td class="text-center">${vo.mem_cont1 }</td>
                  <td class="text-center">${vo.mem_cont3 }</td>
                  <td class="text-center">${vo.mem_cont7 }</td>
                  <td class="text-center">${vo.mem_cont2 }</td>
                </tr>
              </table>
             </c:forEach>
           </td>
         </tr>
       </table>
     </div>
     <div class="row">
       <div class="text-center">
         <a href="chef.jsp?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
           ${curpage } page / ${totalpage } pages
         <a href="chef.jsp?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-danger">다음</a>
       </div>
     </div>
   </div>
</body>







</html>


