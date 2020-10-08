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
<%
   // 메뉴 조절 
   // 회원 , 마이페이지 
   // 로그인 => 회원 => 회원수정 회원탈퇴
   String id=(String)session.getAttribute("id");
   // id=null => 로그인 (X)
   String admin=(String)session.getAttribute("admin");// y/n
%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../main/main.jsp">SIST Movie</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../main/main.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">회원<span class="caret"></span></a>
        <ul class="dropdown-menu">
         <%
            if(id==null) // 로그인이 안된 상태
            {
         %>
		          <li><a href="#">회원가입</a></li>
		          <li><a href="#">아이디찾기</a></li>
		          <li><a href="#">비밀번호찾기</a></li>
          <%
            }
            else   // 로그인이 된 상태
            {
          %>
                  <li><a href="#">회원수정</a></li>
		          <li><a href="#">회원탈퇴</a></li>
          <%
            }
          %>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">커뮤니티<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../main/main.jsp?mode=9">자유게시판</a></li>
          <li><a href="../main/main.jsp?mode=1">자료실</a></li>
        </ul>
      </li>
      <%
       if(id!=null) // ${id!=null and admin=='n'}
        {
      %>
         <li><a href="#">영화예매</a></li>
         <li><a href="#">영화추천</a></li>
         <%
           if(admin.equals("n"))
           {
         %>
              <li><a href="#">마이페이지</a></li>
          <%
           }
           else
           {
          %>
               <li><a href="#">예매 현황</a></li>
          <%
           }
          %>
      <%
        }
      %>
    </ul>
  </div>
</nav>
</body>
</html>