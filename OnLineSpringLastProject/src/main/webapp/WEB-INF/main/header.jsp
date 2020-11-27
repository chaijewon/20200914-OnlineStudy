<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('div#chat').toggleClass('active');
    var $win = $(window);
    var top = $(window).scrollTop(); // 현재 스크롤바의위치값을 반환합니다.

    /*사용자 설정 값 시작*/
    var speed          = 1000;     // 따라다닐 속도 : "slow", "normal", or "fast" or numeric(단위:msec)
    var easing         = 'linear'; // 따라다니는 방법 기본 두가지 linear, swing
    var $layer         = $('div#chat_container'); // 레이어셀렉팅
    var layerTopOffset = 0;   // 레이어 높이 상한선, 단위:px
    $layer.css('position', 'absolute');
    /*사용자 설정 값 끝*/

    // 스크롤 바를 내린 상태에서 리프레시 했을 경우를 위해
    if (top > 0 )
      $win.scrollTop(layerTopOffset+top);
    else
      $win.scrollTop(0);

    //스크롤이벤트가 발생하면
    $(window).scroll(function(){

      var yPosition = $win.scrollTop()+300;
      if (yPosition< 0)
      {
        yPosition = $win.scrollTop()+300;
      }
      $layer.animate({"top":yPosition }, {duration:speed, easing:easing, queue:false});
    });

});
</script>
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
                <a class="nav-link" href="../news/list.do">챗봇</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
    
</body>
</html>