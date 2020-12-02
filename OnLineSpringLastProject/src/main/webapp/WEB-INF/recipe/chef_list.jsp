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
          <c:forEach var="vo" items="${list }">
           <table class="table">
             <tr>
               <td width=35% class="text-center" rowspan="2">
                 <a href="../recipe/chef_product.do?chef=${vo.chef }"><img src="${vo.poster }" width=180 height=80></a>
               </td>
               <td colspan="4"><font color="orange"><a href="../recipe/chef_product.do?chef=${vo.chef }">${vo.chef }</a></font></td>
             </tr>
             <tr>
               <td class="text-center">${vo.mc1 }</td>
               <td class="text-center">${vo.mc3 }</td>
               <td class="text-center">${vo.mc7 }</td>
               <td class="text-center">${vo.mc2 }</td>
             </tr>
           </table>
          </c:forEach>
        </div>
      </div>
</div>
</body>
</html>