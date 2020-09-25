<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>회원정보</h1>
  <form method=post action="output2.jsp">
    이름:<input type=text name=name size=15><br>
    성별:<input type=radio name=sex value="남자" checked>남자
      <input type=radio name=sex value="여자">여자<br>
   나이:<input type=text name=age size=15><br>
   주소 :<input type=text name=addr size=30><br>
   전화 :<input type=text name=tel size=30><br>
   <input type=submit value=전송>
   </form>
</body>
</html>