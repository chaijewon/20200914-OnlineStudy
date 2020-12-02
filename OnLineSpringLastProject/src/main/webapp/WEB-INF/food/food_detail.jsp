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
     <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
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
      let u=0;
      $(function(){
    	  $('.up').click(function(){
    		 $('.updates').hide();
    		 let no=$(this).attr("value");
    		 if(u==0)
    		 {
    			 $('#u'+no).show();
    			 $(this).text("취소");
    			 u=1;
    		 }
    		 else
    		 {
    			 $('#u'+no).hide();
    			 $(this).text("수정");
    			 u=0;
    		 }
    	  });
      })
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
               <td><img src="${poster }" width=210 height=200></td>
              </c:forTokens>
            </tr>
          </table>
        </div>
        <div style="height:20px"></div>
        <div class="row">
          <div class="col-md-7">
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
            <hr>
            <table class="table">
              <tr>
               <td>
                 <c:forEach var="rvo" items="${rList }">
                   <table class="table table-striped">
                    <tr>
                     <td class="text-left">◑${rvo.name }(${rvo.dbday })</td>
                     <td class="text-right">
                      <c:if test="${sessionScope.id==rvo.id }">
                       <span value="${rvo.no }" class="btn btn-xs btn-success up">수정</span>
                       <a href="../food/reply_delete.do?no=${rvo.no }&cno=${vo.no}" class="btn btn-xs btn-info">삭제</a>
                      </c:if>
                     </td>
                    </tr>
                    <tr>
                      <td colspan="2">
                       <pre style="white-space: pre-wrap;border:none;background-color: white">${rvo.msg }</pre>
                      </td>
                    </tr>
                    <tr class="updates" id="u${rvo.no }" style="display:none">
		               <td colspan="2">
		                 <form method="post" action="../food/reply_update.do">
			                 <input type="hidden" name="cno" value="${vo.no }">
			                 <input type="hidden" name="no" value="${rvo.no }">
			                 <textarea rows="3" cols="60" name="msg" style="float: left">${rvo.msg }</textarea>
			                 <input type=submit value="댓글수정" class="btn btn-sm btn-primary"
			                  style="float: left;height: 73px">
		                  </form>
		               </td>
		              </tr>
                   </table>
                 </c:forEach>
               </td>
              </tr>
            </table>
            <table class="table">
              <tr>
               <td>
                 <form method="post" action="../food/reply_insert.do">
	                 <input type="hidden" name="cno" value="${vo.no }">
	                 <textarea rows="3" cols="63" name="msg" style="float: left"></textarea>
	                 <input type=submit value="댓글쓰기" class="btn btn-sm btn-primary"
	                  style="float: left;height: 73px">
                  </form>
               </td>
              </tr>
            </table>
          </div>
          <div class="col-md-5">
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
                <div id="map" style="width:100%;height:350px;"></div>
                <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b7e8bc1d2f7bde96cce0a16b1cec2ee0&libraries=services"></script>
                <script>
                var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        	    mapOption = {
        	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        	        level: 3 // 지도의 확대 레벨
        	    };  
        	
        	// 지도를 생성합니다    
        	var map = new kakao.maps.Map(mapContainer, mapOption); 
        	
        	// 주소-좌표 변환 객체를 생성합니다
        	var geocoder = new kakao.maps.services.Geocoder();
        	
        	// 주소로 좌표를 검색합니다
        	geocoder.addressSearch('${vo.addr1}', function(result, status) {
        	
        	    // 정상적으로 검색이 완료됐으면 
        	     if (status === kakao.maps.services.Status.OK) {
        	
        	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        	
        	        // 결과값으로 받은 위치를 마커로 표시합니다
        	        var marker = new kakao.maps.Marker({
        	            map: map,
        	            position: coords
        	        });
        	
        	        // 인포윈도우로 장소에 대한 설명을 표시합니다
        	        var infowindow = new kakao.maps.InfoWindow({
        	            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.title}</div>'
        	        });
        	        infowindow.open(map, marker);
        	
        	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        	        map.setCenter(coords);
        	    } 
        	});    
                </script>
               </td>
              </tr>
            </table>
            <hr>
            <h3>맛집 댓글평</h3>
            <table class="table">
              <tr>
               <td class="text-center">
                <img src="../naver${vo.no }.png" width=450 height=450>
               </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
      
 </div>
</body>
</html>