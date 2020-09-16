<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   width:600px;
   margin: 0px auto;
}
</style>
</head>
<body>
  <%-- 망고플레이트 , 10000개의 레시피 (오픈소스) --%>
  <div class="container">
   <div class="row"><!-- container :960px -->
     <%-- input --%>
     <table class="table table-bordered">
       <tr>
         <th class="text-right danger" width=20%>이름</th>
         <td width=80%>
           <input type=text size=15 class="input-sm">
         </td>
       </tr>
       <tr>
         <th class="text-right danger" width=20%>부서명</th>
         <td width=80%>
           <select class="input-sm">
             <option>개발부</option>
             <option>영업부</option>
             <option>총무부</option>
           </select>
         </td>
       </tr>
       <tr>
         <%--
             btn-primary : 파랑색
             btn-success: 녹색
             btn-warning:주황색
             btn-danger :빨간색
             btn-info : 하늘색
             btn-active :회색
             
             btn-sm 
             btn-lg
             btn-xs
          --%>
         <td colspan="2" class="text-center">
           <input type=button class="btn btn-sm btn-primary" value="전송">
           <input type=button class="btn btn-sm btn-success" value="취소">
         </td>
       </tr>
     </table>
   </div>
  </div>
</body>
</html>







