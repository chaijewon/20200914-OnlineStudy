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
	//$('.image').css("width","200px").css("height","250px");
	$('.image').hover(function(){
		$(this).css('opacity',0.3);
		$(this).css("cursor",'pointer');
	},function(){
		$(this).css('opacity',1.0);
		$(this).css("cursor",'none');// 원래상태 복귀
	})
	$('.image').css({"width":"200px","height":"250px"});
	$('.image').click(function(){
		let src=$(this).attr("src");
		//$('div').html('<img src='+src+' width=450 height=500>'); img
		$('div img').attr("src",src);
	})
})
</script>
</head>
<body>
  <img class="image" src="http://img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F75e6c79b957f6b4565c0b81c0f37e4d3d5c0b327">
  <img class="image" src="http://img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2Fcd5cff312e3ec6beb42b4767c2c89964dd4eca70">
  <img class="image" src="http://img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F13b5f2e03ddf023f05212176ac90db9337758ba8">
  <img class="image" src="http://img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2Fa48e2ed6706cd95758f721f6de791067c6d2c1e3">
  <img class="image" src="http://img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F3b3d8a8a743e8fe8d92fa772ccbef8b7d757eac9">
  <div>
    <img src="" width=450 height=500>
  </div>
</body>
</html>