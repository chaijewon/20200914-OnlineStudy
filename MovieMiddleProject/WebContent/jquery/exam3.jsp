<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	// input에 값을 첨부
	$('#name').val("홍길동");
	// click , change:select,hover
	$('#btn').click(function(){
		let name=$('#name').val();
		//$('div').text(name);// <div>값을 출력</div>
		// $('div').text(); //<div>값을 읽는다</div>
		$('div').append(name+"<br>");
	})
});
</script>
</head>
<body>
  이름:<input type=text id="name" size=15 value="">
  <input type=button value="실행" id="btn"><br>
  <div>
   
  </div>
</body>
</html>