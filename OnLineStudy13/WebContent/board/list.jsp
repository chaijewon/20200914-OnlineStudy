<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.manager.*"%>
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
<%-- BoardManager => 메모리 할당 --%>
<jsp:useBean id="mgr" class="com.sist.manager.BoardManager"/>
<%-- 데이터 받는다 --%>
<%
     mgr.boardListData(request);// Controller
     // Call By Reference (주소 => 주소에 값을 채워주는 방식)
     // request => 각 JSP마다 가지고 있다 
%>
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
           <a href="#" class="btn btn-sm btn-primary">새글</a>
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
           --%>
          <td class="text-left" width=45%>
           ${vo.subject }
           <c:if test="${today == vo.dbday}">
             <font color=red><sup>new</sup></font>    
           </c:if>
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
     </div>
    </div>
</body>
</html>