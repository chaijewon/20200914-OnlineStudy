<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/*
   <img src="" width=100%> => height까지 결정 
   1) float , z-index...
*/
.image {
   width:500px;
   height:500px;
   border:1px solid red;
   background: url('b.jpg') no-repeat left top;
   /*background-size: auto;*/
   /*background-size: 100px 200px;*/
   /* background-size:40% 60% */
   /* background-size: contain; */
   /* background-size: 100% 100%; */
   background-size: cover;
}
</style>
</head>
<body>
  <div class="image"></div>
</body>
</html>