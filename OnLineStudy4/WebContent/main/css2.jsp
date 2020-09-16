<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrap{
  width:960px; /*bootstrap : container (전체 화면 , width :960px)*/
  height:900px;
  margin:0px auto; /*가운데 정렬*/
  font-size:20px;
  text-align: center;
}
#header{
  width:960px;
  height:100px;
  background-color: cyan;
  line-height: 100px;/*글자나 이미지 위치 정렬*/
}
#nav{
   width:960px;
   height:100px;
   background-color: yellow;
   line-height: 100px;/*글자나 이미지 위치 정렬*/
}
#aside {
   width:300px;
   height:600px;
   background-color: green;
   line-height: 600px;
   float: left;
}
#section{
   width:660px;
   height:600px;
   background-color: red;
   line-height: 600px;
   float: left;
}
#footer{
   width:960px;
   height:100px;
   background-color: black;
   line-height: 100px;/*글자나 이미지 위치 정렬*/
   color:white;
   float: left;
}
</style>
</head>
<body>
 <%--
    =================================== => id=wrap(container)
                   로고 => header  => 날씨 , 실시간 검색어
    ===================================
                   메뉴 => nav
    ===================================
           |
     로그인       |
   부가정보      |
 (aside)   |      실제 출력 화면 (section)
           |
           |
           |
    ===================================
                  회사 정보 (footer)
    ===================================
 
  --%>
  <div id="wrap">
    <div id="header">Header(회사로고)</div>
    <div id="nav">nav(메뉴)</div>
    <div id="aside">aside(부가정보,로그인창)</div>
    <div id="section">section(실제 출력부분)</div>
    <div id="footer">footer(회사정보,개인정보방침)</div>
  </div>
  <%--
     HTML5 => 태그명 (태그를 쉽게 찾을 수 있게 만든다 : 시멘텍)
     <div id="wrap">
       <header></header>
       <nav></nav>
       <aside></aside>
       <section></section>
       <footer></footer>
     </div>
  --%>
</body>
</html>




