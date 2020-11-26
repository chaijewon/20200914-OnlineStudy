<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.recomm').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	});
	
	$('.recomm').click(function(){
		let no=$(this).attr("value");
		$.ajax({
			type:'POST',
			url:'../recommand/recomm_list.do',
			data:{"no":no},
			success:function(res)
			{
				$('#print').html(res);
			}
		});
	});
})
</script>
</head>
<body>
<div class="latest-products">
      <div style="height: 130px"></div>
        <div class="container">
         <div class="row">
           <div class="text-center">
             <span class="btn btn-lg btn-primary recomm" value="1">상황</span>
             <span class="btn btn-lg btn-success recomm" value="2">감성</span>
             <span class="btn btn-lg btn-info recomm" value="3">스타일</span>
             <span class="btn btn-lg btn-danger recomm" value="4">날씨/계절</span>
           </div>
         </div>
         <div style="height:10px"></div>
         <div class="row" id="print">
         
         </div>
        </div>
 </div>
</body>
</html>



