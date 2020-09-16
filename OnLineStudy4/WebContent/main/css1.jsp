<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrap{
   width:960px;
   margin: 0px auto; /*가운데 정렬*/
}
#box1{
   width:30%;
   height: 700px;
   background-color: red;
   float: left;
}
#box2{
   width:70%;
   height: 350px;
   background-color: blue;
   float: left;
}
#box3{
   width:70%;
   height: 350px;
   background-color: yellow;
   float: left;
}
</style>
</head>
<body>
<%--
   http://newssearch.naver.com/search.naver?where=rss&query=영화
                                      ----- MVC (확장자를 사용자 마음대로 설정) => 70%
   https://mvnrepository.com 
     => jaxb ==> jar파일 다운로드
     => simple-json => jar.파일 다운로드
     
     ================================
             |
             |
             |=======================
             |
             |
     ================================
 --%>
 <div id="wrap">
   <div id="box1"></div>
   <div id="box2"></div>
   <div id="box3"></div>
 </div>
</body>
</html>



