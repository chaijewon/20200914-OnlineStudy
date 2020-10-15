<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div style="height: 30px"></div>
  <div class="row">
   <div class="col-sm-8">
     <table class="table">
       <tr>
        <td>
          <c:forEach var="vo" items="${nList }">
            <table class="table">
              <tr>
                <td width=30% class="text-center" rowspan="3">
                  <%--
                       ~~.jpg);
                   --%>
                  <img src="${fn:substring(vo.poster,0,fn:indexOf(vo.poster,')'))}" width=300 height=250>
                </td>
                <td width=70%>${vo.title }</td>
              </tr>
              <tr>
                <td width=70%>${vo.content }</td>
              </tr>
              <tr>
                <td width=70% class="text-right">${vo.author }</td>
              </tr>
            </table>
          </c:forEach>
        </td>
       </tr>
     </table>
     <div>
       <div class="text-center">
         <a href="../movie/news.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-success">이전</a>
            ${curpage } page / ${totalpage } pages
         <a href="../movie/news.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-warning">다음</a>
       </div>
     </div>
   </div>
   <div class="col-sm-4">
   
   </div>
  </div>
</body>
</html>