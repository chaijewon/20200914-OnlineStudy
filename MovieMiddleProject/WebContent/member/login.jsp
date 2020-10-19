<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('#logBtn').click(function(){
		$('#log').text("");
		$('#can').text("");
		var id=$('#id').val();
		if(id.trim()=="")
		{
			$('#log').html("<font color=red>아이디를 입력하세요</font>");
			return;
		}
		var id=$('#pwd').val();
		if(id.trim()=="")
		{
			$('#can').html("<font color=red>비밀번호를 입력하세요</font>");
			return;
		}
	})
});
</script>
</head>
<body>
  <div class="row row1">
   <table class="table">
     <tr>
       <td width=30% class="text-right">아이디</td>
       <td width=70%>
         <input type=text id=id1 size=15 class="input-sm">
         <div id="log"></div>
       </td>
     </tr>
     <tr>
       <td width=30% class="text-right">비밀번호</td>
       <td width=70%>
         <input type=password id=pwd2 size=15 class="input-sm">
         <div id="can"></div>
       </td>
     </tr>
     <tr>
       <td colspan="2" class="text-center">
         <input type=button value="로그인" class="btn btn-sm btn-danger" id="logBtn">
         <input type=button value="취소" class="btn btn-sm btn-success" id="canBtn">
       </td>
     </tr>
   </table>
  </div>
</body>
</html>