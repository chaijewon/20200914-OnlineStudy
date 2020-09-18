<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
   // 사용자가 보내준 데이터 받기  ==> chef명 받기
   //  ?chef=값 ==> 사용자가 보낸 모든 데이터는 request안에 저장
   String chef=request.getParameter("chef");
   // SQL문장을 작성 => chef-mapper.xml
   // 쉐프가 만든 레시피를 DAO를 통해서 데이터를 얻어 온다 
   // DAO에서 데이터베이스(오라클) 연결 => 실행 결과를 얻어 온다 
   List<RecipeVO> list=RecipeDAO.chefMakeRecipe(chef);
   // DAO 들어온 데이터를 화면에 출력 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
   <%--
       window 10 => get방식으로 전송 한글이 정상
                   =====
                   URL?변수=값 
                 => get방식으로 전송 한글 깨진다
    --%>
   <div class="container">
     <h1 class="text-center"><%=chef %>님의 레시피</h1>
     <div class="row">
       <%
           for(RecipeVO vo:list)
           {
       %>
                <div class="col-md-3">
			      <div class="thumbnail">
			        <a href="#" target="_blank">
			          <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%">
			          <div class="caption">
			            <p><%=vo.getTitle() %></p>
			            <p><%=vo.getChef() %></p>
			          </div>
			        </a>
			      </div>
			    </div>
       <%
           }
       %>
     </div>
   </div>
</body>
</html>






