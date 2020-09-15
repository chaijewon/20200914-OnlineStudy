<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 
  1. 간격
     margin , padding
  2. 정렬
     text-align: left , right , center
  3. \n , \n없는 경우
     display:block , display:inline
  4. font 관련 
     font-size
     font-family
     font-weight
  5. 색상 
     color (글자 색상)
     background-color(바탕색)
  6. 넓이  : width
  7. 크기  : height
  
  => text 관련
     => 웹사이트 => 문자열 
     color 지정 
     1)글자 색상 : color 
     => color:red
     => color:RGB(255,255,255)
     => color:RGBA()
     2)text-decoration:none , underline
     ***3)text-align:left,center,right
     4)text-shadow:none|(가로거리) 세로거리 번짐정도 색상
     5)text-transform : 대문자 변환,소문자변환
     ***6)white-space
  => img 관련 
  
  => div 관련
  
  => span 관련 
  
  => 애니메이션 
  
  => CSS3
      = 브라우저마다 속성명이 다르다 
     
 -->
<style type="text/css">
h1 {
   color:rgb(0,200,0);/*그림판에서 색상을 선택 => RGB css파일을 제작하면 색상선택*/
}
h2 {
    color:blue;
}
h3 {
   text-decoration: underline;
   /*a 태그는 기본 : underline*/
}
.t {
   text-transform: uppercase;/*대문자*/
}
.t1 {
    text-transform: capitalize;/*INITCAP*/
}
.t2 {
      text-transform: lowercase;/*소문자 출력*/
}
#h1{
   color: orange;
}
#h2{
     text-shadow: 5px 5px 3px #f00;
}
#h3{
   color:#FFF;/*흰색*/
   text-shadow:7px -7px 5px #000;
}
</style>
</head>
<body>
 <!-- color -->
 <h1>10000개의 레시피</h1>
 <h2>레시피종류</h2>
 <h3>탕/국</h3>
 <ul>
   <li class="t">java</li>
   <li class="t">oracle</li>
   <li class="t1">spring</li>
   <li class="t2">MYBATIS</li>
 </ul>
 <h1 id="h1">HTML&CSS</h1>
 <h1 id="h2">HTML&CSS</h1>
 <h1 id="h3">HTML&CSS</h1>
</body>
</html>



