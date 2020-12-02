package com.sist.dao;
/*
 *   NO      NOT NULL NUMBER         
TITLE   NOT NULL VARCHAR2(500)  
POSTER  NOT NULL VARCHAR2(1000) 
SUBJECT NOT NULL VARCHAR2(500)  
LINK             VARCHAR2(100)  
 */
public class FoodCategoryVO {
    private int no;
    private String title;
    private String poster;
    private String subject;
    private String link;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
    
}
