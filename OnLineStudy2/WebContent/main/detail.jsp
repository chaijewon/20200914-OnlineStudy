<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.sist.dao.*"%>
<%
    String no=request.getParameter("no");
    EmpDAO dao=new EmpDAO();
    MovieVO vo=dao.movieDetailData(Integer.parseInt(no));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <table width=400>
   <tr>
    <td rowspan=4 width=30% align=center>
     <img src="<%=vo.getPoster() %>" width=250 height=250>
    </td>
    <td colspan="2"><%=vo.getTitle() %></td>
   </tr>
   <tr>
     <td>감독</td>
     <td><%=vo.getDirector() %></td>
   </tr>
   <tr>
     <td>출연</td>
     <td><%=vo.getActor() %></td>
   </tr>
   <tr>
     <td>장르</td>
     <td><%=vo.getGenre() %></td>
   </tr>
   <tr>
     <td colspan="3" valign="top"><%=vo.getStory() %></td>
   </tr>
  </table>
</body>
</html>







