package com.sist.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
/*
 *   메모리 유지 
 *   CLASS
 *   SOURCE
 *   ================ 컴파일후에 메모리 해제 
 *   RUNTIME
 *   ================ 컴파일후에도 메모리 유지
 */
@Target(METHOD)
/*
 *   Annotation 
 *    1. 기능이 없다 
 *    2. 찾기 
 *       = TYPE  ====> 클래스를 찾는 경우
 *       = PARAMETER => 매개변수를 찾는 경우
 *       = CONSTRUCTOR => 생성자 찾는 경우
 *       = FILED  => 멤버변수 찾는 경우
 *       = METHOD => 메소드 찾는 경우 
 *    ================================= 위치 (Annotation)
 *    @Annotation명  ==> TYPE
 *    public class MovieModel
 *    {
 *         @Annotation명  ==> FILED
 *         MovieDAO dao=new MovieDAO();
 *         
 *         @Annotation명  ==> CONSTRUCTOR
 *         public MovieModel(@Annotation명  ==> PARAMETER int a)
 *         {
 *         }
 *         @Annotation명  ==> METHOD
 *         public void display()
 *         {
 *         }
 *    }
 *    
 *    @RequestMapping("movie/list.do")  ==> Spring
 *    public String movieListData(HttpServletRequest request)
 */
public @interface RequestMapping {
   public String value(); // 문자열로 구분 
}





