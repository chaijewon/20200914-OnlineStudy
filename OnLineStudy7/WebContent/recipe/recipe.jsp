<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    // 1. 사용자의 요청 내용을 받는다 (페이지)
    String strPage=request.getParameter("page");
    if(strPage==null)
    	strPage="1";
    // 2. 요청을 받아서 ==> 데이터베이스에 있는 데이터를 받아 온다
    int curpage=Integer.parseInt(strPage);
    // Map을 요청 
    int rowSize=12;
    int start=(rowSize*curpage)-(rowSize-1); // rownum (시작이 1부터 시작)
    int end=rowSize*curpage;
    // Nap에 묶어서 전송
    Map map=new HashMap();
    map.put("start",start);
    map.put("end",end);
    
    List<RecipeVO> list=RecipeDAO.recipeListData(map);
    // static => 메모리할당 할 필요가 없다 => 자동으로 저장이 된다 
    int totalpage=RecipeDAO.recipeTotalPage();// 총페이지를 DB로 부터 받아 온다 
    // 3. 받아 온 데이터 출력 
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- CSS -->
<style type="text/css">
h1 {
     text-align: center
}
.pages {
  /*가운데 정렬*/
  margin: 0px auto;
  text-align: center;
}
</style>
</head>
<body>
   <div class="container">
     <h1>10000개의 레시피</h1>
     <div class="row">
       <!-- 출력 위치 -->
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
     <div class="row pages">
        <a href="recipe.jsp?page=<%= curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-danger">이전</a>
          <%=curpage %> page / <%=totalpage %> pages
        <a href="recipe.jsp?page=<%= curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-primary">다음</a>
     </div>
   </div>
</body>
</html>

