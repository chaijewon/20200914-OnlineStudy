<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
  가상 Selector
  태그:가상 (예 a:hover,p:active)
 li:nth-child(1) (2) (3)... => 메뉴제작 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
/*
    원래상태 복귀
*/
a:link {
	color:darkgrey;
}
a:visited {
	color:green;
}
/*
     기억  (마우스)
*/
a:hover{
    color:orange;
}
/*
   마우스 클릭 
*/
p:active {
	color:red;
}
/*
     박스안에 마우스 클릭 => focus
*/
input:focus {
	background: blue;
}
/*
     table , dl , li => 순서를 지정해서 찾는 방법 
     nth-child(1~)
     
        메뉴 
*/
li:nth-child(1) {
  color:red;	
}
li:nth-child(2) {
  color:blue;	
}
li:nth-child(3) {
  color:green;	
}
/*
    데이터 수집 (Jsoup)
*/
tr:nth-child(1) {
   background-color: orange;	
}
tr:nth-child(2n) {
   background-color: RGB(255,255,200);	
}
</style>
</head>
<body>
  <!-- 사이트 이동 (링크 태그) -->
  <!-- 
     a : 인라인 속성 => 옆에 출력 
     
     div , ul , ol , h1~h6 => block 
     a input img  => inline
   -->
  <a href="http://daum.net" style="display: block;">다음</a>
  <%-- \n을 포함한다 (block) --%>
  <a href="http://naver.net" style="display: block">네이버</a>
  <p>클릭하세요</p>
  <input type=text size=15>
  <ul>
    <li>자바</li>
    <li>오라클</li>
    <li>스프링</li>
    <li>MyBatis</li>
    <li>자바스트립트</li>
    <li>Ajax</li>
    <li>React</li>
  </ul>
  <table border=1 bordercolor=black width=500>
    <tr>
      <th>이름</th>
      <th>국어</th>
      <th>영어</th>
      <th>수학</th>
    </tr>
    <tr>
      <td>홍길동</td>
      <td>89</td>
      <td>90</td>
      <td>78</td>
    </tr>
    <tr>
      <td>심청이</td>
      <td>89</td>
      <td>90</td>
      <td>78</td>
    </tr>
    <tr>
      <td>박문수</td>
      <td>89</td>
      <td>90</td>
      <td>78</td>
    </tr>
  </table>
</body>
</html>






