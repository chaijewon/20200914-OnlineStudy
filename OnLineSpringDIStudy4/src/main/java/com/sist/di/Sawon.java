package com.sist.di;
/*
 *    Container : 여러개의 클래스를 모아서 관리 영역 
 *    ==========
 *      ApplicationContext (스프링 4) : 현재 사용 (스프링 4)
 *         ==> XML을 파싱
 *      AnnotationConfigApplicationContext (스프링 5)
 *         ==> Annotation
 */
public class Sawon {
    private String name;
    private String dept;
    private String job;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
   
}
