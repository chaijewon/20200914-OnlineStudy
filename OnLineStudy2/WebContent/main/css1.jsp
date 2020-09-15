<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
   1) 프로젝트 생성
      = Java Resources => JRE System Library => JDK변경
      = WEB-INF => lib => ojdbc6.jar
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 내부 CSS -->
<style type="text/css">
/*
   div#aaa
   #aaa
*/
#aaa {
   /*크기*/
   width:200px;
   height:200px;
   /* 
   
         브라우저
     =====================
     margin
       ==============
       
         AAA
         padding
       ==============
       
      
     =====================
   
     padding : (top) (left) (bottom) (right)
     padding : 20px
               20px  (20px) (20px) (20px)
     padding : 50px 20px
               50px 20px (50px) (20px)
     padding : 50px 20px 30px (20px)
               top => bottom
               left => right
     =========================================
       margin , padding => 화면 분할 
   */
   padding: 20px;
   border: 1px solid red;
   margin: 50px;
   /* 글자 관련 
      font-size : 글자 크기
      font-weigth : bold
      font-family: 글꼴 ==> 외부에서 불러서 사용 (google)
      
           사이트 : 같은 글꼴을 사용  (google폰트 사용법)
   */
   font-size: 12pt;/* 폰트의 기본 : 10pt*/
   font-weight: bold;
   font-family: 궁서체;
}
</style>
</head>
<body>
  <!-- 화면 분할 -->
   <!-- 
     같은 태그명을 구분할때  : id(한개만 이용),class(같은 태그가 여러개를 동시에 제어)
    -->
   <div id="aaa">CSS (Box-Model):내부 CSS</div><%-- display : block  --%>
   <%-- 인라인  --%>
   <%--
        순서 (지원,우선순위)
        외부 CSS
        내부 CSS
        인라인
        ==> bootstrap
    --%>
    <!-- 
      solid 
      dotted
      ==> 카드만들기 
     -->
   <div style="border: 5px solid green;width:100px;height:100px"></div>
   <div style="border: 5px dashed green;width:100px;height:100px"></div>
   <div style="border: 5px dotted green;width:100px;height:100px"></div>
   <div style="border: 5px double green;width:100px;height:100px"></div>
   <div style="border: 5px ridge green;width:100px;height:100px"></div>
   <div style="border: 5px outset green;width:100px;height:100px"></div>
   <div style="border: 5px groove green;width:100px;height:100px"></div>
</body>
</html>





