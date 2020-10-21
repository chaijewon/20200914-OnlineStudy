package com.sist.di;
/*
 *   Container : 관리(조립) => 클래스를 모아서 관리 
 *   
 *        스프링에서 지원  (page 49) 
 *        ===========
 *          BeanFactory ==> CORE(DI)
 *             |
 *          ApplicationContext  AnnotationConfigApplicationContext
 *             |   DI , AOP                           |
 *        WebApplicationContext WebAnnotationConfigApplicationContext
 *                 DI , AOP , MVC
 *        ==> XML,Annotation에 등록 클래스를 읽어서 관리 
 *      
 *   Component : 클래스 한개
 *   
 *          메인보드
 *   컴퓨터  : CPU , 메모리 , 하드.....
 */
public class Sawon {
    private String name;
    private String addr;
    private String tel;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	   
}
