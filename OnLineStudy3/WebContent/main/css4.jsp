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
</style>
</head>
<body>
  <div class="inline">
   <img src="b.jpg">
   <img src="b.jpg">
   <img src="b.jpg">
  </div>
  <div class="block">
   <img src="b.jpg">
   <img src="b.jpg">
   <img src="b.jpg">
  </div>
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
  
  </nav>
</body>
</html>