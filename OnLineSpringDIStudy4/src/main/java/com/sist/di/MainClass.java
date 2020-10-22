package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 *   DI
 *   DL
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] xml={"app1.xml","app2.xml"};
        ApplicationContext app=
        		new ClassPathXmlApplicationContext(xml);
        // new ClassPathXmlApplicationContext({"app1.xml","app2.xml"});
        Sawon sa=(Sawon)app.getBean("sa");// Object => 반드시 형변환
        // DL => id명을 가지고 클래스를 찾아주는 기능
        System.out.println("이름:"+sa.getName());
        System.out.println("부서:"+sa.getDept());
        System.out.println("직위:"+sa.getJob());
        Member mem=app.getBean("mem",Member.class);// 데이터형을 통일 (제네릭스)
        // List<String>
        System.out.println("이름:"+mem.getName());
        System.out.println("주소:"+mem.getAddr());
        System.out.println("전화:"+mem.getTel());
	}

}





