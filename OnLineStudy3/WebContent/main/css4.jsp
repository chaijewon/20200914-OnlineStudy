<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
   inline / block
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/*가로 (img), 세로 */
.inline img {
   width:100px;
   height:150px;
   display:inline;
   margin: 10px;/* top=10 left=10 bottom=10 right=10*/
}
.block img{
   width:100px;
   height:150px;
   display:block;
   margin: 10px;
}
nav {
   background-color: #999;
}
nav ul li{
  display: inline-block;
  margin: 20px;
  /* color:white; */
}
a {
    text-decoration: none;
    color:white;
    font-family: 맑은 고딕;
}
a:hover{
   text-decoration: underline;
   color:green;
   font-family: 맑은 고딕;
}
div {
  width: 100px;
  height: 100px;
  margin: 30px;
  display: inline-block;
  /*HTML5 => 테이블 사용을 금지 권장*/
}
</style>
</head>
<body>
  <!-- <div class="inline">
   <img src="b.jpg">
   <img src="b.jpg">
   <img src="b.jpg">
  </div>
  <div class="block">
   <img src="b.jpg">
   <img src="b.jpg">
   <img src="b.jpg">
  </div> -->
  <!-- 
     header 
     section
     aside
     footer
     nav
     
     =========================================
                 header(로고) 해당이미지
     =========================================
                 nav (메뉴)
     =====================|====================
                          |
                          |
          내용 (section)        |  부가설명(날씨) aside
                          |
                          |
     =========================================
                                회사정보 (footer)
     =========================================
     
   -->
  <nav><!-- 메뉴 -->
    <ul>
      <li><a href="#">영화</a></li>
      <li><a href="#">음악</a></li>
      <li><a href="#">맛집</a></li>
      <li><a href="#">레시피</a></li>
      <li><a href="#">쇼핑몰</a></li>
    </ul>
  </nav>
  <div style="background: green"></div>
  <div style="background: red"></div>
  <div style="background: blue"></div>
</body>
</html>