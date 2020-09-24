<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%-- 목록 출력 : list.jsp : board폴더 --%>
<!-- 데이터를 읽어 온다 (1page)있는 게시물  -->
<%
     // DAO를 생성 => DAO를 통해서 데이터를 얻어온다 
     // static으로 메소드=> 이미 메모리에 저장 
     // 사용자로부터 페이지를 받아 본다 
     String strPage=request.getParameter("page");
     if(strPage==null) // 페이지를 보내지 않을 경우 (맨처음에는 페이지를 보낼 수 없다)
    	 strPage="1";// 시작페이지를 설정해 준다 
     int curpage=Integer.parseInt(strPage);
     // start:1 , end:10
     Map map=new HashMap();
     int rowSize=10;
     int start=(curpage*rowSize)-(rowSize-1);
     int end=curpage*rowSize;
     // map에 저장 => map 저장하는 공간 => 키,값을 설정 할 수 있다 
     map.put("start",start);
     map.put("end",end);
     List<DataBoardVO> list=DataBoardDAO.boardListData(map);// 1page 1~10
     // 총페이지읽기
     int totalpage=DataBoardDAO.boardTotalPage();
     // 화면에 출력 
     // 데이터 읽기 : 파일,XML,JSON,database(오라클),웹크롤링(날씨,인기검색어)
     // database(오라클):일반 JDBC,DBCP,***ORM(Mybatis:실무)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send()
{
	// 자바스크립트는 변수 종류가 없다 (var:자동 지정 변수)
	/*
	    var a=10 ; var=int
	    var b=10.0; var=double
	    var c='a'; char
	    var d="aaa"; String
	    var e=[]; Array
	    var k={}; Object
	*/
	var f=document.frm;
	// 반드시 입력을 할 수 있게 만든다 
	if(f.ss.value=="")
	{
		f.ss.focus();
		return;
	}
	f.submit();// submit버튼과 동일한 역할  ==> Jquery => NodeJS => reactjs => vuejs => typescript
}
</script>
</head>
<body>
   <div class="row">
     <h1 class="text-center">자료실</h1>
     <table class="table">
       <tr>
         <td>
           <a href="main.jsp?mode=2" class="btn btn-sm btn-success">새글</a>
           <%-- 메뉴 , 로그인 , footer 고정 => main.jsp --%>
         </td>
       </tr>
     </table>
     <table class="table table-striped">
       <tr class="warning">
         <th class="text-center" width=10%>번호</th>
         <th class="text-center" width=45%>제목</th>
         <th class="text-center" width=15%>이름</th>
         <th class="text-center" width=20%>작성일</th>
         <th class="text-center" width=10%>조회수</th>
       </tr>
       <%
           /*
                           컬럼이 없는 값을 받는 경우 => VO에서 변수 설정 
               private String dbday; =>dbday값을 채운다 
               name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday => mapper 
           */
           for(DataBoardVO vo:list)
           {
        	   /*
        	        ../main/main.jsp?mode=3&no=1
        	                         ====== ==== detail.jsp에서 사용
        	                                          화면변경시 사용(main.jsp)
        	         include가 되면 ==> 모든 JSP에서 사용자가 보내준 데이터를 사용이 가능 
        	         ============
        	           request가 공유 
        	   */
       %>
               <tr>
		         <td class="text-center" width=10%><%=vo.getNo() %></td>
		         <td width=45%>
		          <a href="../main/main.jsp?mode=3&no=<%=vo.getNo()%>"><%=vo.getSubject() %></a>
		          <%-- include된 모든 JSP는 main.jsp로 보낸 모든 데이터값을 사용할 수 있다 
		               main.jsp => mode=3 => 화면 변경
		               detail.jsp => no=1 => 해당되는 데이터를 받아서 출력 
		          --%>
		         </td>
		         <td class="text-center" width=15%><%=vo.getName() %></td>
		         <td class="text-center" width=20%><%=vo.getDbday() %></td>
		         <td class="text-center" width=10%><%=vo.getHit() %></td>
		       </tr>
       <%
           }
       %>
     </table>
     <table class="table">
       <tr>
         <td class="text-left">
         <!-- 
                          데이터 전송하는 방식 
                  = GET => URL뒤에 노출
                                데이터를 받을 파일명?변수명=값
                                                            변수명=값&변수명=값&변수명=값
                                                            구분문자는 &
                  = POST => 내부 네트워크를 이용한 전송 (보안 ,URL주소 길어진면 숨겨서 전송)
                                                    변수명=값&변수명=값&변수명=값
          -->
          <form method="post" action="../main/main.jsp" name=frm>
	          Search:
	          <select name="fd" class="input-sm">
	            <option value="name">이름</option>
	            <option value="subject">제목</option>
	            <option value="content">내용</option>
	          </select>
	          <%-- 검색어 입력 --%>
	          <input type=text name=ss class="input-sm">
	          <input type=hidden name=mode value=4>
	          <%-- 검색버튼 --%>
	          <input type=button value=검색 class="btn btn-sm btn-danger"
	            onclick="send()"
	          >
          </form>
         </td>
         <td class="text-right">
          <a href="#" class="btn btn-sm btn-primary">이전</a>
           <%=curpage %> page / <%=totalpage %> pages
          <a href="#" class="btn btn-sm btn-primary">다음</a>
         </td>
       </tr>
     </table>
   </div>
</body>
</html>




