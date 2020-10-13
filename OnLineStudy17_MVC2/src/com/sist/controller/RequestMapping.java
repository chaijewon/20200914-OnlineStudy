package com.sist.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RequestMapping {
  public String value();//String문자열로 구분 (찾기) => 구분자가 동일하면 안된다 
  // 메소드위에 => @RequestMapping("구분") => 찾는 내용 밑에 있다 
  // rm.value()
}
