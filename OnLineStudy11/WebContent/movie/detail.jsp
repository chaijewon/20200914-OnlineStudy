<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    // 사용자 요청한 영화번호 받는다 
    String no=request.getParameter("no");
    // 영화번호(no)에 해당되는 영화정보 가지고 와서 출력
    // DAO를 이용해서 처리 
    MovieVO vo=MovieDAO.movieDetailData(Integer.parseInt(no));
    System.out.println(no+":"+vo.getPoster());
    // Cookie => 키(중복없다,문자시작),값(문자열만 저장이 가능)
    Cookie cookie=new Cookie("m"+no,no);
    cookie.setPath("/");
    // 저장 
    // 기간 
    cookie.setMaxAge(60*60); // 하루 저장  (초단위)
    // 클라이언트 컴퓨터로 전송 
    // http://211.238.142.181
    response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
    <h1 class="text-center">&lt;<%=vo.getTitle() %>&gt;상세보기</h1>
    <%-- 영화 상세보기 출력 --%>
    <table class="table">
      <tr>
        <td>
          <%-- <embed> <iframe> : youtube보안 --%>
          <iframe src="http://youtube.com/embed/<%=vo.getKey()%>" width=850 height=450></iframe>
        </td>
      </tr>
    </table>
    <table class="table">
      <tr>
        <td width=30% class="text-center" rowspan="7">
          <img src="<%=vo.getPoster() %>" width=100%>
        </td>
        <td colspan="2"><font color=orange><%=vo.getTitle() %></font></td>
      </tr>
      <tr>
        <td width=10%>감독</td>
        <td width=60%><%=vo.getDirector() %></td>
      </tr>
      <tr>
        <td width=10%>출연</td>
        <td width=60%><%=vo.getActor() %></td>
      </tr>
      <tr>
        <td width=10%>장르</td>
        <td width=60%><%=vo.getGenre() %></td>
      </tr>
      <tr>
        <td width=10%>등급</td>
        <td width=60%><%=vo.getGrade() %></td>
      </tr>
      <tr>
        <td width=10%>개봉일</td>
        <td width=60%><%=vo.getRegdate() %></td>
      </tr>
      <tr>
        <td width=10%>평점</td>
        <td width=60%><%=vo.getScore() %></td>
      </tr>
      <tr>
        <td colspan="3">
          <pre style="white-space: pre-wrap;background-color:white;border:none"><%=vo.getStory() %></pre>
        </td>
      </tr>
    </table>
  </div>
  <div class="row">
    <div class="text-right">
      <a href="#" class="btn btn-lg btn-primary">예매하기</a>
      <a href="#" class="btn btn-lg btn-danger">찜하기</a>
      <a href="../main/main.jsp" class="btn btn-lg btn-warning">목록</a>
    </div>
  </div>
</body>
</html>