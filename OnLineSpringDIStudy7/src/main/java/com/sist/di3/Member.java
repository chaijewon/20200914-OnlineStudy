package com.sist.di3;

import org.springframework.stereotype.Component;

/*
 *    1. 멤버변수 초기화 
 *       1) 명시적 초기화
 *       =============
 *       2) setter
 *       3) 생성자
 */
@Component("mem")
public class Member {
    private String name="홍길동";
    private String addr="서울";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void print()
	{
		System.out.println("이름:"+name);
		System.out.println("주소:"+addr);
	}
  
}
