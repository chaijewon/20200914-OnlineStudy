<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>로그인</h1>
  <form method="post" action="../main/output2.do">
    <input type=text name=id size=15><br>
    <input type=password name=pwd size=15><br>
    <button>전송</button>
    <%--
        <input type=submit>
        <button>
        <input type=image>
     --%>
  </form>
</body>
</html>