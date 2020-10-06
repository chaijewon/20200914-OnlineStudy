<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.manager.*"%>
<jsp:useBean id="mgr" class="com.sist.manager.BoardManager"/>
<%
    // DAO로 부터 전에 입력한 데이터 읽기 
    mgr.boardUpdateData(request);//BoardManager가 request에 결과값을 보내준다  
    //vo
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto; /*가운데 정렬*/
   width:700px;
}
h1 {
     text-align: center;
}
</style>
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
   <form method="post" action="update_ok.jsp">
   <table class="table table-hover">
     <tr>
       <th class="danger text-right" width=15%>이름</th>
       <td width=85%>
         <input type=text name=name size=15 class="input-sm" value="${vo.name }">
         <input type=hidden name=no value="${vo.no }">
         <!-- 
              ${param.no} => request.getParameter("no")
              String no=${param.no}(X)
              String no=out.println()(X)
              EL==> 출력용으로만 사용 
          -->
         <%--
           detail.jsp ==> 게시물 번호 넘긴다 
           update.jsp에서 저장하고 있다가 ==> update_ok.jsp 
          --%>
       </td>
     </tr>
     <tr>
       <th class="danger text-right" width=15%>제목</th>
       <td width=85%>
         <input type=text name=subject size=45 class="input-sm" value="${vo.subject }">
       </td>
     </tr>
     <tr>
       <th class="danger text-right" width=15%>내용</th>
       <td width=85%>
         <textarea rows="10" cols="50" name=content>${vo.content }</textarea>
       </td>
     </tr>
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