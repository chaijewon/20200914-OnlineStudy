<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
     실행 순서 
     => 자바 실행 => html을 실행
        =======
        사용자가 보낸 데이터를 받거나
        데이터베이스에서 데이터를 읽어 온다 
        
        7장 => 제어 흐름 
             ========
                   화면 이동 , 화면 조립 
          ================= pageContext
              = include()
              = forward()
           =============== 많이 사용(태그로 변경)
              = <jsp:include> : jsp파일을 여러개 묶어서 한 화면으로 만들어 준다 
                ============== 여러개의 jsp가 모여서 만들어진다 (어떤 JSP든 상관없이 request를 공유할 수 있다)
              = <jsp:forward> : 화면은 이동 => request를 사용이 가능 (일반 JSP(Model1)) forward사용하지 않고 
                                           mvc구조에 주로 사용 
                sendRedirect() : 화면 이동 => request가 초기화
           ================================
           
           
           main.jsp  =>  main.jsp?no=10 => request가 항상 공유
           =============================
           
                                              메뉴 (nav.jsp) ==> no=10 ===> 고정
           =============================
                     로그인          |  화면 (사용자가 보는 화면)
           (login.jsp|   content.jsp  no=10
                     |
                     |
                     |
           =============================
                                         회사정보  footer.jsp no=10   ===> 고정 
           
           =============================
           
           ========> main.jsp를 불러서 사용 (템플릿)
               include가 되면 항상 데이터를 전송시에 main.jsp로 전송하고 
                            필요한 jsp가 받아서 처리
                            
                            
           include : JSP안에 다른 JSP를 원하는 위치에 출력 
           <jsp:include>
             : jsp마다 따로 실행후에 => HTML만 묶어준다 
           <%@include%>
             : jsp를 미리묶어서 합쳐진 JSP를 컴파일
             : 변수가 동일하면 오류(에러 발생) => static
          =============== Spring에서 사용
 --%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container">
  <div class="row">
    <div class="col-sm-3">
      <!-- 로그인 -->
      <jsp:include page="login.jsp"></jsp:include>
    </div>
    <div class="col-sm-9">
      <!-- 레시피 : 메뉴를 클릭시마다 변경 -->
    </div>
  </div>
</div>

</body>
</html>









