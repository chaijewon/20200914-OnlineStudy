<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 라이브러리 로드 : 원격,내부 -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
// JavaScript => 태그를 추가, 데이터 변경 , 화면 이동 => 이벤트 (프로그래머마다 처리 기능이 틀리다,통일화)
/*
 *   JQuery (DOM프로그램 : 트리형태) : JavaScript의 라이브러리 
     ==========================
    	 1. CSS변경 , 2. 데이터 변경
    	    ML => 데이터 저장 공간 
    	          <input type=text id="name" value="저장 위치"> => val()
    	          <td value="저장위치">저장위치=> text()</td>
    	          ================== ======
    	        	  속성값 : attr("속성명")
    	          <img src=""/>
    	          ==> getter
    	              val(),text(),attr("src")
    	              <div id="aaa">
    	                <span>Test</span>
    	              </div>
    	              
    	              div.text() => 태그는 제외 ==> Test
    	              div.html() => <span>Test</span>
    	          ==> setter
    	              val("aaa"),text("aaa"),attr("scr","a.jpg")
    	              html(),append() => 추가,remove()
    	              
    	                  태그를 가지고 오는 방법(Selector) 
    	              = id
    	                <input type=text id="id"> => $('#id').val("")
    	              = class
    	                <input type=text class="id"> => $('.id').val("")
    	              = tag명
    	                <td></td> => $('td')
    	              = 소속관계
    	                <div id="aaa">
    	                  <input type=text >
    	                </div>
    	                <div id="bbb">
		  	                  <input type=text >
		  	              </div>
		  	              $('input').val("admin");
		  	              $('#aaa input')
    	              = 가상
    	                $('td:eq(1)')  td:odd td:even
		  	              <tr>
		  	                <td></td>
		  	                <td></td>
		  	                <td></td>
		  	              </tr>
		  	              
		  	   ====== Jquery,Ajax ==> 브라우저에 화면이 출력된 다음에 수행
		  	     => javascript : window.onload => main
		  	        jquery : $(function(){})   => main
		  	        react : componentWillMount()
    	              
 */
 /* function a(){document.write("a")}
function b(){document.write("b")}
function c(){document.write("c")}
function d(){document.write("d")}
function e(){document.write("e")}
window.onload=function(){
	a();
} */
// $(document).ready(function(){}) => window.onload
$(function(){
	// 태그를 읽어서 제어
	//$('h1').css("color","red");
	//$('#a').css("color","green");
	//$('div .b').css("color","blue");
	/* $('h1:eq(0)').css("color","red");
	$('h1:eq(1)').css("color","green");
	$('h1:eq(2)').css("color","blue");
	$('h1:eq(3)').css("color","orange");
	$('h1:eq(4)').css("color","pink"); */
	/*
	    td , tr , li , option...
	*/
	$('.b:eq(0)').css("color","red");
	$('.b:eq(1)').css("color","green");
	$('.b:eq(2)').css("color","blue");
	$('.b:eq(3)').css("color","orange");
	$('.b:eq(4)').css("color","pink");
	
})
</script>
</head>
<body>
  <h1 class="b">Java</h1>
  <h1 class="b">Oracle</h1>
  <h1 class="b">JSP</h1>
  <h1 class="b">Spring</h1>
  <div>
    <h1 class="b">JavaScript</h1>
  </div>
</body>
</html>





