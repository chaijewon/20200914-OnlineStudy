package com.sist.vo;
/*
 *   TNO   NOT NULL NUMBER        
TNAME NOT NULL VARCHAR2(100) 
TLOC  NOT NULL VARCHAR2(100)
 */
public class TheaterVO {
    private int tno;
    private String tname;
    private String tloc;
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTloc() {
		return tloc;
	}
	public void setTloc(String tloc) {
		this.tloc = tloc;
	}
  
}
