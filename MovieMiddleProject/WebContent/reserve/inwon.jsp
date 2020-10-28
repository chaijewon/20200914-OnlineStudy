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
	$('.inwon').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	})
	$('.inwon').click(function(){
		let inwon=$(this).text();
		let price=inwon*10000;
		$('#movie_inwon').text(inwon+"명");
		$('#movie_price').text(price+"원");
		$('#okbtn').show();
		$('#inwon').val(inwon);
		$('#price').val(price);
	})
})
</script>
</head>
<body>
  <table class="table">
    <tr>
      <td>
       성인:
       <c:forEach var="i" begin="1" end="10">
         <span class="btn btn-xs btn-info inwon">${i }</span>
       </c:forEach>
      </td>
    </tr>
  </table>
</body>
</html>



