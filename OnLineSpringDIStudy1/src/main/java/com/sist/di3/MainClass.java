package com.sist.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// List<String>
/*
 *    T=> TYPE ==> 임시 변수  A<String>
 *    class A<T>
 *    {
 *        String t;
 *        public String getT()
 *        {
 *           return T;
 *        }
 *        public void setT(T t)
 *        {
 *           this.t=t;
 *        }
 *    }
 *    
 *     int count=session.selectOne("")
 *     BoardVO vo=session.selectOne("")
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app1.xml");
        //          ========= C:\springDev\springStudy\OnLineSpringDIStudy1\src\main\java
        MemberList ml=(MemberList)app.getBean("ml");// 제네릭스
        // app.getBean("ml",MemberList.class);
        ml.print();
        
	}

}
