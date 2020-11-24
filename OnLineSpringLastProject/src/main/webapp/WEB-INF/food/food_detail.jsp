<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['선호도', '댓글'],
          ['좋아요',     <c:out value="${vo.good}"/>],
          ['괜찮다',      <c:out value="${vo.soso}"/>],
          ['별로',  <c:out value="${vo.bad}"/>]
        ]);

        var options = {
          title: '댓글 분석',
          is3D:true
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
</head>
<body>
<div class="latest-products">
      <div style="height: 130px"></div>
      <div class="container">
        <div class="row">
          <table class="table">
            <tr>
              <c:forTokens var="poster" items="${vo.poster }" delims="^">
               <td><img src="${poster }" width=230 height=200></td>
              </c:forTokens>
            </tr>
          </table>
        </div>
        <div style="height:20px"></div>
        <div class="row">
          <div class="col-md-8">
            <table class="table">
             <tr>
              <td>
               <h3>${vo.title }&nbsp;<span style="color:orange">${vo.score }</span></h3>
              </td>
             </tr>
            </table>
            <table class="table">
              <tr>
                <td width=20%>주소</td>
                <td width=80%>
                 ${vo.addr1 }<br>
                 <sub style="color:#999999">${vo.addr2 }</sub>
                </td>
              </tr>
              <tr>
                <td width=20%>전화번호</td>
                <td width=80%>${vo.tel }</td>
              </tr>
              <tr>
                <td width=20%>음식종류</td>
                <td width=80%>${vo.type }</td>
              </tr>
              <tr>
                <td width=20%>가격대</td>
                <td width=80%>${vo.price }</td>
              </tr>
              <c:if test="${vo.menu!='no' }">
	              <tr>
	                <td width=20%>메뉴</td>
	                <td width=80%>
	                  <c:forTokens var="s" items="${vo.menu }" delims="^">
	                   ${s }<br>
	                  </c:forTokens>
	                </td>
	              </tr>
              </c:if>
            </table>
            <table class="table">
             <tr>
               <td>
                 <div id="piechart" style="width: 500px; height: 250px;"></div>
               </td>
             </tr>
            </table>
          </div>
          <div class="col-md-4">
            <h3>관련 레시피 목록</h3>
            <table class="table">
              <c:forEach var="rvo" items="${list }">
                <tr>
                 <td>
                  <img src="${rvo.poster }" width=35 height=35 class="img-rounded">
                 </td>
                 <td style="font-size:8pt">${rvo.title }</td>
                </tr>
              </c:forEach>
            </table>
            <hr>
            <h3>주변 지도</h3>
            <table class="table">
              <tr>
               <td class="text-center">
                
               </td>
              </tr>
            </table>
            <hr>
            <h3>맛집 댓글평</h3>
            <table class="table">
              <tr>
               <td class="text-center">
                
               </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
 </div>
</body>
</html>