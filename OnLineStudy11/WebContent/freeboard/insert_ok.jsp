<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%-- 사용자가 보네준 데이터(게시물)를 받아서 DAO와 연결 => list.jsp로 이동  --%>
<%
    // 한글 => 한글 변환 코드 
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="vo" class="com.sist.dao.BoardVO">
  <%-- BoardVO vo=new BoardVO() : 메모리 할당 --%>
  <%-- vo에 사용자가 보내준 값을 채운다--%>
  <jsp:setProperty name="vo" property="*"/>
  <%--
      vo.setName(request.getParameter("name"))
      vo.setSubject(request.getParameter("subject"))
      vo.setContent(request.getParameter("content"))
      vo.setPwd(request.getParameter("pwd"))
   --%>
</jsp:useBean>
<%
     //BoardDAO.freeboardInsert(vo); mapper.xml(SQL) => DAO(처리)
     BoardDAO.freeBoardInsert(vo);
     // 화면 이동 
     response.sendRedirect("../main/main.jsp?mode=9");// freeboard/list.jsp
%>










