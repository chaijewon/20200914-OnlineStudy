<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    // 사용자의 요청 값을 받는다
    // String page(X) ==> page는 내장 객체 ==> (page=this)
    String strPage=request.getParameter("page");
    // Default Page => page값를 지정
    if(strPage==null) // page번호가 지정이 없는 경우 (맨처음 실행)
    {
    	strPage="1";
    }
    
    String mno=request.getParameter("mno");
    if(mno==null)
    	mno="0";
    int index=Integer.parseInt(mno);
    // 현재 페이지 지정 
    int curpage=Integer.parseInt(strPage);
    // 현재 페이지에 해당되는 데이터를 DAO요청 
    Map map=new HashMap(); //map => 저장 공간 => key,실제값
    int rowSize=12;
    int start=(rowSize*curpage)-(rowSize-1); // 12-11 ==> 1 (오라클 => rownum : 시작번호가 1)
    int end=rowSize*curpage; // curpage=1 => 1~12
    // WHERE num BETWEEN #{start} AND #{end}
    // map에 저장 
    map.put("start",start);
    map.put("end",end);
    List<MovieVO> list=new ArrayList<MovieVO>();
    if(index==0)
    {
    		list=MovieDAO.movieListData(map);// 전체 영화 => 페이지 
    }
    else
    {
    	    list=MovieDAO.movieCategoryData(index);// 전체 출력 
    }
    // 총페이지 읽기 
    int totalpage=MovieDAO.movieTotalPage();
    
    // Cookie 읽기
    List<String> cList=new ArrayList<String>();
    Cookie[] cookies=request.getCookies();
    /*
       new Cookie(키,값)
             m1 m2.....
             ==> 키를 읽어 올때 => cookie.getName()
             ==> 값을 읽어 올때 => cookie.getValue()
    */
    for(int i=0;i<cookies.length;i++)
    {
    	System.out.println(cookies[i].getName()+":"+cookies[i].getValue());
    	if(cookies[i].getName().startsWith("m"))
    	{
    		System.out.println(cookies[i].getValue());
    		cList.add(cookies[i].getValue());
    	}
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%--
         btn-sm  : 중간
         btn-lg  : 큰버튼
         btn-xs  : 작은 버튼
    --%>
   <div class="row">
     <a href="../main/main.jsp" class="btn btn-lg btn-active">전체 영화</a>
     <a href="../main/main.jsp?mno=1" class="btn btn-lg btn-primary">현재 상영 영화</a>
     <a href="../main/main.jsp?mno=2" class="btn btn-lg btn-success">개봉 예정 영화</a>
     <a href="../main/main.jsp?mno=3" class="btn btn-lg btn-info">박스오피스(주간)</a>
     <a href="../main/main.jsp?mno=4" class="btn btn-lg btn-danger">박스오피스(월간)</a>
     <a href="../main/main.jsp?mno=5" class="btn btn-lg btn-warning">박스오피스(연간)</a>
   </div>
   <div class="row">
     <%
        for(MovieVO vo:list)
        {
     %>
             <div class="col-md-4">
			    <div class="thumbnail">
			      <a href="../movie/cookie.jsp?no=<%=vo.getNo()%>">
			        <img src="<%=vo.getPoster() %>" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p style="font-size:8pt"><%=vo.getTitle() %></p>
			        </div>
			      </a>
			    </div>
			  </div>
     <%
        }
     %>
   </div>
   <%
       // index ==> cateno (1,2,3,4,5) 0=전체 출력 
       if(index==0) // 영화 전체 페이지인 경우
       {
   %>
		   <div class="row">
		     <%-- 페이지 이동 --%>
		     <div class="text-center">
		       <a href="../main/main.jsp?mode=7&page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-success">이전</a>
		       <%= curpage %> page / <%=totalpage %> pages
		       <a href="../main/main.jsp?mode=7&page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-info">다음</a>
		     </div>
		   </div>
   <%
       }
   %>
   <%-- 205~206page참조 --%>
   <div class="row">
    <h3>최근 방문한 영화 &nbsp;<a href="../movie/delete.jsp" class="btn btn-sm btn-primary">쿠키삭제</a></h3>
     <%
         if(cList==null || cList.size()<1)
         {
     %>
             <font color=red><h1 class="text-center">방문 기록이 없습니다</h1></font>
     <%
         }
         else
         {
	         for(String s:cList)
	         {
	 %>
	           <div class="col-md-2">
			    <div class="thumbnail">
			        <img src="<%=s %>" alt="Lights" style="width:100%">
			    </div>
			  </div>
	 <% 
	         }
         }
     %>
   </div>
</body>
</html>



