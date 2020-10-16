<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        <li><a href="#">로그인</a></li><%-- 모달 --%>
        <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">회원관리
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="../member/join.do">회원가입</a></li>
	          <%--
	                              회원가입폼
	                                 아이디중복체크 (Ajax)
	                                 우편번호 검색
	           --%>
	          <li><a href="#">아이디찾기</a></li>
	          <li><a href="#">비밀번호찾기</a></li>
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
        <li><a href="../reserve/reserve.do">영화예매</a></li>
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
        <li><a href="#">마이페이지</a></li>
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
</div>
</body>
</html>