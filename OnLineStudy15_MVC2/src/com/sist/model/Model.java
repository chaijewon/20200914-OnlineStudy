package com.sist.model;

import javax.servlet.http.HttpServletRequest;
/*
 *    클래스의 유형이 다르면 조건문
 *    모든 클래스 유형이 동일 ==> interface
 *    
 *    class A
 *    class B
 *    
 *    interface I
 *    class A implements I
 *    class B implements I
 *    
 *    I i=new A()
 *    I i=new B()
 *    
 *    클래스 여러개를 모아서 한번에 관리 => 인터페이스 (스프링의 기본구조)
 *    
 *    
 */
public interface Model {
   public String execute(HttpServletRequest request);
}





