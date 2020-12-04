<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
   <header class="">
      <nav class="navbar navbar-expand-lg navbar-fixed-top">
        <div class="container">
          <a class="navbar-brand" href="../main/main.do"><h2>SIST <em>Recipe&Food</em></h2></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item active">
                <a class="nav-link" href="../main/main.do">Home
                  <span class="sr-only">(current)</span>
                </a>
              </li> 
              <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#myModal">로그인</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="../recipe/list.do">레시피</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="../recipe/chef_list.do">쉐프</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="../food/list.do">맛집</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="../board/list.do">커뮤니티</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="../recommand/list.do">추천</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="../news/list.do">뉴스</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="../chat/chat.do">챗봇</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
    
</body>
</html>