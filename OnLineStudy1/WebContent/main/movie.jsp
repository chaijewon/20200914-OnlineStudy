<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
   // 데이터 가지고 오기
   EmpDAO dao=new EmpDAO();
   ArrayList<String> list=dao.movieGetPoster();
%>
<%--
    CSS => 태그를 선택해서 처리 
    1) 태그명 
       태그명 {속성:값;속성:값...}
    2) ID명
    #ID명 {속성:값;속성:값...}
    3) class명
    .class명 {속성:값;속성:값...}
    4) 복합셀렉터 
        = 자손
        상위태그 > 자손태그 {속성:값;속성:값...}
        <div> ==> h1,h1,span
          <h1></h1>
          <h1></h1>
          <span><h1></h1></span>
         </div>
        = 후손 
        상위태그  자손태그 {속성:값;속성:값...}
        <div> ==> h1,h1,span
          <h1></h1>
          <h1></h1>
          <span><h1>후손</h1></span>
         </div>
    5) 가상셀렉터
      태그명:hover  태그명:focus... 태그명:first
   =======================

 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
img {
   opacity: 1.0;
   /* 굵기 , 라인종류 , 색상 */
   /*
        라인종류 
        solid : 일반 라인선 
        dot : 점선 ......
        dash : ------
   */
   border: 2px double red;
} 
img:hover{
   opacity: .3;
   cursor: pointer;
}
</style>
</head>
<body>
  <center>
    <h1 id="movie_text">영화목록</h1>
    <table id="user-table" width=800>
      <tr>
        <%
           for(String poster:list)
           {
        %>
             <td align="center">
              <img src="<%=poster %>" width=150 height=250>
             </td>
        <%
           }
        %>
      </tr>
    </table>
  </center>
</body>
</html>