<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.movie').click(function(){
		let no=$(this).attr("data-value");
		//alert("no:"+no);
		let poster=$(this).attr("data-poster");
		let title=$(this).attr("data-title");
		$('#movie_poster').attr("src",poster);
		$('#movie_title').text(title);
		$.ajax({
			type:'post',
			url:'../reserve/theater.do',
			data:{"no":no},
			success:function(result)
			{
				$('#theater_info').html(result);
			}
		})
	});
});
</script>
</head>
<body>
   <table class="table striped">
     <c:forEach var="vo" items="${list }">
       <tr class="movie" data-value="${vo.no }"
           data-poster="${vo.poster }" data-title="${vo.title }">
         <td><img src="${vo.poster }" width=20 height=20></td>
         <td style="font-size:8pt">${vo.title }</td>
       </tr>
     </c:forEach>
   </table>
</body>
</html>