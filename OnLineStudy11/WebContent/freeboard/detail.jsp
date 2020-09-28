<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    String no=request.getParameter("no");
    BoardVO vo=BoardDAO.freeBoardDetailData(Integer.parseInt(no));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%-- DAO에서 값을 가지고 온다 : board-mapper.xml에서 SQL문장을 작성  --%>
   <div class="row">
     <h1 class="text-center">내용보기</h1>
     <table class="table table-striped">
       <tr>
         <th class="text-center danger" width=20%>번호</th>
         <td class="text-center" width=30%><%=vo.getNo() %></td>
         <th class="text-center danger" width=20%>작성일</th>
         <td class="text-center" width=30%><%=vo.getDbday() %></td>
       </tr>
       <tr>
         <th class="text-center danger" width=20%>이름</th>
         <td class="text-center" width=30%><%=vo.getName() %></td>
         <th class="text-center danger" width=20%>조회수</th>
         <td class="text-center" width=30%><%=vo.getHit() %></td>
       </tr>
       <tr>
         <th class="text-center danger" width=20%>제목</th>
         <td colspan="3"><%=vo.getSubject() %></td>
       </tr>
       <tr>
         <td colspan="4" class="text-left" valign="top" height=200>
          <%-- 한줄 문자열 --%>
          <pre style="white-space: pre-wrap;background-color:white;border:none"><%=vo.getContent() %></pre>
         </td>
       </tr>
       <tr>
         <td colspan="4" class="text-right">
           <%-- ../main/main.jsp?mode=6 --%>
           <%-- ../board/update.jsp --%>
           <a href="../main/main.jsp?mode=12&no=<%=vo.getNo() %>" class="btn btn-xs btn-primary">수정</a>
           <%-- ../board/delete.jsp --%>
           <a href="../main/main.jsp?mode=13&no=<%=vo.getNo() %>" class="btn btn-xs btn-success">삭제</a>
           <%-- ../board/list.jsp --%>
           <a href="../main/main.jsp?mode=9" class="btn btn-xs btn-danger">목록</a>
         </td>
       </tr>
     </table>
   </div>
</body>
</html>










