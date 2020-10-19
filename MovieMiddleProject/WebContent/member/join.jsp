<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1{
  margin: 0px auto;
  width:700px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
// 대소문자 구분 => 라이브러리 
// $ => jquery첨부
function postfind()
{
	new daum.Postcode({
		oncomplete:function(data)
		{
			// jquery가 들어간 부분
			$('#post').val(data.zonecode);
			// document.getElementById("post").value=data.zonecode
			$('#addr1').val(data.address);
		}
	}).open();
}
function idcheck()
{
	window.open("../member/idcheck.do","idcheck","width=320,height=300,scrollbars=no");
}
/*
 *   function idcheck()
 *   {
              처리 
     }
     var idcheck=function()
     {
    	 
     }
     // 가장 많이 사용하는 방법
         화살표 함수 => function,return  
     var idcheck=()=>{
    	 
     }
     
     return형이 있는 경우
     function func_name()
     {
    	 return 값;
     }
     
         매개변수가 있는 경우
     function func_name(addr,name)
     {
        	 
     }
         
         내장 객체
        window  ==> 새로운 창을 여는 경우
                    open ==> 팝업창
        document ==> 브라우저에 출력 
        location ==> 파일 이동 
        form     ==> 입력값을 가지고 오는 경우에 사용 
               제어문 , 	배열 : 본인이 공부
               배열 => 데이터형이 틀려도 된다  [10,"aaa",10.5] 
 */
$(function(){
	$('#joinBtn').click(function(){
		let id=$('#id').val();
		if(id.trim()=="")
		{
			$('#id').focus();
			return;
		}
		
		// 비밀번호
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		
		let pwd1=$('#pwd1').val();
		if(pwd1.trim()=="")
		{
			$('#pwd1').focus();
			return;
		}
		
		if(pwd!==pwd1)
		{
			alert("비밀번호를 다시 입력하세요!!");
			$('#pwd1').val("");
			$('#pwd1').focus();
			return;
		}
		
		let name=$('#name').val();
		if(name.trim()=="")
		{
			$('#name').focus();
			return;
		}
		
		let birthday=$('#birthday').val();
		if(birthday.trim()=="")
		{
			$('#birthday').focus();
			return;
		}
		
		let post=$('#post').val();
		if(post.trim()=="")
		{
			$('#post').focus();
			return;
		}
		
		let addr1=$('#addr1').val();
		if(addr1.trim()=="")
		{
			$('#addr1').focus();
			return;
		}
		
		let content=$('#content').val();
		if(content.trim()=="")
		{
			$('#content').focus();
			return;
		}
		
		// 데이어 전송 
		$('#joinFrm').submit();
	});
});
</script>
</head>
<body>
  <div style="height: 30px"></div>
  <div class="row row1">
    <h1 class="text-center">회원가입</h1>
    <form method=post action="../member/join_ok.do" name="joinFrm" id="joinFrm">
    <table class="table">
     <tr>
       <th class="text-right danger" width="15%">아이디</th>
       <td width=85%>
         <input type=text name=id class="input-sm" size=15 readonly id="id">
         <input type=button value="중복체크" class="btn btn-sm btn-primary" onclick="idcheck()">
       </td>
     </tr>
     <tr>
       <th class="text-right danger" width="15%">비밀번호</th>
       <td width=85%>
         <input type=password name=pwd class="input-sm" size=15 id="pwd">
         &nbsp;재입력:<input type=password name=pwd1 class="input-sm" size=15 id="pwd1">
       </td>
     </tr>
     <tr>
       <th class="text-right danger" width="15%">이름</th>
       <td width=85%>
         <input type=text name=name class="input-sm" size=15 id="name">
       </td>
     </tr>
     <tr>
       <th class="text-right danger" width="15%">이메일</th>
       <td width=85%>
         <input type=text name=email class="input-sm" size=45>
       </td>
     </tr>
     <tr>
       <th class="text-right danger" width="15%">생년월일</th>
       <td width=85%>
         <input type=data name=birthday class="input-sm" size=25 id="birthday">
       </td>
     </tr>
     <tr>
       <th class="text-right danger" width="15%">우편번호</th>
       <td width=85%>
         <input type=text name=post class="input-sm" size=7 readonly id="post">
         <input type=button value="우편번호" class="btn btn-sm btn-primary" onclick="postfind()">
       </td>
     </tr>
     <tr>
       <th class="text-right danger" width="15%">주소</th>
       <td width=85%>
         <input type=text name=addr1 class="input-sm" size=45 readonly id="addr1">
       </td>
     </tr>
     <tr>
       <th class="text-right danger" width="15%">상세주소</th>
       <td width=85%>
         <input type=text name=addr2 class="input-sm" size=45>
       </td>
     </tr>
     <tr>
       <th class="text-right danger" width="15%">전화번호</th>
       <td width=85%>
         <select name=tel1>
           <option>010</option>
           <option>011</option>
           <option>017</option>
         </select>
         <input type=text name=tel2 class="input-sm" size=15>
       </td>
     </tr>
     <tr>
       <th class="text-right danger" width="15%">소개</th>
       <td width=85%>
         <textarea rows="8" cols="55" name="content" id="content"></textarea>
       </td>
     </tr>
     <tr>
       <td colspan="2" class="text-center">
         <input type=button value="회원가입" class="btn btn-sm btn-danger" id="joinBtn">
         <input type=button value="취소" class="btn btn-sm btn-warning"
           onclick="javascript:history.back()"
         >
       </td>
     </tr>
    </table>
    </form>
  </div>
</body>
</html>








