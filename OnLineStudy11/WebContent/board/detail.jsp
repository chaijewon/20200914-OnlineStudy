<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%-- View(화면 출력만 한다) 
     DAO안에 있는 메소드 호출 => 데이터를 가지고 온다 
     HTML,JavaScript => 오라클 연결이 불가능 
          ========== node.js = Spring (서버단)
--%>
<%
    // 1. main.jsp를 통해서 전달된 no(게시물)라는 변수값
    // ../main/main.jsp?mode=3&no=10
    String no=request.getParameter("no");
    DataBoardVO vo=DataBoardDAO.boardDetailData(Integer.parseInt(no));
    // 웹에서 데이터가 넘어오면 모든 데이터 문자열(String) => 필요시마다 정수,실수변환 
    // 사용자가 볼 수 있게 화면 출력한다 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
       <%
          if(vo.getFilesize()>0) // 업로드된 파일 존재하면 
          {
       %>
             <tr>
               <th class="text-center danger" width=20%>첨부파일</th>
               <td colspan="3">
                 <%-- 다운로드 
                      board와 관련 => board폴더 => download.jsp
                                        현재 상태
                        => detail.jsp => board(X),main(O)
                 --%>
                 <a href="../board/download.jsp?fn=<%=vo.getFilename()%>"><%=vo.getFilename() %></a>(<%=vo.getFilesize() %>Bytes)
               </td>
             </tr>
       <%
          }
       %>
       <tr>
         <td colspan="4" class="text-left" valign="top" height=200>
          <%-- 한줄 문자열 --%>
          <pre style="white-space: pre-wrap;background-color:white;border:none"><%=vo.getContent() %></pre>
         </td>
       </tr>
       <tr>
         <td colspan="4" class="text-right">
           <a href="#" class="btn btn-xs btn-primary">수정</a>
           <a href="../main/main.jsp?mode=5" class="btn btn-xs btn-success">삭제</a>
           <a href="../main/main.jsp?mode=1" class="btn btn-xs btn-danger">목록</a>
         </td>
       </tr>
     </table>
   </div>
</body>
</html>










