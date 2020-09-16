package com.sist.xml;
/*
 *    태그안에 태그가 있으면 => 클래스 제작
 *    태그안에 문자열 값 => 변수 제작 
 *    자바 XML => 연결이 가능 
 */
public class Item {
    private String title;
    private String description;
    private String author;
    private String link;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	   
}
