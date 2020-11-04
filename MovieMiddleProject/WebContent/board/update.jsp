<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1 {
   margin: 0px auto;
   width:700px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#pwd').keyup(function(){
		let pwd=$(this).val();
		if(pwd.trim()=="")
		{
			$('#result').html("<font color=red>비밀번호를 입력하세요</font>");
			return;
		}
		let no=$(this).attr("data-no");
		$.ajax({
			type:'post',
			url:'../board/password_ok.do',
			data:{"pwd":pwd,"no":no},
			success:function(result)
			{
				let msg=result.trim();
				if(msg=='YES')
				{
					$('#result').html("<font color=blue>수정이 가능합니다</font>");
					$('.sub').show();
				}
				else
				{
					$('#result').html("<font color=red>비밀번호가 틀립니다</font>");
					//$('#pwd').val("");
					//$('#pwd').focus();
				}
			}
		})
	})
});
</script>
</head>
<body>
  <div class="row row1">
   <h3 class="text-center">수정하기</h3>
   <form method="post" action="../board/update_ok.do">
   <table class="table table-hover">
     <tr>
       <th class="danger text-right" width=15%>이름</th>
       <td width=85%>
         <input type=text name=name size=15 class="input-sm" value="${vo.name }">
         <input type=hidden name=no value="${vo.no }">
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
         <input type=password name=pwd size=10 class="input-sm" id="pwd" data-no="${vo.no }">
       </td>
     </tr>
     <tr>
       <td colspan="2">
         <span id="result"></span>
       </td>
     </tr>
     <tr>
       <td colspan="2" class="text-center">
         <input type=submit value=수정 class="btn btn-sm btn-primary sub" style="display:none">
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
