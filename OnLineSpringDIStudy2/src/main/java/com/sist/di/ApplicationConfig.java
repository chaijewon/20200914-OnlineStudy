package com.sist.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// XML 대체
/*
 *    class 동물
 *    class 사람  extends 동물
 *    class 개  extends 동물   (사람)동물
 *    class 소  extends 동물
 */
@Configuration
public class ApplicationConfig {
    // 클래스 
	@Bean("sa")
	// <bean id="sa" class="Sawon">
	public Sawon sawonInfo()
	{
		Sawon sa=new Sawon();
		/*
		 *   <bean id="sa" class="Sawon"
		 *     p:name="홍길동"
		 *     p:addr="서울"
		 *     p:tel="010-1111-1111"
		 *   />
		 */
		sa.setName("홍길동");
		sa.setAddr("서울");
		sa.setTel("010-1111-1111");
		return sa;
	}
	@PostConstruct
	// <bean id="sa" class="Sawon" init-method="init" destory-method="destory">
	/*
	 *   메소드 호출 
	 *     객체생성시 : init-method  (@PostConstruct)
	 *               =========== DB (드라이버 등록)
	 *     객체소멸시 : destory-method (@PreDestroy)
	 *               =========== DB (disConnection)
	 *               
	 *     DI 
	 *      = setter DI
	 *      = method DI (init-method,destory-method)
	 *      = constructor DI 생성자 매개변수 값 주입 
	 *      = 자동 주입 
	 */
	public void init()
	{
		System.out.println("===== 사원 정보 =======");
	}
	@PreDestroy
	public void destory()
	{
		System.out.println("====================");
	}
}




