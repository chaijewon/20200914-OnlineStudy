<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
   폴더에 저장 
   원격으로 사용이 가능 
 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
/*
    twitter에서 만든 반응형웹 => CSS라이브러리 
    외부CSS ==> 수정 (내부CSS)
    
    1) container : 960px => 양쪽에 여백  ===> wrap
    2) container-fluid : full 화면 
*/
.container{
   border: 1px solid black;
   height: 800px;
}
.col-sm-3{
   border:1px solid red;
   height: 350px;
}
.col-sm-6{
   border:1px solid red;
   height: 350px;
}
/*
    col-sm-(4)  => lg , sm  md xs => 화면 크기 (해상도에 따라 설정)
          =====
          설정해서 12가 넘어가면 다음줄에 출력 
    
    ===================
    12개로 나눈다       ==> 
    ===================
    
    960/12 ==> col-sm-1 값 
*/
</style>
</head>
<body>
   <div class="container"> <%-- block --%>
     
     <div class="col-sm-6"><%-- float:left inline --%>
     
     </div>
     <div class="col-sm-6">
     
     </div>
     <div class="col-sm-3">
     
     </div>
     <div class="col-sm-3">
     
     </div>
   </div>
</body>
</html>







