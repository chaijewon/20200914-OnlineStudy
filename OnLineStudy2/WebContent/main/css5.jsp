<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.sist.dao.*"%>
<%
   // 데이터 읽기
   EmpDAO dao=new EmpDAO();
   ArrayList<MovieVO> list=dao.movieListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#list-table{
  border: 1px solid black;
  border-collapse: collapse;
}
#list-table tr:nth-child(1) {
	background-color: #999;
	font-family: 맑은 고딕
}
h1 {
     text-shadow: 5px 5px 3px #0f0;
}
.container{
  width:1300px;
  border:1px solid red;
}
.row {
   width:1200px;
   margin: 0px auto;
}
h1 {
   text-align:center;
}
img {
  width:30px;
  height:30px;
  border-radius: 30px;
}
#list-table td{
  border-bottom-width: 1px;
  border-bottom-style: dotted;
  border-bottom-color: black;
  font-family: 맑은 고딕;
  font-size: 9pt;
}
#list-table .dataTr:hover{
   /*background-color: FC6;*/
   cursor: pointer;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
// Jquery => JavaScript 라이브러리
/*
 *  $(function(){  ==> jquery main ==> window.onload
	 
     )}
 */
$(function(){
	// 자바스크립트 => 모든 태그를 클릭해서 처리가 가능 
	// $(selector) => tag명 , id명 , class명
	// $('h1') ==> $('#data') ==> $('div .dataTr')
	$('.dataTr').click(function(){
		// 클릭시마다 영화번호를 가지고 온다 
		var no=$(this).attr("value");
		//alert(no);
		/*
			$.ajax({
				type:'post', = get/post
				url:'detail.jsp', = 전송받을 주소
				data:{"no":no}, = 보내주는 값
				success:function(result) // 정상 수행시에 처리
				{
					$('#detail').html(result);
				}
			})
		*/
		$.ajax({
			type:'post',
			url:'detail.jsp',
			data:{"no":no},
			success:function(result)
			{
				$('#detail').html(result);
			}
		})
	});
});
</script>
</head>
<body>
  <%--
       id , class => 앞에 숫자를 사용할 수 없다
       
       JSP => 서버를 통해서 변경된 HTML을 출력 => AJAX , Modal창
   --%>
  <div class="container">
    <div class="row">
     <h1>영화목록</h1>
     <table width=1200>
       <tr>
        <td><%--목록 출력 --%>
          <table id="list-table" width=60%>
            <tr>
             <th>번호</th>
             <th></th>
             <th>제목</th>
             <th>감독</th>
             <th>장르</th>
            </tr>
            <%
               for(MovieVO vo:list)
               {
            %>
                  <tr class="dataTr" value="<%=vo.getMno()%>">
                    <td><%=vo.getMno() %></td>
                    <td>
                      <img src="<%=vo.getPoster()%>">
                    </td>
                    <td><%=vo.getTitle() %></td>
                    <td><%=vo.getDirector() %></td>
                    <td><%=vo.getGenre() %></td>
                  </tr>
            <%
               }
            %>
          </table>
        </td>
        <td id="detail" valign="top"><%--상세 보기 --%>
          
        </td>
       </tr>
     </table>
    </div>
  </div>
</body>
</html>