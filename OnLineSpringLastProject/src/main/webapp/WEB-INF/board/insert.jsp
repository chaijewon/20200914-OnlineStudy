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
		    <h3 class="text-center">글쓰기</h3>
		    <form method="post" action="../board/insert_ok.do">
		   <table class="table table-hover">
		     <tr>
		       <th class="danger text-right" width=15%>이름</th>
		       <td width=85%>
		         <input type=text name=name size=15 class="input-sm">
		       </td>
		     </tr>
		     <tr>
		       <th class="danger text-right" width=15%>제목</th>
		       <td width=85%>
		         <input type=text name=subject size=45 class="input-sm">
		       </td>
		     </tr>
		     <tr>
		       <th class="danger text-right" width=15%>내용</th>
		       <td width=85%>
		         <textarea rows="10" cols="50" name=content></textarea>
		       </td>
		     </tr>
		     <tr>
		       <th class="danger text-right" width=15%>비밀번호</th>
		       <td width=85%>
		         <input type=password name=pwd size=10 class="input-sm">
		       </td>
		     </tr>
		     <tr>
		       <td colspan="2" class="text-center">
		         <input type=submit value=글쓰기 class="btn btn-sm btn-primary">
		         <input type=button value=취소 class="btn btn-sm btn-primary"
		           onclick="javascript:history.back()"
		         >
		       </td>
		     </tr>
		   </table>
		   </form>
		  </div>
		  <div class="col-md-4">
		  
		  </div>
		 </div>
		</div>
</body>
</html>