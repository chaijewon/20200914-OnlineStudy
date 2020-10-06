<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto; /*가운데 정렬*/
   width:300px;
}
h1 {
     text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h1 class="text-center">삭제하기</h1>
      <%--
                        no                no,pwd
             detail.jsp ====> delete.jsp  =====> delete_ok.jsp <==> BoardDAO
                                                => HTML,Java => 분리 BoardManager
             
                        no                no,pwd                결과값 (페이지변경)
             detail.jsp ====> delete.jsp  =====> delete_ok.jsp <====> BoardManager
                                                                           ↓↑
                                                                       BoardDAO 
                                                                           ↓↑
                                                                         Oracle
       --%>
      <form method=post action="delete_ok.jsp">
      <table class="table table-striped">
        <tr>
          <td>
                   비밀번호:<input type=password name=pwd size=15 class="input-sm">
                <input type=hidden name=no value="${param.no }">
          </td>
        </tr>
        <tr>
          <td class="text-center">
            <input type=submit value="삭제" class="btn btn-sm btn-danger">
            <input type=button value="취소" class="btn btn-sm btn-warning"
             onclick="javascript:history.back()">
          </td>
        </tr>
      </table>
      </form>
    </div>
  </div>
</body>
</html>










