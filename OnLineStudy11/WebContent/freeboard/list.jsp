<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%--
      자바 : 데이터를 가지고 온다 
      데이터 => 출력 (JSP)
 --%>
<%--
     게시판 목록 출력 
     영화 (home.jsp) : cookie
     로그인 (login.jsp) : session
     freeboard : <jsp:~>
     databoard : 다운로드 , 업로드
     예매 : javascript => Ajax
 --%>
<%
     String strPage=request.getParameter("page");
     // 사용자가 전송(요청) => 요청한 데이터를 톰캣이 모든 데이터를 묶어서 request에 첨부)
     // 모든 데이터는 request를 통해서 들어온다 
     /*
           list.jsp?page=1  =>  request.getParameter("page");  => 1
           list.jsp         =>  request.getParameter("page");  => null
                            if(strPage==null)
           list.jsp?page=   =>  request.getParameter("page");  => ""
                            if(strPage.equals(""))
          ===========================================================
            <input type=text name=name> : 입력값이 없는 경우 (null이 아니고 "")
     */
     if(strPage==null) // 처음에 한번은 사용자가 페이지번호를 보낼 수 없다 (list.jsp)
     {
    	 strPage="1"; // default => 반드시 첨부한다
    			 // 페이지나누기 => 모든 JSP에 적용
    			 // 게시물  ==> 15개 ~ 20개
    			 // 그림출력 ==> 12개~15개 
     }
           
     int curpage=Integer.parseInt(strPage);// 현재 보고 있는 페이지
     // 현재 출력할 내용 가지고 오기 ==> 마이바이티에서 start , end 요청 
     // 데이터를 보내줄 때 여러개를 설정 (여러개의 값이 있는 경우 : Map,~VO) => 값을 모아서 마이바티스로 전송 
     /*
         ~VO => VO에 존재하는 변수가 있는 경우 
         start,end => name,subject
         Map => VO에 없는 변수가 있는 경우
     */
     Map map=new HashMap(); // 키,값을 동시에 저장하는 공간 
     // HashMap map=new HashMap();
     // Map map=new HashMap();
     // Map ==> interface => Map 인터페이스를 구현한 클래스 => HashMap()
     // Map ==> HashMap() , Hashtable()
     // List => ArrayList,Vector,LinkedList
     /*
         List => 인터페이스 
         List list=new ArrayList() => 비동기화 (이미 저장되어 있는 데이터:오라클)
         List list=new Vector() => 동기화 (내트워크)
         List list=new LinkedList() => C언어 호환 
     */
     int rowSize=10;
     int start=(rowSize*curpage)-(rowSize-1);// rownum (오라클에서 지원하는 데이터컬럼 => 1)
     int end=rowSize*curpage;
     
     map.put("start",start);
     map.put("end",end);
     List<BoardVO> list=BoardDAO.freeBoardListData(map);
     // 저장되어 있는 list의 값을 출력 => JSP가 하는 역할 (JSP:View) => 실무는 90%=> MVC(Spring:MVC외에는 없다)
    		 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="row">
     <h1 class="text-center">자유게시판</h1>
     <table class="table">
       <tr>
         <td>
           <a href="../main/main.jsp?mode=10" class="btn btn-sm btn-primary">새글</a>
           <%-- mode=10 이면 어떤 화면을 출력 할지 결정 : main.jsp --%>
         </td>
       </tr>
     </table>
     <table class="table table-striped">
       <%--
              danger : 빨간색
              success :  녹색
              info : 하늘색
              warning :주황색
              active : 회색
       --%>
       <tr class="danger">
         <%--
                     정렬 : text-left(default)
                 text-center,text-right
          --%>
         <th class="text-center" width=10%>번호</th>
         <th class="text-center" width=45%>제목</th>
         <th class="text-center" width=15%>이름</th>
         <th class="text-center" width=20%>작성일</th>
         <th class="text-center" width=10%>조회수</th>
       </tr>
       <%-- 데이터 출력 --%>
       <%
           for(BoardVO vo:list)
           {
       %>
               <tr>
                 <th class="text-center" width=10%><%=vo.getNo() %></th>
		         <th class="text-left" width=45%><%=vo.getSubject() %></th>
		         <th class="text-center" width=15%><%=vo.getName() %></th>
		         <th class="text-center" width=20%><%=vo.getDbday() %></th>
		         <th class="text-center" width=10%><%=vo.getHit() %></th>
               </tr>
       <%
           }
       %>
     </table>
   </div>
</body>
</html>






