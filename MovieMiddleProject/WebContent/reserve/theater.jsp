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
	$('.theater').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	});
	$('.theater').click(function(){
	   let no=$(this).attr("data-tno");
	   let tname=$(this).attr("data-name");
	   $('#movie_theater').text(tname);
	   $.ajax({
		   type:'post',
		   url:'../reserve/date.do',
		   success:function(result){
			   $('#date_info').html(result);
		   }
	   })
	})
});
</script>
</head>
<body>
  <table class="table table-striped">
    <c:forEach var="vo" items="${list }">
      <tr class="theater" data-tno="${vo.tno }" data-name="${vo.tname }(${vo.tloc })">
       <td style="font-size:8pt">${vo.tname }(${vo.tloc })</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>