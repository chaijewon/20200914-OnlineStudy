<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 119page 
     pageContext : PageContext 클래스로부터 미리 생성된 객체(내장객체)
     ============
             페이지 흐름 제어 : 특정부분에 다른 JSP를 첨부 : include
             자주 사용 => 태그형으로 변경 
                 액션태그  <jsp:include> <jsp:forward> ==> Spring 
                 
         <jsp:include> = pageContext.include()
         =============
                   권장 사항  => <jsp:include> ==> 자동으로 pageContext.include()변환  
                   
         ==> 자바하고 HTML이 분리해서 사용 ==> 태그형 프로그램 
             <%
                 for(int i=1;i<=10;i++)
                 {
                 }
             %>
             
             <c:forEach var="i" begin="1" end="10" step="1">
             
                        태그로 자바를 제어하는 프로그램  => MVC => Spring
                        
                        
             include ==> 조립 하는 프로그램 
                        ==============
                                                    수정,추가
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
     <table border=1 bordercolor=black width=700 height=500>
       <tr>
         <td colspan="2" height=100><jsp:include page="include/header.jsp"></jsp:include></td>
       </tr>
       <tr>
         <td width=150><% pageContext.include("include/login.jsp"); %></td>
         <td width=550><% pageContext.include("include/content.jsp"); %></td>
       </tr>
       <tr>
         <td colspan="2" height=100><% pageContext.include("include/footer.jsp"); %></td>
       </tr>
     </table>
   </center>
</body>
</html>






