package com.sist.vo;
/*
 * TITLE   NOT NULL VARCHAR2(1000) 
	POSTER  NOT NULL VARCHAR2(1000) 
	LINK    NOT NULL VARCHAR2(1000) 
	CONTENT NOT NULL CLOB           
	AUTHOR  NOT NULL VARCHAR2(1000)
 */
public class NewsVO {
    private String title;
    private String poster;
    private String link;
    private String content;
    private String author;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
   
}
