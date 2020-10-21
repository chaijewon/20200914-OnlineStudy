package com.sist.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(ApplicationConfig.class);
        // 등록된 클래스를 관리 => 클래스가 필요시마다 app를 통해서 객체주소 얻어온다 
        // 객체 ~ 소멸 
        // 보안 (소스가 노출)
        // List<MovieVO>
        Sawon s1=app.getBean("sa",Sawon.class);
       //   (Sawon)app.getBean("sa")
        System.out.println("이름:"+s1.getName());
        System.out.println("주소:"+s1.getAddr());
        System.out.println("전화:"+s1.getTel());
        
        app.close();
        
	}

}




