<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:700px;
}
h1 {
   text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let fileIndex=0;
$(function(){
	$('#addBtn').click(function(){
		$('#user-table').append(
		   '<tr id=f'+fileIndex+'>'
		  +'<td width="15%" class="text-right">파일'+(fileIndex+1)+'</td>'
		  +'<td width="85%"><input type="file" name=files['+fileIndex+']>'
		  +'</td></tr>'
		);
		fileIndex=fileIndex+1;
	});
	$('#removeBtn').click(function(){
		if(fileIndex>0)
		{
			$('#f'+(fileIndex-1)).remove();
			fileIndex=fileIndex-1;
		}
	});
});
</script>
</head>
<body>
  <div class="container">
    <div class="row">
     <h1>글쓰기</h1>
     <form method=post action="insert_ok.do" enctype="multipart/form-data">
     <table class="table">
       <tr>
        <th class="text-right danger" width=15%>이름</th>
        <td width=85%>
          <input type=text name=name size=15>
        </td>
       </tr>
       
       <tr>
        <th class="text-right danger" width=15%>제목</th>
        <td width=85%>
          <input type=text name=subject size=50>
        </td>
       </tr>
       
       <tr>
        <th class="text-right danger" width=15%>내용</th>
        <td width=85%>
          <textarea rows="8" cols="55" name=content></textarea>
        </td>
       </tr>
       <tr>
         <td colspan="2">
	         <table class="table">
	           <tr>
	            <td class="text-right">
	              <input type=button value="add" class="btn btn-xs btn-success" id="addBtn">
	              <input type=button value="remove" class="btn btn-xs btn-warning" id="removeBtn">
	            </td>
	           </tr>
	         </table>
	         <table class="table" id="user-table">
	           
	         </table>
         </td>
       </tr>
       <tr>
        <th class="text-right danger" width=15%>비밀번호</th>
        <td width=85%>
          <input type="password" name=pwd size=10>
        </td>
       </tr>
       
       <tr>
        <td colspan="2" class="text-center">
          <input type=submit value="글쓰기">
          <input type=button value="취소" onclick="javascript:history.back()">
        </td>
       </tr>
     </table>
     </form>
    </div>
  </div>
</body>
</html>


