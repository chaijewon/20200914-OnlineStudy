<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 1. 사용자가 보낸 id,pwd
    String id=request.getParameter("id");
    //<input type=text class="input-sm" name=id> => hong
    //
    String pwd=request.getParameter("pwd");
    //<input type=password class="input-sm" name=pwd>
    // pwd=1234
    // login_ok.jsp?id=hong&pwd=1234
    // 2. DAO에서 => 로그인 
    // mapper.xml ==> SQL => DAO에 처리 
    // 3. 로그인이 되면 => main.jsp
%>