<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.recomm').click(function(){
		let fd=$(this).text();
		$.ajax({
			type:'post',
			url:'../recommand/find.do',
			data:{"fd":fd},
			success:function(result)
			{
				$('#print').html(result);
			}
		});
	})
});
</script>
</head>
<body>
<div class="latest-products">
      <div style="height: 130px"></div>
      <div class="container">
        <div class="row">
		    <c:forEach var="s" items="${ss }">
		      <span class="btn btn-xs btn-warning recomm">${s }</a></span>&nbsp;
		    </c:forEach>
		</div>
		<div style="height: 15px"></div>
		<div class="row" id="print">
		</div>
      </div>
</div>
    
</body>
</html>


