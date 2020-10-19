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
    margin: 0px auto;
    width:300px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
// window.onload
$(function(){
	$('#idcheckBtn').click(function(){
		let id=$('#id').val();// <input type=text id=id class="input-sm" size=15>에 입력한값
		// let id=document.getElementById("id").value;
		if(id=="")//id가 입력이 없는 경우
		{
			$('#id').focus();
			return;
		}
		// idcheck_ok.do?id=hong
		$.ajax({
			type:'post',
			url:'../member/idcheck_ok.do',
			data:{"id":id},
			success:function(result)
			{
				let count=result.trim();
				// 0 , 1
				if(count==0)//ID가 없는 상태
				{
					$('#idcheck_result').html("<font color=blue>사용 가능한 아이디입니다</font>");
					$('#ok').html('<input type=button value=확인 onclick="ok()">')
				}
				else // ID가 있는 상태
				{
					$('#idcheck_result').html("<font color=red>이미 사용중인 아이디입니다</font>");
				}
			}
		})
	})
});
function ok()
{
	opener.joinFrm.id.value=$('#id').val();
	self.close();// 팝업 (아이디 중복체크)
}
</script>
</head>
<body>
   <div class="container">
     <div class="row">
       <h3>아이디중복체크</h3>
       <table class="table">
         <tr>
           <td>
            ID:<input type=text id=id class="input-sm" size=15>
            <input type=button value="중복체크" id="idcheckBtn" class="btn btn-sm btn-primary">
           </td>
         </tr>
         <tr>
           <td class="text-center" id="idcheck_result"></td><%-- 결과 --%>
         </tr>
         <tr>
           <td class="text-center" id="ok"></td><%--확인 --%>
         </tr>
       </table>
     </div>
   </div>
</body>
</html>





