<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
  border:1px solid black;
  height: 760px;
}
.row{
  /* border:1px solid red;
  height:350px; */
  /*가운데 정렬 */
  margin: 0px auto;
  width:700px;
}
h1 {
     /*문자 정렬*/
     text-align:center;
     font-family: 맑은 고딕;
}

</style>
</head>
<body>
  <%-- 
       ======================================
       
            <div class="row"></div>
       --------------------------------------
       
            <div class="row"></div>
       --------------------------------------
       
            <div class="row"></div>
       ====================================== container
       
       
       table => table-bordered 
             => table-hover
             => table-striped
  
  --%>
  <%-- table input --%>
  <!-- row =>  한줄 -->
  <div class="container">
    <div class="row">
      <h1>사원목록</h1>
      <table class="table table-bordered">
      <%--
                  색상 
           => danger : red(분홍)
           => success : 녹색
           => warning : 주황색
           => info  : 하늘색
           => default : 회색
           
           .info{
              background-color:cyan
           }
       --%>
        <tr class="info">
          <%-- text-center 가운데 정렬
               text-left
               text-right
          --%>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">근무지</th>
          <th class="text-center">부서명</th>
        </tr>
        <tr>
          <td class="text-center">1</td>
          <td class="text-center">홍길동</td>
          <td class="text-center">대리</td>
          <td class="text-center">서울</td>
          <td class="text-center">개발부</td>
        </tr>
        <tr>
          <td class="text-center">2</td>
          <td class="text-center">심청이</td>
          <td class="text-center">대리</td>
          <td class="text-center">서울</td>
          <td class="text-center">개발부</td>
        </tr>
        <tr>
          <td class="text-center">3</td>
          <td class="text-center">박문수</td>
          <td class="text-center">대리</td>
          <td class="text-center">서울</td>
          <td class="text-center">개발부</td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>





