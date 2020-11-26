<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
         <div class="row">
		  <div class="col-md-7">
		    <h3 class="text-center">내용보기</h3>
		    <table class="table">
		      <tbody>
		      <tr>
		        <th class="text-center success" width=20% bgcolor="#CCCCFF">번호</th>
		        <td class="text-center" width=30%>${vo.no }</td>
		        <th class="text-center success" width=20% bgcolor="#CCCCFF">작성일</th>
		        <td class="text-center" width=30%>${vo.regdate }</td>
		      </tr>
		      <tr>
		        <th class="text-center success" width=20% bgcolor="#CCCCFF">이름</th>
		        <td class="text-center" width=30%>${vo.name }</td>
		        <th class="text-center success" width=20% bgcolor="#CCCCFF">조회수</th>
		        <td class="text-center" width=30%>${vo.hit }</td>
		      </tr>
		      <tr>
		        <th class="text-center success" width=20% bgcolor="#CCCCFF">제목</th>
		        <td colspan="3">${vo.subject }</td>
		      </tr>
		      <tr>
		        <td colspan="4" class="text-left" valign="top" height="200">
		         <pre style="white-space: pre-wrap;border: none;background-color: white">${vo.content}</pre>
		        </td>
		      </tr>
		      <tr>
		        <td colspan="4" class="text-right">
		         <a href="../board/update.do?no=${vo.no }" class="btn btn-xs btn-success">수정</a> 
		         <a href="../board/delete.do?no=${vo.no }" class="btn btn-xs btn-info">삭제</a> 
		         <a href="../board/list.do" class="btn btn-xs btn-warning">목록</a> 
		        </td>
		      </tr>
		      </tbody>
		    </table>
		  </div>
		  <div class="col-md-5">
		   <div id="a">
		     <img id="seoul_1" src="../map/1111.png">
		     <c:forEach var="i" begin="1" end="25">
		       <img id="gu${i }" src="../map/gu_${i }_off.png"
		         onmouseover="this.src='../map/gu_${i }_on.png'" onmouseout="this.src='../map/gu_${i }_off.png'">
		     </c:forEach>
		   </div>
		  </div>
		  </div>
		</div>
</div>
</body>
</html>