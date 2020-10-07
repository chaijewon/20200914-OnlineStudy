package com.sist.dao;
/*
 *  NO     NOT NULL NUMBER         
	TITLE  NOT NULL VARCHAR2(1000) 
	POSTER NOT NULL VARCHAR2(200)  
	CHEF   NOT NULL VARCHAR2(100)  
	LINK   NOT NULL VARCHAR2(200) 
 */
public class RecipeVO {
    private int no;
    private String title;
    private String poster;
    private String chef;
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
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
   
}
