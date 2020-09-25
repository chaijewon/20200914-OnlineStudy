<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.temp.*"%>
<%
    // 사용자 보내준 데이터 받기
    // 한글 => 변환
    request.setCharacterEncoding("UTF-8");
    String name=request.getParameter("name");
    String sex=request.getParameter("sex");
    String age=request.getParameter("age");
    String addr=request.getParameter("addr");
    String tel=request.getParameter("tel");
    
    // 한개의 클래스 묶어서 관리 
    MemberBean bean=new MemberBean();
    bean.setName(name);
    bean.setSex(sex);
    bean.setAge(Integer.parseInt(age));
    bean.setAddr(addr);
    bean.setTel(tel);
    // DAO => 묶은 값을 전송 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 묶여 있는 데이터 출력  -->
   이름:<%= bean.getName() %><br>
  성별:<%=bean.getSex() %><br>
  나이:<%=bean.getAge() %><br>
  주소:<%=bean.getAddr() %><br>
 전화:<%=bean.getTel() %>
</body>
</html>




