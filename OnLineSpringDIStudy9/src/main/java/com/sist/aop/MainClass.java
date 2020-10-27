package com.sist.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MyDAO dao=(MyDAO)app.getBean("myDAO");
        /*dao.select("ȫ�浿");
        dao.insert();
        dao.update();*/
        dao.db_insert();
        dao.db_select("");
        dao.db_update();
        dao.print();
	}

}
