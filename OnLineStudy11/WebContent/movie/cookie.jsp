<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
  String no=request.getParameter("no");
  MovieVO vo=MovieDAO.movieDetailData(Integer.parseInt(no));
  Cookie cookie=new Cookie("m"+no,vo.getPoster());
  cookie.setPath("/");
  //cookie.setDomain("211.238.142.181");
  // 저장 
  // 기간 
  cookie.setMaxAge(60*60); // 하루 저장  (초단위)
  // 클라이언트 컴퓨터로 전송 
  // http://211.238.142.181
  response.addCookie(cookie);
  response.sendRedirect("../main/main.jsp?mode=8&no="+no);
%>