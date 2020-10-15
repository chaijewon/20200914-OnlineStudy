<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*
 *   var : 사용범위가 지정(X)
     let : 사용범위가 지정(O)
     const : 상수형 변수
 */
 /* var a=10;// 전역변수
 window.onload=function(){
    if(a==10)
    {
    	let b=100;	
    }
    console.log("b="+b);
 } */
 /*
      처리 
       = 연산자
                 산술연산자 (+ , - , * , / , %)
                 ===         == 정수/정수=실수
                	 1) 산술처리
                	 2) 문자열 결합 
                 논리연산자
                 비교연산자 ( == , != , <  , >  , <= , >= )
                   ===(같다) , !==(같지 않다)
                                   문자열 비교 : ===
                                   문자열 => "" , 'Hello' 
                 삼항연산자
                 대입연산자 
                 스코프연산자 (...)
       = 제어문 
                 조건문
           => 단일조건문
           => 다중조건문 
           => 선택조건문
                반복문 
           => for
           => do~while
           => while
           => for-each
           => for - in
           => map
                반복제어문 
           => continue
           => break
 */
 window.onload=function(){
      let a=10;
      let b=3;
      console.log("10+3="+(a+b));
      console.log("10-3="+(a-b));
      console.log("10*3="+(a*b));
      console.log("10/3="+(a/b)); // 정수/정수 = 실수
      console.log("10%3="+(a%b));
      
      let aa='Hello ';
      let bb='JavaScript!!';
      console.log(aa+bb);
      
      let aaa="10";
      let bbb=20;
      console.log(aaa+bbb); //1020  ${"20"+10}=30
      
      let aaaa='A'
      let bbbb=10
      console.log(aaaa+bbbb)//75  '' => 문자열  ==> "A"
 }
</script>
</head>
<body>

</body>
</html>