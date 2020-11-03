<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1 {
    margin: 0px auto;
    width:700px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
let u=0;
$(function(){
	$('.reply_reply').click(function(){
	  $('.rIn').hide();
	  $('.rUp').hide();
	  $('.reply_reply').text("댓글");
	  let no=$(this).attr('value');
	  if(i==0)
	  {
		    
			$('#rIn'+no).show();
			$(this).text("취소");
			i=1;
	  }
	  else
	  {
		    $('#rIn'+no).hide();
		    $(this).text("댓글");
			i=0;
	  }
		
	});
	
	$('.reply_update').click(function(){
		let no=$(this).attr("value");
		$('.rIn').hide();
		$('.rUp').hide();
		if(u==0)
		{
			$('#rUp'+no).show();
			u=1;
		}
		else
		{
			$('#rUp'+no).hide();
			u=0;
		}
	})
});
</script>
</head>
<body>
  <div class="row row1">
    <h3 class="text-center">상세보기</h3>
    <table class="table">
      <tr>
        <th width=20% class="text-center success">번호</th>
        <td width=30% class="text-center">${vo.no }</td>
        <th width=20% class="text-center success">작성일</th>
        <td width=40% class="text-center">
          <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
        </td>
      </tr>
      <tr>
        <th width=20% class="text-center success">이름</th>
        <td width=30% class="text-center">${vo.name }</td>
        <th width=20% class="text-center success">조회수</th>
        <td width=40% class="text-center">${vo.hit }</td>
      </tr>
      <tr>
        <th width=20% class="text-center success">제목</th>
        <td colspan="3" class="text-left">${vo.subject }</td>
      </tr>
      <tr>
        <td colspan="4" valign="top" height="200">${vo.content }</td>
      </tr>
      <tr>
        <td colspan="4" class="text-right">
          <a href="#" class="btn btn-xs btn-danger">수정</a>
          <a href="#" class="btn btn-xs btn-info">삭제</a>
          <a href="../board/list.do" class="btn btn-xs btn-success">목록</a>
        </td>
      </tr>
      <tr style="display:none">
        <td colspan="4" class="text-right">
          비밀번호:<input type=password id=pwd size=10 class="input-sm">
            <input type=button value="삭제" class="btn btn-sm btn-primary">
        </td>
      </tr>
      <tr style="display:none">
        <td colspan="4" class="text-right">
          <span id="print"></span>
        </td>
      </tr>
    </table>
  </div>
  <div class="row row1">
    <h3>댓글목록</h3>
    <hr>
    <c:forEach var="rvo" items="${rList }">
      <table class="table">
        <tr>
          <td class="text-left">
           <c:if test="${rvo.group_tab>0 }">
             <c:forEach var="i" begin="1" end="${rvo.group_tab }">
               &nbsp;&nbsp;&nbsp;&nbsp;
             </c:forEach>
             <img src="../board/re.gif">
           </c:if>
           <img src="../board/img.png">&nbsp;${rvo.name }(${rvo.dbday })
          </td>
          <td class="text-right">
            <c:if test="${sessionScope.id==rvo.id }">
             <span class="btn btn-xs btn-primary reply_update" value="${rvo.no }">수정</span>
             <a href="../board/reply_delete.do?no=${rvo.no }&bno=${vo.no}" class="btn btn-xs btn-success">삭제</a>
            </c:if>
             <span class="btn btn-xs btn-danger reply_reply" value="${rvo.no }">댓글</span>
          </td>
        </tr>
        <tr>
          <td class="text-left" colspan="2">
            <c:if test="${rvo.group_tab>0 }">
             <c:forEach var="i" begin="1" end="${rvo.group_tab }">
               &nbsp;&nbsp; &nbsp;&nbsp;
             </c:forEach>
           </c:if>
            <pre style="white-space: pre-wrap;background-color: white;border:none">${rvo.msg }</pre>
          </td>
        </tr>
       <tr class="rIn" id="rIn${rvo.no }" value="${rvo.no }" style="display:none">
       <td colspan="2">
        <form method=post action="../board/reply_reply_insert.do">
            <input type=hidden name="no" value="${rvo.no }">
            <input type=hidden name="bno" value="${vo.no }">
	        <textarea rows="3" cols="80" name="msg" style="float: left"></textarea>
	        <input type=submit value="댓글쓰기" style="height:70px;float: left"
	          class="btn btn-sm btn-primary"
	        >
        </form>
       </td>
      </tr>
      <tr class="rUp" id="rUp${rvo.no }" value="${rvo.no }" style="display:none">
       <td colspan="2">
        <form method=post action="../board/reply_update.do">
            <input type=hidden name="no" value="${rvo.no }">
            <input type=hidden name="bno" value="${vo.no }">
	        <textarea rows="3" cols="80" name="msg" style="float: left">${rvo.msg }</textarea>
	        <input type=submit value="댓글수정" style="height:70px;float: left"
	          class="btn btn-sm btn-primary"
	        >
        </form>
       </td>
      </tr>
      </table>
    </c:forEach>
    <hr>
    <table class="table">
      <tr>
       <td>
        <form method=post action="../board/reply_insert.do">
            <input type=hidden name="bno" value="${vo.no }">
	        <textarea rows="3" cols="80" name="msg" style="float: left"></textarea>
	        <input type=submit value="댓글쓰기" style="height:70px;float: left"
	          class="btn btn-sm btn-primary"
	        >
        </form>
       </td>
      </tr>
    </table>
  </div>
</body>
</html>




