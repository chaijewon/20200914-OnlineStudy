package com.sist.dao;
/*
 *  NO      NOT NULL NUMBER         
	NAME    NOT NULL VARCHAR2(34)   
	SUBJECT NOT NULL VARCHAR2(1000) 
	CONTENT NOT NULL CLOB           
	PWD     NOT NULL VARCHAR2(10)   
	REGDATE          DATE           
	HIT              NUMBER  
	
	VO => 변수만 설정    (~Bean , ~DTO , ~VO) : 거의 같은 개념 
	      ===
	       = 읽기 (변수값 읽어 오기)  ======> 메소드  (getter)
	       = 쓰기 (변수값을 메모리에 저장) ===> 메소드 (setter) 
	================================================== JavaBean
	목적이 필요한 데이터를 여러개 모아서 브라우저에 볼 목적을 직접 제작 
 */
import java.util.*;//Date
// 게시물 한개에 대한 전체 정보 ==> 읽기/쓰기 
public class BoardVO {
    private int no;
    private String name;
    private String subject;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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





