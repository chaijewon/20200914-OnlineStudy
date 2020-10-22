package com.sist.di;
/*
 *   <bean id="s" class="Student" init-method="init" destory-method="destory"
 *     p:name="홍길동"  => setterDI
 *     p:kor=90
 *     p:eng=70
 *     p:math=80
 *   >
 *   
 *   동작
 *   1) Class.forName("Student") => 메모리 할당 
 *   2) setXxx()에 값을 채워준다 
 *   3) init-method=> 호출 
 *  ===========================================
 *  
 *  
 *   4) 프로그래머 선택 => 프로그래머
 *   
 *   
 *  ===========================================
 *   5) destory-method => 호출 
 *  ===========================================
 */
public class Student {
    private String name;
    private int kor;
    private int eng;
    private int math;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
   
}
