<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 변수설정 , 제어문 , URL : core --%>
<%-- 태그(XML)을 이용해서 자바 라이브러리를 만든다 : taglib --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 날짜 변경 , 숫자 변경  : format --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- String클래스의 메소드를 사용할 수 있게 만든 라이브러리 --%>
<%--
      JSTL => Java Standard Tag Library : XML형식 
      1. 지원하는 태그와 속성만 사용이 가능 
      2. 오버라이딩 => 사용자 정의 태그라이브러리
      3. JSP => View(화면출력 용도) => if , for , 다중 if
      
      => 1. core
            <c:set var="" value=""> : 변수 설정 
                  ======= ========
                                      키            값  =======> request.setAttribute(var에 지정된 키,value에 있는 값);
                      제어문
            <c:if test="조건문">결과값</c:if> :
                if(test에 지정된 조건문)  =======> 단점이 else가 없다(단일 조건문만 사용이 가능)
            <c:forEach var="i" begin="1" end="10" step="1">
                for(int i=1(begin);i<=10(end);i++(step))
                       = end는 포함 end="10" ==> i<=10
                       = step => 음수는 사용할 수 없다 (양수)  ===> 일반 for문 사용 
            <c:forEach var="vo" items="배열,ArrayList">
                 for(MovieVO vo:list) ==> for-each(향상된 for) ==> list가 두개일때 처리 
                 
            <c:choose> switch,다중 if
              <c:when test="조건문">결과</c:when>
              <c:when test="조건문">결과</c:when>
              <c:when test="조건문">결과</c:when>
              <c:when test="조건문">결과</c:when>
              <c:when test="조건문">결과</c:when>
              <c:otherwise>해당되는 조건이 없는 경우에 처리<c:otherwise>default,else
            <c:choose>
            
            <c:forTokens var="" value="id|sex|name|pwd" delims="|">
                       =======  ========                =========== 구분문자
                                           자른문자                  분해 대상
            
            URL(화면 이동)
             <c:redirect url="이동할 주소">
               => response.sendRedirect(url에 설정된 주소)
               
             <c:out value=""/> => <%=%> 출력할때 주로 사용
                 
      => 2. fmt : 변환 
             = 날짜 변환
               <fmt:formatDate value="변경될 날짜 데이터" pattern="">
                                년도 : yyyy
                                월    : M , MM  ==> M (1,2,3,..10,11,12) , MM (01,02~10,11,12)
                                일   : dd 
                                시간 : hh
                                분   : mm
                                초   : ss
                                ===> SimpleDateFormat(pattern에 지정된 형식)
             = 숫자 변환
               <fmt:formatNumber value="변경할 숫자" pattern="00,000"> 
                                  오라클 : 9 , 자바: 0
                             예)<fmt:formatNuber value="90000" pattern="00,000"> => 90,000
                  <fmt:~> ==> out.println()
      => 3. function(fn) : String메소드 호출 ===> 333page
            length() , substring() , split() ,trim() ,toUpperCase()
            toLowerCase() , replce() , indexOf() ,startsWith() ,endsWith()
            ================================== JavaScript
            ${fn:length("abcdefg")}
            ${fn:substring(문자열,1,5)}
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <fmt:formatNumber value="90000" pattern="00,000"/><br>
   <c:out value="Hello JSP"/><!-- Javascript : Jquery ($)=> ${} -->
   <%--
        Javascript ==> JSTL 가능 => 그래프 제작 
    --%>
</body>
</html>







