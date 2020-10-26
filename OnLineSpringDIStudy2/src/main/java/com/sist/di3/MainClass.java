package com.sist.di3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// map.put("mem",new Member())
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Member m=app.getBean("mem",Member.class);
        m.print();
	}

}
