package com.sist.di5;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
/*
 *   스프링에서 생명주기 관련 인터페이스 
 *   InitializingBean : 초기화
 *   DisposableBean: 소멸 
 *   
 *   순서 (초기화)
 *    1. 생성자 => 멤버변수에 값을 채운다 => 메모리 할당 
 *    2. afterPropertiesSet() => setName,setDept
 *    ==========================================
 *    3. print() => 프로그래머 활용
 *    ==========================================
 *    4. close() => destory()
 */
public class Sawon implements InitializingBean,DisposableBean{

	private String name;
	private String dept;
	
	public Sawon(String name,String dept)
	{
		System.out.println("생성자 호출(Sawon(String name,String dept))");
		this.name=name;
		this.dept=dept;
	}
	public void print()
	{
		System.out.println("프로그래머가 활용 : print()");
		System.out.println("이름:"+name);
		System.out.println("부서:"+dept);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setterDI(setName())");
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		System.out.println("setterDI(setDept())");
		this.dept = dept;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("객체 소멸:destory()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("setter DI 시작:afterPropertiesSet()");
		
	}

}
