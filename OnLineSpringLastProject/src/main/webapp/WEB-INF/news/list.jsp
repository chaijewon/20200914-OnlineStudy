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
           <h3 class="text-center">뉴스 검색</h3>
           <table class="table">
            <tr>
             <td>
             <form method=post action="../news/list.do">
               Search:<input type=text name=fd size=20 class="input-sm">
               <input type=submit value="검색" class="btn btn-sm  btn-danger">
              </form>
             </td>
            </tr>
           </table>
           <table class="table">
             <tr>
               <td>
                 <c:forEach var="vo" items="${list }">
                   <table class="table">
                    <tr>
                      <td><span style="color:orange">${vo.title }</span></td>
                    </tr>
                    <tr>
                      <td><a href="${vo.link }" target="_blank">${vo.description }</a></td>
                    </tr>
                    <tr>
                      <td class="text-right">${vo.author }(${vo.day })</td>
                    </tr>
                   </table>
                 </c:forEach>
               </td>
             </tr>
           </table>
         </div>
        </div>
 </div>
</body>
</html>





