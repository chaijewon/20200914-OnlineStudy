<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
     MovieDAO dao=new MovieDAO();
     List<String> list=dao.empGetName();
%>
<%-- 영화 : cookie(최근본 영화),session(로그인) --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <ul>
     <%
        for(String s:list)
        {
     %>
          <li><%=s %></li>
     <%
        }
     %>
   </ul>
</body>
</html>