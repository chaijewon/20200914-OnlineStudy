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
/*
 *   $(document).ready(function(){
	   =============== 생략
	 
     })
     
     $(function(){
	
     });
     window.onload=function()
     {
    	 
     }
 */
$(function(){
	// 태그에 대한 이벤트 (클릭..마우스 오버 ...)
	// onClick="send()"  function send(){}
	$('#logBtn').click(function(){
		// selector => css
		let id=$('#log_id').val();// getter  , $('#log_id').val("admin") setter
		//$('#log_id').val("hong");
		if(id.trim()=="")
		{
			$('#log_id').focus();
			return;
			// <input type="text" class="input-sm" name=id size="15" id="log_id" placeholder="아이디입력"  style="color:black">
		}
		
		let pwd=$('#log_pwd').val();// getter  , $('#log_id').val("admin") setter
		//$('#log_id').val("hong");
		if(pwd.trim()=="")
		{
			$('#log_pwd').focus();
			return;
			// <input type="text" class="input-sm" name=id size="15" id="log_id" placeholder="아이디입력"  style="color:black">
		}
		// id입력
		// pwd입력 ===> login_ok.do ==> 데이터 전송 
		$('#logFrm').submit(); //<form => action="파일명">
		// <input type=submit> ==> 'null'
	});
});
</script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="../main/main.do">SIST Movie</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="../main/main.do">Home</a></li>
        <!-- <li><a href="#" id="login">로그인</a></li> --><%-- 모달 --%>
        <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">회원관리
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <c:if test="${sessionScope.id!=null }">
	           <li><a href="../member/join.do">회원수정</a></li>
	          </c:if>
	          <c:if test="${sessionScope.id==null }">
		           <li><a href="../member/join.do">회원가입</a></li>
		          
		          <%--
		                              회원가입폼
		                                 아이디중복체크 (Ajax)
		                                 우편번호 검색
		           --%>
		          <li><a href="#">아이디찾기</a></li>
		          <li><a href="#">비밀번호찾기</a></li>
	          </c:if>
	        </ul>
        </li>
        <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">영화
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="../movie/total.do">전체영화</a></li>
	          <li><a href="../movie/real.do?cateno=1">현재상영영화</a></li>
	          <%-- 상세보기  : 찜하기 , Cookie , 댓글 --%>
	          <li><a href="../movie/sch.do?cateno=2">개봉예정영화</a></li>
	          <li><a href="../movie/box.do?cateno=3">박스오피스</a></li>
	        </ul>
	      </li>
	    <c:if test="${sessionScope.id!=null }">
         <li><a href="../reserve/reserve.do">영화예매</a></li>
        </c:if>
            <%-- Ajax 
                               달력
            --%> 
        <li><a href="../movie/news.do">영화뉴스</a></li>
        <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">커뮤니티
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <%-- 블록별 처리 --%>
	          <li><a href="#">공지사항</a></li>
	          <li><a href="#">자유게시판</a></li>
	          <li><a href="#">묻고답하기</a></li>
	        </ul>
	      </li>
	    <c:if test="${ sessionScope.id!=null}">
	      <c:if test="${ sessionScope.admin=='n'}">
            <li><a href="#">마이페이지</a></li>
          </c:if>
          <c:if test="${ sessionScope.admin=='y'}">
            <li><a href="#">예매현황</a></li>
          </c:if>
        </c:if>
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron text-center">
  <h1>영화 예매 사이트</h1> 
  <p>영화예매를 위한 MVC사이트입니다 </p> 
  <form>
    <div class="input-group">
      <input type="text" class="form-control" size="50" placeholder="영화명 입력" required>
      <div class="input-group-btn">
        <button type="button" class="btn btn-danger">검색</button>
      </div>
    </div>
  </form>
  <div style="height:30px"></div>
  <c:if test="${sessionScope.id==null }">
	  <form method="post" action="../member/login.do" id="logFrm">
	    <div class="text-right">
	      <input type="text" class="input-sm" name=id size="15" id="log_id" placeholder="아이디입력"  style="color:black">
	      <input type="password" class="input-sm" name=pwd size="15" id="log_pwd" placeholder="비밀번호입력"  style="color:black">
	      <input type="button" class="btn btn-danger btn-sm" id="logBtn" value="로그인">
	      <%--
	            <input type=submit>
	            <button>
	            <input type=image>   ==> submit
	       --%>
	    </div>
	  </form>
  </c:if>
  <%--
       HTML(JSP)=> 처리 요청   ==> .do ==> Model <==> DAO
                               JSP <=== 결과값 전송 
   --%>
  <c:if test="${sessionScope.id!=null }">
	  <form action="../member/logout.do"><%-- get(생략이 가능) --%>
	    <div class="text-right">
	      ${sessionScope.name }(${sessionScope.admin=='y'?'관리자':'일반유저' })님 로그인중입니다...
	      <button class="btn btn-danger btn-sm">로그아웃</button>
	    </div>
	  </form>
  </c:if>
</div>
<div id="dialog" style="display:none">
  <jsp:include page="../member/login.jsp"></jsp:include> 
</div>
</body>
</html>