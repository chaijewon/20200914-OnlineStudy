package com.sist.di2;

import org.springframework.stereotype.Component;

@Component("sa")
/*
 *    1. 클래스 => 메모리 할당 => 저장 공간 (Container)
 *       ApplicationContext => Map
 *    2. 클래스 찾기 : DL
 *    3. 생성과 동시에 필요한 데이터가 있는 경우   
 *       ==================== 처리 ==> DI  setter , constructor
 *                                        p:        c:
 *    4. 활용 : 프로그래머 
 *    5. 소멸 : 메모리 해제 
 *       @Component
 *        class Sawon
 *        
 *       @Component("mem")
 *        class Member
 *       ====================
 *        key      value
 *       ====================
 *        sawon    new Sawon()
 *       ====================
 *        mem      new Member()    => getBean("mem") ==> Member m=app.getBean("mem");
 *                                                                ===================
 *       ====================                                      new Member()
 *       AnnotationConfigApplicationContext
 *       = MVC = WebApplicationContext
 */

public class Sawon {
    private String name="심청이";
    private String dept="개발부";
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
	   
}
