<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:350px;
}
h1 {
   text-align: center;
}
</style>
</head>
<body>
   <div class="container">
    <div class="row">
      <h1>로그인</h1>
      <form action="login_ok.do" method="post">
      <table class="table">
       <tr>
         <td width=25% class="text-right">ID</td>
         <td width=75%>
           <input type=text name=id size=15>
         </td>
       </tr>
       <tr>
         <td width=25% class="text-right">PW</td>
         <td width=75%>
           <input type=password name=pwd size=15>
         </td>
       </tr>
       <tr>
         <td class="text-center" colspan="2">
           <input type=submit value="로그인">
           <input type=button value="취소" onclick="javascript:history.back()">
         </td>
       </tr>
      </table>
      </form>
    </div>
   </div>
</body>
</html>