<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form method=post action="../member/login_ok.jsp">
   <%--
       method => get/post
       action => 데이터를 받을 파일명
    --%>
   <table class="table">
     <tr>
       <td class="text-right">ID</td>
       <td>
         <input type=text class="input-sm" name=id>
       </td>
     </tr>
     <tr>
       <td class="text-right">PW</td>
       <td>
         <input type=password class="input-sm" name=pwd>
       </td>
     </tr>
     <tr>
       <td class="text-right" colspan="2">
         <input type=submit value="로그인" class="btn btn-sm btn-success">
       </td>
     </tr>
   </table>
   </form>
</body>
</html>