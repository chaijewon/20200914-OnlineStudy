<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 메뉴가 올라가는 자리 --%>
<%--
     링크 : 이동 (메뉴클릭,버튼 클릭) = 페이지 흐름 => 사이트 주소를 주는 방법 
     한글 변환 => 반드시 링크가 걸린 jsp에서 한글 변환  
   1. 자바 코딩 
      <%
                 일반 자바 코딩
      %>
      <%= 화면 출력 부분 %> => out.println()
   2. page 지시자 : contentType="실행할때 어떤 코드를 만들것인지 확인"
                  text/html , text/xml  ==> 브라우저가 메모리에 데이터 읽을 경우에 html,xml
                  import ==> 라이브러리 읽기 
   3. 내장 객체 (기본 객체)
        request , response , out , application , pageContext 
        config, page, exception , session 
        
        request : 사용자 보내준 데이터를 받는 경우 
        response : 서버에서 화면 이동 
        application : getRealPath()
        pageContext : include(),forward()
                      <jsp:include> , <jsp:forward>
        ===========================================
        *** session vs cookie  : 로그인 , 장바구니 , 예매하기 
        ===========================================
   4. include => JSP안에 특정부분에 다른 JSP를 첨부 (붙여쓰기)
      ========
            전송은 전체를 가지고 있는 JSP(main.jsp)로 전송=>include된 파일(jsp) 데이터를 받아 볼 수 있다 
   =============================================================================
      항상 (오라클을 연결해서 데이터를 읽어 온다) : 외부에서 가지고 올 수 있다(JSoup,XML)
                                     ==============================
   1. JDBC , DBCP , ORM(MyBatis)
                    ============
                    1. Connection  ===> Config.xml
                                        getConnection(),disConnection()
                    2. PreparedStatement,ResultSet ==> table명-mapper.xml  
                                        PreparedStatement,ResultSet => SQL
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../main/main.jsp">SIST Recipe</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../main/main.jsp">Home</a></li>
      <li><a href="#">예매하기</a></li>
      <li><a href="../main/main.jsp?mode=9">게시판</a></li>
      <li><a href="../main/main.jsp?mode=1">자료실</a></li>
      <li><a href="#">마이페이지</a></li>
    </ul>
  </div>
</nav>
</body>
</html>