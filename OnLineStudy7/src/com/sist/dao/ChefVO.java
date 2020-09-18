package com.sist.dao;
/*
 *   1. MyBatis => 반드시 (변수=컬럼명) => 불일치시에는 값을 받지 못한다 
 *      => 받는 방법 => XML코드에서 매칭 
 *         <result property="image" column="poster">
 */
public class ChefVO {
    private String poster;
    private String chef;
    private String mem_cont1;
    private String mem_cont3;
    private String mem_cont7;
    private String mem_cont2;
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
	}
	public String getMem_cont1() {
		return mem_cont1;
	}
	public void setMem_cont1(String mem_cont1) {
		this.mem_cont1 = mem_cont1;
	}
	public String getMem_cont3() {
		return mem_cont3;
	}
	public void setMem_cont3(String mem_cont3) {
		this.mem_cont3 = mem_cont3;
	}
	public String getMem_cont7() {
		return mem_cont7;
	}
	public void setMem_cont7(String mem_cont7) {
		this.mem_cont7 = mem_cont7;
	}
	public String getMem_cont2() {
		return mem_cont2;
	}
	public void setMem_cont2(String mem_cont2) {
		this.mem_cont2 = mem_cont2;
	}
  
  
}
