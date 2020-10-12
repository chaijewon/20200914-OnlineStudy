<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
       request.getParameter() : 사용자가 요청한 데이터 
       request.setAttribute() => request.getAttribute()
       ================================================
               사용자가 요청한 데이터 외에 다른 데이터 추가해서 사용 
               
        => id , pwd 로그인 ===> 서버에서는 개인정보 여러개 추가 
                              name , 주소
       
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
   <div class="row">
     <h1 class="text-center">자유게시판</h1>
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
       <c:forEach var="vo" items="${list }">
        <tr>
          <td class="text-center" width=10%>${vo.no }</td>
          <%--
               ${vo.no } => <%= vo.getNo()%>
               EL / JSTL
               
               EL 
               1) Scope => 어디에 저장된 데이터  254page
                  = requestScope.키명
                  = sessionScope.키명
                  
                  request.setAttribute("id","admin");
                  => ${requestScope.id} ==> 생략 ${id}
                       ============ 생략 
                  sessionS.setAttribute("id","admin");
                  => ${sessionScope.id}
                      ============= request에 없는 키명이 있는 경우에는 생략 
               2) 연산자 
                                  산술연산자 ( + , - , * , /(div) , %(mod))
                         => null+1 => null은 자동으로 0으로 변경된다
                         => "10"+10 => 20
                         => / => 실수
		                   비교연산자 (문자열 비교가 가능하다)
		                   ==(eq) : 문자열 비교시 
		                   !=(ne) 
		                   < (lt)
		                   > (gt)
		                   <= (le)
		                   >= (ge)
		                   논리연산자
		                   && (and)
		                   || (or)
		                   !  (not)
		                   문자열 결합 
		                   += 
		                   삼항연산자 
		                           조건 ? 값:값
		                           
		       JSTL
		         <c:set>
		         <c:if>
		         <c:forEach>
		         <c:choose> <c:when> <c:otherwise>
		         <c:redirect>
		         <fmt:formatDate>
		         <fmt:formatNumber>
           --%>
          <td class="text-left" width=45%>
           <a href="detail.do?no=${vo.no }">${vo.subject }</a>
           <%-- <c:if test="${today == vo.dbday}">
             <font color=red><sup>new</sup></font>    
           </c:if> --%>
           <%--
                if(request.getAttribute("today").equals(vo.getDbday())
                {
                    <font color=red><sup>new</sup></font>
                }
                
                request.setAttribute() => 반드시 request.getAttribute() => 서버에서 필요한 데이터 첨부
                session , application 
                => 사용자가 전송한 데이터 => request.getParameter()
            --%>
          </td>
          <td class="text-center" width=15%>${vo.name }</td>
          <td class="text-center" width=20%>
           <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
           <%--
                  Date date=new Date();
                  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd")
                  out.println(sdf.format(date));
            --%>
          </td>
          <td class="text-center" width=10%>${vo.hit }</td>
        </tr>
       </c:forEach>
      </table>
      <table class="table table-striped">
        <tr>
          <td class="text-right">
            <a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
              ${curpage } page / ${totalpage } pages
            <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
          </td>
        </tr>
      </table>
     </div>
    </div>
</body>
</html>
