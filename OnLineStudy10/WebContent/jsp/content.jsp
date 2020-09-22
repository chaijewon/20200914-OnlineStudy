<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%-- 변경되는 화면 
    <div class="panel panel-primary">
      <div class="panel-heading">Panel with panel-primary class</div>
      <div class="panel-body">Panel Content</div>
    </div>
    <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/lights.jpg">
        <img src="/w3images/lights.jpg" alt="Lights" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
--%>
<%
     MovieDAO dao=new MovieDAO();
     List<MovieVO> list=dao.movieListData(1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1 class="text-center">영화 목록</h1>
  <%
      for(MovieVO vo:list)
      {
  %>
         <div class="col-md-4">
            <div class="panel panel-primary">
		      <div class="panel-heading"><%=vo.getTitle() %></div>
		      <div class="panel-body">
		        <div class="thumbnail">
		            <a href="basic1.jsp?mode=2">
			        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%">
			        </a>
			    </div>
		      </div>
		    </div>
         </div>
  <%
      }
  %>
</body>
</html>




