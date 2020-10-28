<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table class="table">
    <caption>예매목록</caption>
    <tr>
      <td>
        <table class="table table-striped">
          <tr class="danger">
           <th class="text-center">예매번호</th>
           <th class="text-center"></th>
           <th class="text-center">영화명</th>
           <th class="text-center">극장명</th>
           <th class="text-center">예매일</th>
           <th class="text-center">인원</th>
           <th class="text-center">금액</th>
           <th class="text-center"></th>
          </tr>
          <c:forEach var="vo" items="${list }">
            <tr>
               <td class="text-center">${vo.no }</td>
	           <td class="text-center">
	             <img src="${vo.mvo.poster }" width=30 height=30>
	           </td>
	           <td class="text-center">${vo.mvo.title }</td>
	           <td class="text-center">${vo.theater }</td>
	           <td class="text-center">${vo.time }</td>
	           <td class="text-center">${vo.inwon }</td>
	           <td class="text-center">${vo.price }</td>
	           <td class="text-center">
	             <c:if test="${vo.isreserve=='y' }">
	              <a href="#" class="btn btn-sm btn-primary">예매완료</a>
	             </c:if>
	             <c:if test="${vo.isreserve=='n' }">
	              <span class="btn btn-sm btn-danger">예매대기</span>
	             </c:if>
	           </td>
            </tr>
          </c:forEach>
        </table>
      </td>
    </tr>
  </table>
  <table class="table">
    <caption>찜목록</caption>
    <tr>
      <td>
        
      </td>
    </tr>
  </table>
</body>
</html>