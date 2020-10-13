<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <div class="row">
      <a href="../movie/list.do" class="btn btn-sm btn-primary">영화목록</a>
      <a href="../movie/detail.do" class="btn btn-sm btn-success">영화상세보기</a>
      <a href="../reserve/movie.do" class="btn btn-sm btn-warning">예매영화목록</a>
      <a href="../reserve/theater.do" class="btn btn-sm btn-info">예매극장목록</a>
      <a href="../member/join.do" class="btn btn-sm btn-danger">회원가입</a>
      <a href="../member/login.do" class="btn btn-sm btn-active">로그인</a>
    </div>
    <div class="row">
      <jsp:include page="${main_jsp }"></jsp:include>
    </div>
  </div>
</body>
</html>