<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%-- 라이브러리 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
     core : 
       1. 변수 선언 
          <c:set var="id" value="admin">
          ==> request.setAttribute("id","admin)
                                  ===== =======
                                  var(키명) value
       2. 제어문 
          <c:if test="조건문">
          <c:for var="i" begin="1" end="10" step="1">
                ======== ========  ======== ========
                                  변수명     초기값            조건           증가식
                                             ===== 증가는 가능 , 감소는 불가능
                                             ===== step="1"은 생략이 가능
                                  ======= <=10 (포함)
          <c:forEach var="i" begin="1" end="10">
          ==> for(int i=1;i<=10;i++)
          
          List<MovieVO> list=new ArrayList<MovieVO>();
          for(MovieVO vo:list) => foreach방식의 반복문 
          // 데이터를 묶어서 사용 (배열, ArrayList)
          <c:forEach var="vo" items="list">
                              items ==> 배열 , 컬렉션
                              
          String color="red,green,blue,black,yellow";
          StringTokenizer st=new StringTokenizer(coloe,",")
          ==> String[] colors=color.split(",")
          while(st.hasMoreTokens())
          {
              System.out.println(st.nextToken())
          }
          
          <c:forTokens var="s" value="red,green,blue,black,yellow"
                       =======        ===========================
                       st.nextToken()    자를 문자열
             delims=",">
             ==========
                          구분문자 
                          
           switch문장 , 다중 if
           <c:choose>
             <c:when test=="조건">처리문장</c:when>
             <c:when test=="조건">처리문장</c:when>
             <c:when test=="조건">처리문장</c:when>
             <c:otherwise>디폴트(조건이 없는 경우)</c:otherwise>
           </c:choose>
           
           ***** JSTL (Java Standard Tag Library)
           ***** 자바의 문법을 태그형으로 제공 
                 ==================== 화면 출력 (JSP => 태그를 이용해서 화면에 출력 : View)
                  core : 변수설정 , 제어문 , URL ,파일 이동 
                  format : 문자변환 ,날짜변환 , 숫자변환 
                  fn : 문자열함수,컬렉션함수를 제어
                  ==================================
                  xml : XML파싱  ====> ~Manager
                  sql : 오라클 연결 ===> ~DAO
                  ====================== 사용빈도가 없다 (자바 사용 권장)
       3. 파일이동 
          <c:redirect url="이동할 주소"> response.sendRedirect("");
          <c:import>
          
          ==> <c:set>
              <c:forEach>
              <c:if>   ===================> <c:else>가 없다
              <c:choose>
              <c:redirect>
          ==> 기타 (spring : spEl) 
 --%>
<%-- 변수 선언 : JSTL(XML로 제작 => 여는 태그,닫는 태그 , 속성값이 있는 경우에는 "") --%>
<%
     String name="홍길동";// 일반 출력 
     request.setAttribute("name", name);
%>
<c:set var="id" value="admin"/>
<%--
      <c:set var="id" value="admin"/>
      request.setAttribute("id","admin");
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%--
     '<%'로 시작하는 모든 내용을 사용하지 않는다 (권장)  ==> 태그형 프로그램으로 전환 
                                                ===========
      MVC (model2) 
      Model : 자바 (VO,DAO,Manager..)
      View  : JSP (태그형 프로그램)
      Controller : Model과 View연결해주는 역할  (서블릿)
 --%>
  이름 : <%= name %> , <% out.println(name); %><br>
 EL : ${name }
 <br>
 EL : ${id }
</body>
</html>



