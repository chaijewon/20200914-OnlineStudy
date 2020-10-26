package com.sist.di3;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
// VO => 스프링에서 관리하는 클래스가 아니다 (데이터) : 사용자 정의 데이터형 
/*
 *    스프링이 관리하는 대상 
 *    ================ Bean
 *    @Repository
 *    1. DAO
 *    @Component
 *    2. Manager (웹크롤링,트위터 , openApi)
 *    @Controller
 *    3. Model
 *    @Service
 *    4. Service (DAO+DAO) => BI
 *    @Aspect
 *    5. AOP(공통모듈)
 */
//@Setter
//@Getter
public class EmpVO {
   private int empno;
   private String ename;
   private String job;
   private Date regdate;
   private int sal;
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}
   
}







