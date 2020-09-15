<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/*
   공통부분을 먼저 처리 
   태그마다 다른 속성을 처리 
*/
.box1 {
  width:400px;
  height: 100px;
  background: #ccffcc;
}
.box2 {
   width:600px;
   height: 100px;
   background: #ccccff;
   padding: 50px;
}
/*공통으로 적용하는 부분*/
div{
  margin: 10px;
}
</style>
</head>
<body>
  <div class="box1">
  
  </div>
  <div class="box1">
  
  </div>
  <div class="box2">
   <h1>Hello</h1>
  </div> 
  <div class="box2">
  
  </div>
</body>
</html>