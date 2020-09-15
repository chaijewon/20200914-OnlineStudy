<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
     1) CSS 작업 
              1.외부 CSS,2.내부 CSS,3.인라인 CSS
              => BootStrap (twitter) = 반응형 (CSS 라이브러리)
     2) JavaScript 
              1. 라이브러리 (Jquery)
     3) JSP => MVC
              1. 라이브러리 (Spring)
              
     4) JDBC => 오라클 연결 
              1. MyBatis
              
     ==> Spring 기반(MVC) => Jquery => Mybatis (XML)
     
     CSS
     ====
       1) 선택자 => bootstrap (class)
          id
          <a href="#" id="aaa"> : id는 태그당 한개만 지정
          class
          <a href="" class="aaa bbb ccc">
                   태그명  
       2) 가상
                   태그명:선택자 (a:hover)
          id명:선택자 (#aaa:hover)
          class:선택자 (.data:hover)
          
          ==> Jquery (태그를 제어하는 프로그램) => DOM(Document Object Model)
          ==> Jsoup (태그 => 선택자) , reactjs,vuejs
      ====================    
      3) MVC(JSP) 기반  
         MyBatis 
         Ajax 
         reactjs 
      ==================== 
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.news{
  background-color:#0094ff;
  background-clip: padding-box;/*배경 적용범위  : border-box , content-box padding-box*/
  width:80%;
  padding: 15px;
  border: 1px solid black;
  color:white;
}
</style>
</head>
<body>
    <div class="news">
        이날 MLB닷컴에 따르면 김광현은 내셔널리그 사상 처음으로 4경기 연속 5이닝 3피안타 이하, 
        비자책을 기록한 선수가 됐다.
        개막전을 마무리 투수로 시작한 김광현은 팀 내 신종 코로나바이러스 감염증(코로나19) 
        확진자가 나오면서 선발로 보직이 바뀌었다.
        그는 빅리그 선발 데뷔전이었던 8월 17일 시카고 컵스전에서 3⅔이닝 2피안타(1피홈런) 1실점으로 호투했고, 
        이후 무서운 기세를 보이고 있다.
    8월 23일 신시내티 레즈전에서 6이닝 3피안타 3탈삼진 무실점 완벽투로 데뷔 첫 승을 수확했고, 
    8월 28일 피츠버그 파이어리츠전에서 6이닝 3피안타 1볼넷 3탈삼진 1실점(비자책점)으로 잘 던졌다.
    </div>
</body>
</html>