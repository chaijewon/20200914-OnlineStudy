<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table class="table">
     <tr>
       <td>
         <%= session.getAttribute("name") %>님 로그인 되었습니다!!
       </td>
     </tr>
     <tr>
       <td>
         <%
            String admin=(String)session.getAttribute("admin");
            if(admin.equals("y"))
            {
         %>
                 <b><font color=blue>관리자</font></b>
         <%
            }
            else
            {
         %>
                <b><font color=blue>일반유저</font></b>
         <%	
            }
         %>
       </td>
     </tr>
     <tr>
       <td class="text-right">
         <form method=post action="../member/logout_ok.jsp">
           <input type=submit value="로그아웃" class="btn btn-sm btn-success">
         </form>
       </td>
     </tr>
   </table>
</body>
</html>


