package com.sist.di3;

public class Member {
    private String name,addr,tel;

	public Member(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	
	public void print()
	{
		System.out.println("이름:"+name);
		System.out.println("주소:"+addr);
		System.out.println("전화:"+tel);
	}
   
}
