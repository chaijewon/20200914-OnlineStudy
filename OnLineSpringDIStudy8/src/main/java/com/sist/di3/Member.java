package com.sist.di3;

import org.springframework.stereotype.Component;

@Component
public class Member {
    private String name="ȫ�浿";
    private String tel="010-1111-1111";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
  
}
