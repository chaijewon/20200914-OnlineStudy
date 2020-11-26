<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="latest-products">
      <div style="height: 130px"></div>
        <div class="container">
         <div class="row">
			  <div class="col-md-8">
			    <h3 class="text-center">삭제하기</h3>
			    <form method=post action="../board/delete_ok.do">
			    <table class="table">
			      <tr>
			        <td width=30% class="text-right">비밀번호</td>
			        <td width=70%>
			          <input type=password name=pwd class="input-sm" size=15>
			          <input type=hidden name=no value="${no }">
			        </td>
			      </tr>
			      <tr>
			        <td colspan="2" class="text-center">
			          <input type=submit value="삭제" class="btn btn-sm btn-primary">
			          <input type=button value="취소" class="btn btn-sm btn-danger"
			           onclick="javascript:history.back()">
			        </td>
			      </tr>
			    </table>
			    </form>
			  </div>
			  <div class="col-md-4">
			  </div>
		  </div>
		 </div>
</div>
</body>
</html>


