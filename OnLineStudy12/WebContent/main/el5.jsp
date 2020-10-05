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
        <%
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
        %>
      </table>
   </center>
</body>
</html>









