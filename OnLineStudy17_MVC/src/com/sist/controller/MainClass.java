package com.sist.controller;
import java.lang.reflect.Method;
import java.util.*;
class A
{
	@RequestMapping("aaa.do")
	// 중복할 수 없다 ==> 어노테이션 => if문을 추가하는 것이다 
	public void aaa()
	{
		System.out.println("A:aaa() Call...");
	}
	@RequestMapping("bbb.do")
	public void bbb()
	{
		System.out.println("A:bbb() Call...");
	}
	@RequestMapping("ccc.do")
	public void ccc()
	{
		System.out.println("A:ccc() Call...");
	}
	@RequestMapping("ddd.do")
	public void ddd()
	{
		System.out.println("A:ddd() Call...");
	}
}
// aaa.do  ==> aaa() , bbb.do ==> bbb() ccc.do ==> ccc()
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("사이트주소 입력:");// getRequestURI()
        String cmd=scan.next();
        
		/*
		 * A a=new A(); if(cmd.equals("aaa.do")) { a.aaa(); } else
		 * if(cmd.equals("bbb.do")) { a.bbb(); } else if(cmd.equals("ccc.do")) {
		 * a.ccc(); }
		 */
        try
        {
        	// 클래스의 모든 정보를 읽어 온다 
        	Class clsName=Class.forName("com.sist.controller.A");
        	// 메모리 할당 
        	Object obj=clsName.newInstance();
        	// A클래스가 가지고 있는 모든 메소드를 읽어 온다 
        	Method[] methods=clsName.getDeclaredMethods();
        	for(Method m:methods)
        	{
        		// System.out.println(m.getName());// A클래스에 선언되어 있는 메소드이름을 가지고 온다
        		// Method위에 있는 Annotation를 읽는다 
        		// 어노테이션을 프로그래머가 만드는 일은 거의 없다
        		RequestMapping rm=m.getAnnotation(RequestMapping.class);
        		// 어노테이션을 읽어오는 방법 
        		if(cmd.equals(rm.value()))
        		{
        			m.invoke(obj, null);// 메소드 이름을 몰라도 찾을 수 있다 
        			// invoke ==> 해당 메소드를 호출 과정 
        			// a.aaa()
        			// 메소드 호출 (obj(A클래스)가 가지고 있는 메소드를 호출한다)
        			// null ==> 매개변수
        		}
        	}
        }catch(Exception ex) {}
	}

}



