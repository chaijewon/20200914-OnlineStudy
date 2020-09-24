<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    // detail.jsp ==> 번호(게시물)
    String no=request.getParameter("no");
    // 다른 JSP에서 => 데이터값을 보내면 ==> request를 통해서 값을 받아 온다 
    // 오라클에서 게시물 번호에 해당되는 데이터를 읽어 온다 
    // 화면 출력 
    DataBoardVO vo=DataBoardDAO.boardUpdateData(Integer.parseInt(no));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
   <h1 class="text-center">수정하기</h1>
   <%-- 파일 업로드 : 프로토콜 (post)
        enctype="multipart/form-data" => 업로드시만 사용 
               프로토콜
          http : 80
          ftp  : 21
          smtp : 25
          multipart/form-data : 파일을 업로드 
                  범용적으로 사용되는 약속 
    --%>
   <form method="post" action="../board/update_ok.jsp">
   <table class="table table-hover">
     <tr>
       <th class="danger text-right" width=15%>이름</th>
       <td width=85%>
         <input type=text name=name size=15 class="input-sm" value="<%=vo.getName()%>">
         <%--게시물 번호를 첨부해 보내준다 --%>
         <input type=hidden name=no value="<%=no%>">
       </td>
     </tr>
     <tr>
       <th class="danger text-right" width=15%>제목</th>
       <td width=85%>
         <input type=text name=subject size=45 class="input-sm" value="<%=vo.getSubject()%>">
       </td>
     </tr>
     <tr>
       <th class="danger text-right" width=15%>내용</th>
       <td width=85%>
         <textarea rows="10" cols="50" name=content><%=vo.getContent() %></textarea>
       </td>
     </tr>
     <!-- <tr>
       <th class="danger text-right" width=15%>첨부파일</th>
       <td width=85%>
         <input type=file name=upload size=20 class="input-sm">
       </td>
     </tr> -->
     <tr>
       <th class="danger text-right" width=15%>비밀번호</th>
       <td width=85%>
         <input type=password name=pwd size=10 class="input-sm">
       </td>
     </tr>
     <tr>
       <td colspan="2" class="text-center">
         <input type=submit value=수정 class="btn btn-sm btn-primary">
         <input type=button value=취소 class="btn btn-sm btn-primary"
           onclick="javascript:history.back()"
         >
       </td>
     </tr>
   </table>
   </form>
  </div>
</body>
</html>
