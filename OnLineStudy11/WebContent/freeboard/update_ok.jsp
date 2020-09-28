<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    // 한글 변환 
    request.setCharacterEncoding("UTF-8");
%>
<%-- 메모리 할당 (BoardVO) --%>
<%--
      BoardVO vo=new BoardVO();
 --%>
<!-- HTML 사용금지  -->
<jsp:useBean id="vo" class="com.sist.dao.BoardVO">
  <%-- vo가 가지고 있는 setXxx()에 모든 값을 채운다  --%>
  <jsp:setProperty name="vo" property="*"/>
  <%--
        vo.setName(request.getParameter("name"))
        vo.setSubject(request.getParameter("subject"))
        vo.setContent(request.getParameter("content"))
        vo.setPwd(request.getParameter("pwd"))
        vo.setNo(Integer.parseInt(request.getParameter("no")))
   --%>
</jsp:useBean>
<%
     // BoardDAO ==> vo를 전송하면 ==> 수정  ==> 수정 (SQL:board-mapper.xml)
     boolean bCheck=BoardDAO.freeBoardUpdate(vo);
     // 이동 ==> detail.jsp  ===> 이동 : response.sendRedirect()
     if(bCheck==true)
     {
    	 response.sendRedirect("../main/main.jsp?mode=11&no="+vo.getNo());
     }
     else
     {
%>
         <script>
          alert("비밀번호가 틀립니다!!");
          history.back(); // 원래 상태로 복귀 (update.jsp로 다시 이동)
          // Ajax를 이용해서 처리 
         </script>
<%
     }
%>











