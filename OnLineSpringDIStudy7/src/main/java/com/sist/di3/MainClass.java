package com.sist.di3;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/*
 *    TYPE : 클래스 위에
 *    METHOD : 메소드 위에 
 *    FIELD : 멤버 변수
 *    CONSTRUCTOR : 생성자 위에
 *    PARAMETER : 매개변수 옆에
 */
@Component("mc")
public class MainClass {
	// FIELD, METHOD, TYPE
	@Resource(name="sa")
    private Sawon sa;
	
	@Resource(name="mem")
    private Member mem;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=new ClassPathXmlApplicationContext("app3.xml");
        MainClass mc=(MainClass)app.getBean("mc");
        //MainClass mc=new MainClass();
        mc.sa.print();
        mc.mem.print();
	}

}
