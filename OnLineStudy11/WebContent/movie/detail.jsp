<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    // 사용자 요청한 영화번호 받는다 
    String no=request.getParameter("no");
    // 영화번호(no)에 해당되는 영화정보 가지고 와서 출력
    // DAO를 이용해서 처리 
    MovieVO vo=MovieDAO.movieDetailData(Integer.parseInt(no));
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
          <iframe src="http://youtube.com/embed/<%=vo.getKey()%>" width=750 height=450></iframe>
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