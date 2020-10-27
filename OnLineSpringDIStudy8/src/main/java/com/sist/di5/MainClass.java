package com.sist.di5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    /*
     *   GenericXmlApplicationContext => XML파싱
     *   GenericApplicationContext => XML파싱기능이 없다 (어노테이션 용도)
     *   
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext app
		     =new GenericXmlApplicationContext("app.xml");
        /*ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml")*/;
        Sawon sa1=(Sawon)app.getBean("sa");
        // 사용범위 (Scope) => 싱글턴 , ProtoType
        Sawon sa2=(Sawon)app.getBean("sa");
        System.out.println("sa1:"+sa1);
        System.out.println("sa2:"+sa2);
        sa1.print();
        app.close();
        
	}

}
