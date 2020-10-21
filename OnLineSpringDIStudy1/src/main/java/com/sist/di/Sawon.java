package com.sist.di;
/*
 *    메모리 할당 
 *    setXxx()에 값 채운다 
 *    init()
 *    print()
 */
public class Sawon {
   private String name;
   private String sex;
   private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void init()
	{
		System.out.println("===== 사원 정보 =====");
	}
	
	public void print()
	{
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
		System.out.println("나이:"+age);
	}
	   
}
