<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%-- taglib를 가지고 온다 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
      EL => 표현언어 (브라우저 출력) : 254page
           방식
        = ${requestScope.id} ==> request.getAttribute("id") => 한개의 JSP에서 사용
                   한번 사용하기 버리는 경우 => request.setAttribute()
        = ${sessionScope.id} ==> session.getAttribute("id") => 프로젝트에 있는 모든 JSP에 사용
                   여러개의 JSP에서 공통으로 사용되는 데이터가 있는 경우에 session.setAttribute()
        ==========================================================
        = ${application.id}  ==> application.getAttribute("id")
        = ${param.id}  ==> request.getParameter("id");
        
      EL에서 사용하는 연산자 => 제어문 (조건문 사용시) 258page
        = 산술연산자 
          + : 순수하게 숫자만 계산한다 (문자열 결합은 없다)
              ${10+10}  ==> 20
              ${10+"10"} ==> 20
                   ===== 숫자형으로 문자열이 있는 경우 자동으로 Integer.parseInt("10");
              ${null+10} ==> 10 
                   ===== null 값인 경우에는 0으로 취급
              ${10+"10 "} ==> 오류 
              ****** ${10+="10"} 1010 => += 문자열 결합 
          -  : 순수하게 숫자만 계산 
               ${10-10}  ==> 0
               ${10-"10"} ==> 0
               ${null-10} ==> -10  (산술연산자에서는 null은 0값으로 처리)
          *
          ===============================================================
          /  : 0으로 나눌 수 없다 , 정수/정수 = 실수  (5/2=2) (5/2=2.5)
               ${5/2} , ${5 div 2}  / 대신 div를 사용할 수 있다
          %  : 나머지  mod
               ${5%2} => 1  , ${5 mod 2} => 1
        = 비교연산자
        = 논리연산자
        = Empty
        = 부정연산자 
        = 삼항연산자 
 --%>
<%
     Date date=new Date();
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
     String today=sdf.format(date);
%>
<%-- 오늘 날짜 저장 --%>
<c:set var="today" value="<%=today %>"/>
<%-- today=2020-10-05 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%-- <h1>EL연산자 사용 +,-,*</h1>
  5+5=${5+5 }<br>
  5+"5"=${5+"5" }<br>
  문자열 결합을 하지 않고 정수형으로 변환후에 연산처리 
  null+5=${null+5 }<br>
  null 일때는 0으로 인식
  <h1>EL연산자 사용 / %</h1>
  5/2=${5/2 }<br>정수/정수 = 실수
  5 div 2=${5 div 2 }<br>
  5%2=${5%2 }<br> 
  5 mod 2=${5 mod 2 } --%>
  <%--
         비교연산자 : 결과값 (true/false) => 조건문 
     ==  : 문자열도 ==으로 비교한다   ${id=='admin'}
           ${id eq 'admin'}
                == equals
     !=  : 문자열도 !=으로 비교한다   ${id != 'admin'}
           ${id ne 'admin'}
               === not equals
     <   : ${ 7<8 }  ==> ${7 lt 8}
     >   : ${ 7>8 }  ==> ${7 gt 8}
     <=  : ${ 7<=8}  ==> ${ 7 le 8}
     >=  : ${ 7>=8}  ==> ${ 7 ge 8}
     
         논리연산자 
       &&  ==> and 
       ||  ==> or
       !   ==> not
   --%>
   <h1>1~10까지 출력 (짝수만 출력)</h1>
   <%-- 형식:XML => 여는 태그와 닫는 태그가 명확 --%>
   <c:forEach var="i" begin="1" end="10"><%-- for(int i=1;i<=10;i++) --%>
     <%--
          == (eq)
          != (ne)
      --%>
     <c:if test="${i%2 ne 0 }">
       ${i }&nbsp; <%-- &nbsp; 공백 --%>
     </c:if>
   </c:forEach>
   
   <br>
   <h1>EL에서 문자열 비교</h1>
   <%-- test=>조건을 저장하는 속성
        XML은 없는 속성을 사용하면 error가 발생
        if(조건문)
        
        <c:if test="">
    --%>
   <%--
        <c:else>가 존재하지 않는다 
    --%>
   <%-- <c:if test="${today=='2020-10-05' }">
     <font color="red"><b>오늘 날짜입니다</b></font>
   </c:if>
   <c:if test="${today!='2020-10-04' }">
     <font color="red"><b>오늘 날짜가 아닙니다</b></font>
   </c:if> --%>
   <c:choose><!--  다중 if , 선택 if -->
     <%-- c:when : if 
          '' => 문자열 
          ===========
            = 자바스크립트
            = 오라클
     --%>
     <c:when test="${today eq '2020-10-05' }">
       <font color="red"><b>오늘 날짜입니다</b></font>
     </c:when>
     <%-- c:otherwise else --%>
     <c:otherwise>
       <font color="red"><b>오늘 날짜가 아닙니다</b></font>
     </c:otherwise>
   </c:choose>
</body>
</html>






