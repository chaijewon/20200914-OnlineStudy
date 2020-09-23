package com.sist.dao;
import java.util.*;
// 한개의 게시물에 전체 대한 정보
/*
 *      오라클                자바 
 *    문자        =====> String
 *      CHAR
 *      VARCHAR2
 *      CLOB
 *    숫자        =====>  int , double
 *      NUMBER
 *      NUMBER(7,2)
 *    날짜        =====>  java.util.Date
 *      DATE
 *    기타        =====> InputStream (IO)
 *      BFILE 그림파일 ==> 권장(경로명만 주고 읽을 수 있게)
 *      BLOB
 *      
 *      
 *      NO       NOT NULL NUMBER         
		NAME     NOT NULL VARCHAR2(34)   
		SUBJECT  NOT NULL VARCHAR2(1000) 
		CONTENT  NOT NULL CLOB           
		PWD      NOT NULL VARCHAR2(10)   
		REGDATE           DATE           
		HIT               NUMBER         
		FILENAME          VARCHAR2(260)  
		FILESIZE          NUMBER         

 */
// 캡슐화 => 데이터를 은닉 => 외부연결시에 메소드(getter(읽기)/setter(쓰기) 이용하는 방식 
// 데이터 보호 목적 
/*
 *    상속/포함  => 재사용 
 *     상속 : 확장
 *     포함 : 있는 그대로 사용 
 *    추가,수정 (다형성)
 *     오버로딩 / 오버라이딩 
 *    ======================= 객체지향의 3대 특성 
 */
// ==> SQL문장을 저장한다 ==> mapper.xml
public class DataBoardVO {
    private int no;
    private String name;
    private String subject;
    private String content;
    private String pwd;
    private Date regdate;
    private int hit;
    private String filename;
    private int filesize;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	   
   
}






