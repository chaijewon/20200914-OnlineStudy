<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.temp.*"%>
<%
     // 한글 변환
     request.setCharacterEncoding("UTF-8");
%>
<%--
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
 --%>
<jsp:useBean id="bean" class="com.sist.temp.MemberBean">
  <%-- MemberBean bean=new MemberBean() 
       <jsp:useBean> => 메모리 할당 (new)
       
       setProperty ==> setter => 값을 채워주는 태그 (JSP)
             자동으로 setter => 태그(라이브러리)
  --%>
  <jsp:setProperty name="bean" property="*"/>
  <%--
       <jsp:setProperty name="bean">
       bean.setName(request.getParameter("name"));
       bean.setSex(request.getParameter("sex"));
       bean.setAge(Integer.parseInt(request.getParameter("age")));
       bean.setAddr(request.getParameter("addr"));
       bean.setTel(request.getParameter("tel"));
          정수가 있는 경우 자동으로 Integer.parseInt(age)
          
          ==> 한개값을 받는 경우 
              ============= page,no => request를 이용해서 받는 것이 좋다
                           사용자가 보내주는 데이터가 많은 경우에 사용 
                            글쓰기 , 회원가입 , 공지사항 
                            
                            
           Spring 
           public String memberInsert(MemberVO vo)
   --%>
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 묶여 있는 데이터 출력  -->
<h1>jsp action태그로 받기</h1>
   이름:<%= bean.getName() %><br>
  성별:<%=bean.getSex() %><br>
  나이:<%=bean.getAge() %><br>
  주소:<%=bean.getAddr() %><br>
  전화:<%=bean.getTel() %>
</body>
</html>