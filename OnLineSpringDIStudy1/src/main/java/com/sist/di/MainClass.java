package com.sist.di;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//////////////////////////////////
		Sawon s=new Sawon();
		s.setName("홍길동");
		s.setSex("남자");
		s.setAge(20);
		// DI(의존성 주입) 
		s.init();
		//////////////////////////////////
		s.print();// 프로그래머가 호출 

	}

}
