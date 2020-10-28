<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin:0px auto;
   width:350pt;
}
</style> -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.rdays_ok').hover(function(){
		$(this).css("cursor","pointer");
	},function(){
		$(this).css("cursor","");
	})
	$('#year').change(function(){
		let year=$(this).val();
		$.ajax({
			type:'post',
			url:'../reserve/date.do',
			data:{"year":year},
			success:function(result)
			{
				$('#date_info').html(result);
			}
		})
	})
	$('#month').change(function(){
		let month=$(this).val();
		$.ajax({
			type:'post',
			url:'../reserve/date.do',
			data:{"month":month},
			success:function(result)
			{
				$('#date_info').html(result);
			}
		})
	});
	
	// 예약일 클릭시 
	// <span data-year="2020"> => attr("data-year")
	// <span>28</span> => text()
	// <input type=text> <select> ==> val()
	$('.rdays_ok').click(function(){
		let year=$(this).attr("data-year");
		let month=$(this).attr("data-month");
		let day=$(this).text();
		let rday=year+"년도 "+month+"월 "+day+"일";
		$('#movie_reserve').text(rday);
	})
});
</script>
</head>
<body>
 
      <h3 class="text-center">${year }년도 ${month }월</h3>
      <table class="table">
        <tr>
          <td>
            <select name="year" id="year">
             <c:forEach var="i" begin="2020" end="2030">
               <option ${i==year?"selected":"" }>${i }</option>
             </c:forEach>
            </select>년도&nbsp;
            
            <select name="month" id="month">
             <c:forEach var="i" begin="1" end="12">
               <option ${i==month?"selected":"" }>${i }</option>
             </c:forEach>
            </select>월
          </td>
        </tr>
      </table>
      <table class="table table-striped">
        <tr class="danger" style="height:40px">
          <c:forEach var="str" items="${strWeek }" varStatus="s">
            <c:choose>
              <c:when test="${s.index==0 }">
                <c:set var="color" value="red"/>
              </c:when>
              <c:when test="${s.index==6 }">
                <c:set var="color" value="blue"/>
              </c:when>
              <c:otherwise>
                <c:set var="color" value="black"/>
              </c:otherwise>
            </c:choose>
            <th class="text-center"><font color="${color }">${str }</font></th>
          </c:forEach>
        </tr>
        <c:set var="week" value="${week }"/>
        <c:forEach var="i" begin="1" end="${lastday }">
           <c:choose>
              <c:when test="${week==0 }">
                <c:set var="color" value="red"/>
              </c:when>
              <c:when test="${week==6 }">
                <c:set var="color" value="blue"/>
              </c:when>
              <c:otherwise>
                <c:set var="color" value="black"/>
              </c:otherwise>
            </c:choose>
           <c:if test="${i==1 }">
             <tr style="height:40px">
             <c:forEach var="j" begin="1" end="${week }">
               <td>&nbsp;</td>
             </c:forEach>
           </c:if>
           
           <c:if test="${i==rdays[i] }">
             <c:set var="bg" value="text-center danger"/>
           </c:if>
           <c:if test="${i!=rdays[i]  }">
             <c:set var="bg" value="text-center"/>
           </c:if>
           
           <td class="${bg }"><font color="${color }">
            <c:if test="${i==rdays[i] }">
             <span class="rdays_ok" data-year=${year } data-month=${month }>${i }</span>
            </c:if>
            <c:if test="${i!=rdays[i]  }">
             ${i }
            </c:if>
           </font></td>
           <c:set var="week" value="${week+1 }"/>
           <c:if test="${week>6 }">
             <c:set var="week" value="0"/>
             </tr>
             <tr style="height:40px">
           </c:if>
        </c:forEach>
        </tr>
      </table>
  
</body>
</html>
















