<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
var i=1;
$(function(){
	$('#btn').click(function(){
		$('#tab').append('<tr><td>'+i+'</td><td>홍길동</td></tr>');
		i++;
	})
});
</script>
</head>
<body>
   <input type=button value="추가" id="btn"><br>
   <table width=300 border=1 bordercolor=black id="tab">
    
   </table>
</body>
</html>