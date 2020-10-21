package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // XML ÆÄ½Ì 
		/*
		 *   Sawon s=new Sawon();
		 *   
		 *   Sawon s1=s;
		 */
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		System.out.println("sa="+sa);
		sa.setName("aaa");
		sa.setSex("man");
		sa.setAge(30);
		sa.init();
		sa.print();
		
		Sawon sa1=(Sawon)app.getBean("sa");
		System.out.println("sa1="+sa1);
		sa1.setName("ccc");
		sa1.setSex("woman");
		sa1.setAge(30);
		sa1.init();
		sa1.print();
		
		sa.init();
		sa.print();
	}

}





