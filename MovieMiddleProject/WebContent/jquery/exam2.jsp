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
	$('tr:eq(0)').css("background-color","#ccccff");
	$('td:nth-child(3n+3)').css("background-color","#ccffcc");
	/*
	     ================
	       1 |  2  |  3
	     ================
	      4  |  5  |  6
	     ================
	      7  |  8  |  9
	     ================
	    	 
	    	 3n+2  => n=0   ==> 2
                      n=1   ==> 5  
	*/
})
</script>
</head>
<body>
  <table border=1 bordercolor=black>
    <tr>
      <th>이름</th>
      <th>성별</th>
      <th>나이</th>
    </tr>
    <tr>
      <td>홍길동</td>
      <td>남자</td>
      <td>30</td>
    </tr>
    <tr>
      <td>심청이</td>
      <td>여자</td>
      <td>20</td>
    </tr>
    <tr>
      <td>박문수</td>
      <td>남자</td>
      <td>35</td>
    </tr>
  </table>
</body>
</html>