package com.sist.di3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
/*
 *     
 *     interface I
 *     class A implements I
 *     class B implements I
 *     
 *     @Autowired
 *     I i=new A();
 *     I i=new B();
 *     
 */
// XML을 대신 사용 
@Configuration
public class ApplicationConfig {
   @Bean("mem")
   //@Scope("prototype")
   // <bean > XML => 대처하는 프로그램 (어노테이션)
   // 싱글턴 
   public Member memberInfo()
   {
	   Member m=new Member("이순신", "강원", "010-1111-1111");
	   return m;
   }
}
