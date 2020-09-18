<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    /*
         1. 사용자가 보내준 데이터를 받는다 
                      사용자가 보내준 모든 데이터  => request에 들어가 있다
                      사용자가 요청 할때마다 톰캣이 request에 모아서 넘겨준다 (getParameter())
         2. 사용자로부터 받은 데이터를 DAO에 넘겨준다 
         3. DAO가 요청한 데이터 보내준다 
         4. DAO로부터 받은 데이터 화면에 출력 (HTML=>JAVA를 포함 사용 => JSP)
            ==> HTML , JAVA 나눠서 처리 ==> M(Java)V(HTML) => 연결 (Controller:서블릿)
            ==> JAVA + ORACLE ==> Java(.java:DAO) , Oracle(XML) 나눠서 처리 
    */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:900px;
}
h1 {
    text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h1>쉐프 목록</h1>
    <div class="row">
      <table class="table">
       <tr>
        <td>
          <%-- 데이터가 출력할 위치 --%>
        </td>
       </tr>
      </table>
    </div>
  </div>
</body>
</html>



