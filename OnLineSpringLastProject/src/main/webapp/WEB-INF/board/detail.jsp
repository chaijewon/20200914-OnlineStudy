<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="latest-products">
      <div style="height: 130px"></div>
        <div class="container">
		  <div class="col-md-8">
		    <h3 class="text-center">내용보기</h3>
		    <table class="table">
		      <tr>
		        <th class="text-center success" width=20%>번호</th>
		        <td class="text-center" width=30%>${vo.no }</td>
		        <th class="text-center success" width=20%>작성일</th>
		        <td class="text-center" width=30%>${vo.regdate }</td>
		      </tr>
		      <tr>
		        <th class="text-center success" width=20%>이름</th>
		        <td class="text-center" width=30%>${vo.name }</td>
		        <th class="text-center success" width=20%>조회수</th>
		        <td class="text-center" width=30%>${vo.hit }</td>
		      </tr>
		      <tr>
		        <th class="text-center success" width=20%>제목</th>
		        <td colspan="3">${vo.subject }</td>
		      </tr>
		      <tr>
		        <td colspan="4" class="text-left" valign="top" height="200">
		         <pre style="white-space: pre-wrap;border: none;background-color: white">${vo.content}</pre>
		        </td>
		      </tr>
		      <tr>
		        <td colspan="4" class="text-right">
		         <a href="#" class="btn btn-xs btn-success">수정</a> 
		         <a href="#" class="btn btn-xs btn-info">삭제</a> 
		         <a href="../board/list.do" class="btn btn-xs btn-warning">목록</a> 
		        </td>
		      </tr>
		    </table>
		  </div>
		  <div class="col-md-4">
		  </div>
		</div>
</div>
</body>
</html>