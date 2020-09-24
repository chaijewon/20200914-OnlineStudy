<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
     템플릿 : 메뉴..footer..
 --%>
<%-- 화면 변경 
     1. 사용자가 화면 변경 요청 (숫자)
     
--%>
<%
     request.setCharacterEncoding("UTF-8");
     String mode=request.getParameter("mode"); // mode => 화면 변경 => 번호 보내준다 
     if(mode==null)
    	 mode="1";
     int index=Integer.parseInt(mode);
     String jsp=""; // 1=>a.jsp , 2.b.jsp...
    /*
          main  ===> board에 접근  ../board/jsp파일명
            main.jsp
            login.jsp  
          board
            list.jsp
            
            
          ==> 경로 (폴더가 다르다) 
              .. 상위 디렉토리 
    */
     switch(index)
     {
     // 화면에 출력하는 JSP만 설정 
     // insert_ok.jsp,download.jsp => 화면 출력하는 JSP아니라  처리만 담당 
     /*
          JSP 
           => 데이터 읽어와서 화면 출력 
           => 데이터 읽어와서 처리 담당 
              ==================    _ok.jsp => 다른 화면으로 이동 
     */
     case 1:
    	 jsp="../board/list.jsp"; // list.jsp => main
    	 break;
     case 2:
    	 jsp="../board/insert.jsp";
    	 break;
     case 3:
    	 jsp="../board/detail.jsp";
    	 break;
     case 4:
    	 jsp="../board/find.jsp";
    	 break;
     case 5:
    	 jsp="../board/delete.jsp";
    	 break;
     }
%>
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
<div class="container-fluid"><!-- full 화면 -->
  <div class="row">
    <div class="col-sm-3">
      <!-- 로그인 -->
      <jsp:include page="login.jsp"></jsp:include>
    </div>
    <div class="col-sm-9">
      <!-- 레시피 : 메뉴를 클릭시마다 변경 : 변수를 잡아서 => jsp파일명을 변경 -->
      <jsp:include page="<%=jsp %>"></jsp:include>
    </div>
  </div>
</div>

</body>
</html>