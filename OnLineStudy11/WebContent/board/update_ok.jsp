<%@page import="com.sist.dao.DataBoardDAO"%>
<%@page import="com.sist.dao.DataBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 기능만 처리 (화면 출력은 아니다) => 이동 --%>
<%
     request.setCharacterEncoding("utf-8");//디코딩
     // 한글 변환 (전송:인코딩 => 수신:디코딩)
     String name=request.getParameter("name");
     String no=request.getParameter("no");
     String subject=request.getParameter("subject");
     String content=request.getParameter("content");
     String pwd=request.getParameter("pwd");
     
     // DAO => VO에 모아서 전송해 달라
     DataBoardVO vo=new DataBoardVO();
     vo.setName(name);
     vo.setNo(Integer.parseInt(no));
     vo.setSubject(subject);
     vo.setContent(content);
     vo.setPwd(pwd);
     
     // DAO로 전송해서 처리 : 비밀번호 처리 => 본인이면 => 실제 수정 
     boolean bCheck=DataBoardDAO.boardUpdate(vo);
     /*
          1 = list.jsp
          2 = insert.jsp
          3 = detail.jsp
          4 = find.jsp
          5 = delete.jsp
          6 = update.jsp
     */
     if(bCheck==true)
     {
    	 response.sendRedirect("../main/main.jsp?mode=3&no="+no);// detail로 이동 
     }
     else
     {
%>
         <script>
         alert("비밀번호가 틀립니다");
         history.back();
         </script>
<%
     }
%>




