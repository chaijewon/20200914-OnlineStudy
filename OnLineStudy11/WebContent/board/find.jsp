<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<%
     request.setCharacterEncoding("UTF-8");//utf-8
     String fd=request.getParameter("fd");
     String ss=request.getParameter("ss");
     System.out.println("fd:"+fd);
     System.out.println("ss:"+ss);
     // DAO로 전송 결과값을 받아 온다  ==> 검색한 내용 가지고 오기 위해서 SQL => databoard-mapper.xml => DAO처리
     // DAO로부터 처리된 결과를 받아 온다 
     Map map=new HashMap();
     map.put("fd",fd);
     map.put("ss",ss);
     
     int count=DataBoardDAO.boardFindCount(map);
     List<DataBoardVO> list=null;
     if(count>0)
     {
    	 list=DataBoardDAO.boardFindData(map);
     }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="row">
     <h1 class="text-center">검색결과</h1>
     <%
        if(count==0)// 검색 결과가 없는 경우
        {
     %>
             <table class="table">
               <tr>
                 <td class="text-center">검색결과가 없습니다</td>
               </tr>
             </table>
     <% 
        }
        else // 검색결과 존재
        {
     %>
            <table class="table table-striped">
              <tr class="success">
                <th class="text-center" width=10%>번호</th>
                <th class="text-center" width=45%>제목</th>
                <th class="text-center" width=15%>이름</th>
                <th class="text-center" width=20%>작성일</th>
                <th class="text-center" width=10%>조회수</th>
              </tr>
              <%
                  for(DataBoardVO vo:list)
                  {
              %>
                     <tr>
		                <td class="text-center" width=10%><%=vo.getNo() %></td>
		                <td class="text-center" width=45%><%=vo.getSubject() %></td>
		                <td class="text-center" width=15%><%=vo.getName() %></td>
		                <td class="text-center" width=20%><%=vo.getDbday() %></td>
		                <td class="text-center" width=10%><%=vo.getHit() %></td>
		              </tr>
              <%
                  }
              %>
            </table>
     <%
        }
     %>
   </div>
   
</body>
</html>