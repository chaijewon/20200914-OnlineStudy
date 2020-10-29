<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var m=10;
function test()
{
	m=20;
}
function test2()
{
	alert("m="+m);
}
window.onload=function()
{
	test();
	test2();
}
</script>
</head>
<body>

</body>
</html>