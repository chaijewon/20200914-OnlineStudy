<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    /*
         1. 사용자가 보내준 데이터를 받는다 
                      사용자가 보내준 모든 데이터  => request에 들어가 있다
                      사용자가 요청 할때마다 톰캣이 request에 모아서 넘겨준다 (getParameter())
         2. 사용자로부터 받은 데이터를 DAO에 넘겨준다 
         3. DAO가 요청한 데이터 보내준다 
         4. DAO로부터 받은 데이터 화면에 출력 (HTML=>JAVA를 포함 사용 => JSP)
            ==> HTML , JAVA 나눠서 처리 ==> M(Java)V(HTML) => 연결 (Controller:서블릿)
            ==> JAVA + ORACLE ==> Java(.java:DAO) , Oracle(XML) 나눠서 처리 
    */
    // 사용자가 보내주는 값 => page
    String strPage=request.getParameter("page");
    // 첫페이지 (파일) 페이지를 사용자가 보내 줄 수 없기 때문에 디폴트를 잡아준다 
    if(strPage==null) // 페이지 번호를 보내주지 않았다면 
       strPage="1"; // 디폴트를 설정하는 부분
    int curpage=Integer.parseInt(strPage);//현재 보고 있는 페이지 설정 
    // 현재 실행중인 페이지 번호 
    // 현재 실행 페이지 => DAO에서 데이터를 받아 온다 
    // DAO에 요청  어디부터 어디까지 데이터를 보내달라 (요청)
    int rowSize=20;// 한페이지에 데이터 20개씩 출력 
    int start=(rowSize*curpage)-(rowSize-1);// 시작위치 
    /*
        1 page => 1 ~ 20
        2 page => 21 ~ 40 
        
        WHERE num BETWEEN #{start} AND #{end} ==> Map
    */
    int end=rowSize*curpage;
    // Map에 저장해서 전송 (Map은 데이터를 쌍으로(키,값) 묶어서 저장하는 공간의 클래스)
    Map map=new HashMap();
    map.put("start",start);// #{start}
    map.put("end",end); // #{end}
    
    // DAO로 전송 
    // 전송 => 결과값을 받아 온다 
    List<ChefVO> list=RecipeDAO.chefListData(map);
    
    int totalpage=RecipeDAO.chefTotalPage();
    // 받은 데이터를 출력 => <body>
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:900px;
}
h1 {
    text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <h1>쉐프 목록</h1>
    <div class="row">
      <table class="table">
       <tr>
        <td>
          <%-- 데이터가 출력할 위치 --%>
          <%
             for(ChefVO vo:list)
             {
          %>
                <table class="table table-striped">
                 <tr bgcolor="white">
                   <td width=30% rowspan="2" class="text-center" bgcolor="white">
                     <img src="<%=vo.getPoster() %>" width=70 height=70 class="img-circle">
                   </td>
                   <td colspan=4 width=70% bgcolor="white"><font color=orange>
                     <a href="chef_list.jsp?chef=<%=vo.getChef()%>"><%=vo.getChef() %></a>
                   </font></td>
                 </tr>
                 <tr>
                   <td><img src="1.png"><%=vo.getMem_cont1() %></td>
                   <td><img src="2.png"><%=vo.getMem_cont3() %></td>
                   <td><img src="3.png"><%=vo.getMem_cont7() %></td>
                   <td><img src="4.png"><%=vo.getMem_cont2() %></td>
                 </tr>
                </table>
          <%
             }
          %>
        </td>
       </tr>
      </table>
      <%--
           mapper.xml => SQL문장 제작 
           DAO => 처리
           jsp => 처리된 데이터 출력 
       --%>
      <table class="table">
         <tr>
           <td class="text-center">
             <a href="chef.jsp?page=<%= curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-success">이전</a>
               <%=curpage %> page / <%=totalpage %> pages
             <a href="chef.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-warning">다음</a>
           </td>
         </tr>
      </table>
    </div>
  </div>
</body>
</html>



