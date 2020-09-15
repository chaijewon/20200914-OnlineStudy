<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
  이미지 제어 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.image {
  width:500px;
  height:500px;
  border:2px solid red;
  background-image: url('a.jpg');
  background-size: cover;/*이미지를 축소/확대*/
}
h1 {
  font-family: sans-serif;
  text-align: center;
  padding-top: 200px;
  color:white;
}
</style>
</head>
<body>
  <div class="image">
    <h1>Hello CSS!!</h1>
  </div>
</body>
</html>