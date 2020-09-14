<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
/* div 태그 바로 밑에 있는 경우 */
div > p {
  color:red;
  font-size: 35px;
}
/*
      doc.select("div span p")
*/
div span p {
  color:blue;
  font-size: 30px;
}
a{
    /* 검정색 , 언더라인 */
    text-decoration: none;
    color:black;
}
/*클릭하기 위해 문자위에 마우스를 올린 경우 : 가상 셀렉터*/
a:hover{
   text-decoration: underline;
   color:green; 
}
img { 
   /* 투명 : 0.0~1.0*/
   opacity: 1.0;
}
img:hover{
   opacity: 0.3;
}
</style>
</head>
<body>
  <center>
    <div>
      <p>Java</p>
      <p>JavaScript</p>
      <span><p>Oracle</p></span>
    </div>
    
    <a href="#">Hello1</a><br>
    <a href="#">Hello2</a><br>
    <img src="a.jpg" width=300 height=350>
    <img src="b.jpg" width=300 height=350>
  </center>
</body>
</html>





