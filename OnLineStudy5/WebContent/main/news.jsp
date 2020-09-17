<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.xml.*"%>
<%
    // 데이터 읽기 
    // 1. 사용자 보내준 검색어를 읽어온다 
    String fd=request.getParameter("fd");
    // 주의점 : 처음에는 검색어를 보내줄 수 없다 => default로 설정 
    if(fd==null)
    {
    	fd="맛집";
    }
    
    NewsManager m=new NewsManager();// 네이버 연결해서 뉴스데이터를 읽어오는 역할의 클래스
    List<Item> list=m.newsAllData(fd);// 네이버로부터 데이터 수집 요청
    // ==> 화면에 출력 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
/*오버라이딩=>이미 만들어진 CSS를 변경*/
.row {
  width:800px;
  margin: 0px auto;/*가운데 정렬 (<center>사용하지 않는다)*/
}
h1 {
   text-align: center;/*문자열 가운데 정렬*/
}
</style>
</head>
<body>
  <div class="container"> <%-- 전체 화면 테두리 : 960px (양쪽에 약간의 여백) --%>
    <div class="row">
      <h1>네이버 실시간 뉴스 검색</h1>
      <%-- 검색창 만들기 --%>
      <table class="table">
        <tr>
          <td>
          <input type=text name=fd size=15 class="input-sm">
          <input type=submit value="검색" class="btn btn-sm btn-primary">
          </td>
        </tr>
      </table>
      <%-- 뉴스 데이터 출력하는 위치 --%>
      <table class="table table-striped">
       <tr>
         <td>
           <%
              for(Item i:list)
              {
           %>
                 <table class="table table-hover">
                  <tr>
                    <td class="text-center"><%=i.getTitle() %></td>
                  </tr>
                  <tr>
                    <td><%=i.getDescription() %></td>
                  </tr>
                  <tr>
                    <td class="text-right"><%=i.getAuthor() %></td>
                  </tr>
                 </table>
           <%
              }
           %>
         </td>
       </tr>
      </table>
    </div>
  </div>
</body>
</html>







