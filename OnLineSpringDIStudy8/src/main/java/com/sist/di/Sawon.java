package com.sist.di;

import org.springframework.stereotype.Component;

@Component("sa")
public class Sawon {
    private String name="심청이";  
    private String sex="여자";
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
  
}
