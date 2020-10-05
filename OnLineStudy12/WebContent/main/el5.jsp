<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%-- JSTL 사용 (제어문) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
       EmpDAO를 통해서 데이터를 가지고 온다 
 --%>
<%
     EmpDAO dao=new EmpDAO();
     List<EmpVO> list=dao.empListData(); // Controller:데이터를 가지고 와서 => request에 값을 담아서 JSP전송
%>
<%-- request에 값을 추가 : EL을 이용할 수 있다 
     request.setAttribute("list",list)
--%>
<c:set var="list" value="<%=list %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
      <h1>사용 목록</h1>
      <table border=1 bordercolor=black width=700>
        <tr bgcolor=#ccccff>
          <th>사번</th>
          <th>이름</th>
          <th>직위</th>
          <th>입사일</th>
          <th>부서</th>
          <th>근무지</th>
          <th>급여</th>
        </tr>
        <%-- <%
           for(EmpVO vo:list)
           {
        %>
              <tr>
                <td><%=vo.getEmpno() %></td>
                <td><%=vo.getEname() %></td>
                <td><%=vo.getJob() %></td>
                <td><%=vo.getDbday() %></td>
                <td><%=vo.getDname() %></td>
                <td><%=vo.getLoc() %></td>
                <td><%=vo.getSal() %></td>
              </tr>
        <% 
           }
        %> --%>
        <c:forEach var="vo" items="${list }">
        <%-- var="vo" vo객체 생성 items="실제 데이터를 가지고 온다"--%>
          <tr>
            <%-- <td>${vo.getEmpno() }</td>
            <td>${vo.getEname() }</td>
            <td>${vo.getJob() }</td>
            <td>${vo.getDbday() }</td>
            <td>${vo.getDname() }</td>
            <td>${vo.getLoc() }</td>
            <td>${vo.getSal() }</td> --%>
            <%-- 일반적으로 사용하는 방식 --%>
            <td>${vo.empno }</td><%-- vo.getEmpno() : getXxx()가 없는 경우에는 오류--%>
            <%-- VO제작시에는 반드시 getter/setter를 만든다  --%>
            <td>${vo.ename }</td>
            <td>${vo.job }</td>
            <td>${vo.dbday }</td>
            <td>${vo.dname }</td>
            <td>${vo.loc }</td>
            <td>${vo.sal }</td>
          </tr>
        </c:forEach>
      </table>
   </center>
</body>
</html>









