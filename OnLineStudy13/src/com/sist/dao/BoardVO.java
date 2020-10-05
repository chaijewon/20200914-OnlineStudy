package com.sist.dao;
/*
 *   NO      NOT NULL NUMBER         
	 NAME    NOT NULL VARCHAR2(34)   
	 EMAIL            VARCHAR2(200)  
	 SUBJECT NOT NULL VARCHAR2(4000) 
	 CONTENT NOT NULL CLOB           
	 PWD     NOT NULL VARCHAR2(10)   
	 REGDATE          DATE           
	 HIT              NUMBER 
 */
import java.util.*;
public class BoardVO {
    private int no;
    private String name;
    private String email;
    private String content;
    private String pwd;
    private Date regdate;
    private int hit;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	  
}
