<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
/* function send(){
	// 태그 ==> 객체
	let f=document.frm;
	if(f.name.value==="")
	{
		f.name.focus();
		return;
	}
	alert(f.name.value);
} */
$(function(){
	$('#btn').click(function(){
		if($('#name').val()==="")
			{
			   $('#name').focus();
			   return;
			}
		alert($('#name').val())
	})
})
// id , class => jquery,css
// name => 자바에서 전송 받을 목적 
</script>
</head>
<body>
   <form name=frm>
    이름:<input type=text name=name size=15 id=name>
    <input type=button value="전송" id="btn">
   </form>
</body>
</html>