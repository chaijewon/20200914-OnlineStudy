package com.sist.dao;
/*
 *      POSTER    NOT NULL VARCHAR2(260) 
		CHEF      NOT NULL VARCHAR2(100) 
		MEM_CONT1          VARCHAR2(20)  
		MEM_CONT3          VARCHAR2(20)  
		MEM_CONT7          VARCHAR2(20)  
		MEM_CONT2          VARCHAR2(20) 
		
		SELECT poster as image,chef,....  image
		
		class ChefVO
		{
		   private String image;
		}
 */
public class ChefVO {
    private String poster;
    private String chef;
    private String mem_cont1;
    private String mem_cont2;
    private String mem_cont3;
    private String mem_cont7;
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
	public String getMem_cont2() {
		return mem_cont2;
	}
	public void setMem_cont2(String mem_cont2) {
		this.mem_cont2 = mem_cont2;
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
	
}
