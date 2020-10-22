package com.sist.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       AnnotationConfigApplicationContext app=
    		   new AnnotationConfigApplicationContext(
    				   Config1.class,Config2.class);
       Sawon s=(Sawon)app.getBean("sawon");
       System.out.println(s.getName());
       System.out.println(s.getDept());
       System.out.println(s.getJob());
       Member m=(Member)app.getBean("mem");
       System.out.println(m.getName());
       System.out.println(m.getAddr());
       System.out.println(m.getTel());
	}

}
