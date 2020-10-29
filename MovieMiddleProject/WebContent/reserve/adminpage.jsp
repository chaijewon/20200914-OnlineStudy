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
// $('input[type=checkbox]')
$(function(){
	$('#allBtn').click(function(){
		// 체크박스의 선택여부 확인 => radio
		let len=$('.cb:checked').length;
		if(len==0)
		{
		   alert("승인할 대상을 선택하세요!!");
		}
		else
		{
			$('#frm').submit();//submit효과 => form태그의 action에등록 파일로 데이터 전송
		}
	})
})
</script>
</head>
<body>
  <table class="table">
    <caption>예매목록</caption>
    <tr>
      <td>
        <input type="button" class="btn btn-sm btn-primary" id="allBtn"
          value="전체 승인"/>
      </td>
    </tr>
    <tr>
      <td>
        <form id="frm" action="../reserve/reserve_all_ok.do" method="post">
        <table class="table table-striped">
          <tr class="danger">
           <th class="text-center"></th>
           <th class="text-center">예매번호</th>
           <th class="text-center"></th>
           <th class="text-center">ID</th>
           <th class="text-center">영화명</th>
           <th class="text-center">극장명</th>
           <th class="text-center">예매일</th>
           <th class="text-center">인원</th>
           <th class="text-center">금액</th>
           <th class="text-center"></th>
          </tr>
          <c:forEach var="vo" items="${list }">
            <tr>
               <td class="text-center">
                 <c:if test="${vo.isreserve=='n' }">
                  <input type="checkbox" value="${vo.no }" class="cb" name=cb>
                 </c:if>
               </td>
               <td class="text-center">${vo.no }</td>
	           <td class="text-center">
	             <img src="${vo.mvo.poster }" width=30 height=30>
	           </td>
	           <td class="text-center">${vo.id }</td>
	           <td class="text-center">${vo.mvo.title }</td>
	           <td class="text-center">${vo.theater }</td>
	           <td class="text-center">${vo.time }</td>
	           <td class="text-center">${vo.inwon }</td>
	           <td class="text-center">${vo.price }</td>
	           <td class="text-center">
	             <c:if test="${vo.isreserve=='n' }">
	              <a href="../reserve/admin_ok.do?no=${vo.no }" class="btn btn-sm btn-primary">승인대기</a>
	             </c:if>
	             <c:if test="${vo.isreserve=='y' }">
	              <span class="btn btn-sm btn-danger">승인완료</span>
	             </c:if>
	           </td>
            </tr>
          </c:forEach>
        </table>
        </form>
      </td>
    </tr>
  </table>
</body>
</html>