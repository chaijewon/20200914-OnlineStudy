<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- delete_ok.jsp : 데이터 받아서 처리만 하고 다른 jsp로 이동 (HTML을 사용 할 필요가 없다)--%>
<%
     // detail.jsp에서 데이터를 두개 보냄 (게시물 번호 , 비밀번호)
     // 한글이 없다 ==> request.setCharacterEncoding() X
     
     String no=request.getParameter("no");
     String pwd=request.getParameter("pwd");
     
     // DAO 연결 => 비밀번호가 같으면 (삭제) , 비밀번호가 틀리면 삭제하지 않는다 
     // DAO를 연결 => SQL문장 (databoard-mapper.xml)
     
%>