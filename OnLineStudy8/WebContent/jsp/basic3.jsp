<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 외부 css 파일을 읽기  -->
<link rel="stylesheet" href="style.css">
</head>
<body>
  <%--
           HTML 5 => HTML 4 (<div>)
               시멘텍 태그 : 태그를 쉽게 찾을 수 있게 변경
       ====================================
              <header> 회사로고 , 검색창  
       ====================================
              <nav> 메뉴 제작 
       ====================================
                           |
         화면 출력  section        | 부가정보 (날씨, 인기검색어) aside
                           |
                           |
       ====================================
              개인 정보 방침 , 회사 정보  => footer
       ====================================
       
             템플릿을 다운 로드 (HTML4(div) ,HTML5(header,section,nav...)) 
       정리 : CSS
   --%>
  <header>
    
  </header><!-- <div class="header"> -->
  <nav id="topMenu">
    <ul>
      <li class="topMenuLi">
        <a class="menuLink" href="#">Home</a>
      </li>
      <li>|</li>
      <li class="topMenuLi">
        <a class="menuLink" href="#">레시피</a>
        <ul class="submenu">
          <li><a href="#" class="submenuLink">최신순</a></li>
          <li><a href="#" class="submenuLink">추천순</a></li>
        </ul>
      </li>
      <li>|</li>
      <li class="topMenuLi">
        <a class="menuLink" href="#">커뮤니티</a>
        <ul class="submenu">
          <li><a href="#" class="submenuLink">자유게시판</a></li>
          <li><a href="#" class="submenuLink">자료실</a></li>
          <li><a href="#" class="submenuLink">묻고 답하기</a></li>
        </ul>
      </li>
      <li>|<li>
      <li class="topMenuLi">
        <a class="menuLink" href="#">요리정보</a>
        <ul class="submenu">
          <li><a href="#" class="submenuLink">요리팁 & 노하우</a></li>
          <li><a href="#" class="submenuLink">재료</a></li>
          <li><a href="#" class="submenuLink">맛집찾기</a></li>
        </ul>
      </li>
    </ul>
  </nav>
  <%-- 화면 출력  --%>
  <section>
    <div class="main">
     <div class="content">
       <div class="gallery">
         <!-- 이미지 출력  -->
         <%
             // include는 파일이 없는 경우에 오류를 발생 
             pageContext.include("board/list.jsp");
         %>
       </div>
     </div>
    </div>
  </section>
</body>
</html>





