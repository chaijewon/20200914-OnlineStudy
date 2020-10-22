package com.sist.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
   @Bean("sawon")
   public Sawon sawonInfo()
   {
	   /*
	    *   <bean id="sa" class="com.sist.di.Sawon"
		      p:name="홍길동"
		      p:dept="영업부"
		      p:job="대리"
		    />
		     * 
		     * map.put("sa",new Sawon()) => 100
		     * 
		     * public Object getBean(String id)
		     * {
		     *    return map.get(id);
		     * }
		     * 
		     * Sawon sa=getBean("sa")
		     * Sawon sa=100
		     * 
		     * int a=10;
	    */
	   Sawon s=new Sawon();// 객체 생성 
	   // DI
	   s.setName("이순신");
	   s.setDept("개발부");
	   s.setJob("과장");
	   return s;
   }
}
