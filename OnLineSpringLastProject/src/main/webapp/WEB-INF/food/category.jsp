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
          <table class="table">
            <tr>
              <td class="text-center">
                <h1>${vo.title }</h1>
              </td>
            </tr>
            <tr>
              <td class="text-center">
                <h4 style="color:#999999">${vo.subject }</h4>
              </td>
            </tr>
          </table>
        </div>
        <div style="height: 15px"></div>
        <div class="row">
         <c:forEach var="fvo" items="${list }">
           <table class="table">
            <tr>
              <td width=35% class="text-center" rowspan="3">
                <a href="../food/food_detail.do?no=${fvo.no }"><img src="${fvo.posterOne }" width=350 height=150></a>
              </td>
              <td width=65%>
                <h3><a href="../food/food_detail.do?no=${fvo.no }">${fvo.title }</a>&nbsp;<span style="color:orange">${fvo.score }</span></h3>
              </td>
            </tr>
            <tr>
              <td width=65%>${fvo.addr1 }<br>지번:${fvo.addr2 }</td>
            </tr>
            <tr>
              <td width=65%>${fvo.tel }</td>
            </tr>
           </table>
         </c:forEach>
        </div>
       </div>
       
 </div>
</body>
</html>


