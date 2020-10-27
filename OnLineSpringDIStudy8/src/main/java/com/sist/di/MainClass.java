package com.sist.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("mc")
public class MainClass {
    @Autowired
	private Sawon sa;
    @Autowired
	private Member mem;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(AppConfig.class);
        // 132page
        MainClass mc=(MainClass)app.getBean("mc");
        System.out.println("====== 사원 정보 ======");
        System.out.println("이름:"+mc.sa.getName());
        System.out.println("성별:"+mc.sa.getSex());
        System.out.println("====== 회원 정보 ======");
        System.out.println("이름:"+mc.mem.getName());
        System.out.println("주소:"+mc.mem.getAddr());
        app.close();//GC
	}

}




