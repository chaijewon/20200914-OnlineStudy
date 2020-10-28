package com.sist.vo;
/*
 *  NO        NOT NULL NUMBER        
ID        NOT NULL VARCHAR2(20)  
MNO                NUMBER        
THEATER            VARCHAR2(100) 
TIME               VARCHAR2(20)  
INWON              VARCHAR2(20)  
PRICE              VARCHAR2(10)  
ISRESERVE          CHAR(1)  
 */
import java.util.*;
public class ReserveVO {
    private int no;
    private String id;
    private int mno;
    private String theater;
    private String time;
    private String inwon;
    private String price;
    private String isreserve;
    private Date regdate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getInwon() {
		return inwon;
	}
	public void setInwon(String inwon) {
		this.inwon = inwon;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIsreserve() {
		return isreserve;
	}
	public void setIsreserve(String isreserve) {
		this.isreserve = isreserve;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
  
}
