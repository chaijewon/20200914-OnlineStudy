package com.sist.vo;
/*
 *   NO       NOT NULL NUMBER        
	CATENO            NUMBER        
	TITLE    NOT NULL VARCHAR2(200) 
	POSTER   NOT NULL VARCHAR2(300) 
	REGDATE           VARCHAR2(200) 
	GENRE    NOT NULL VARCHAR2(100) 
	GRADE    NOT NULL VARCHAR2(100) 
	ACTOR             VARCHAR2(100) 
	SCORE             VARCHAR2(20)  
	DIRECTOR NOT NULL VARCHAR2(100) 
	STORY             CLOB          
	KEY               VARCHAR2(50)  
 */
public class MovieVO {
    private int no;
    private int cateno;
    private String title;
    private String poster;
    private String regdate;
    private String genre;
    private String grade;
    private String actor;
    private String score;
    private String director;
    private String story;
    private String key;
    private String theater_no;
    private int jno;
    
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public String getTheater_no() {
		return theater_no;
	}
	public void setTheater_no(String theater_no) {
		this.theater_no = theater_no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCateno() {
		return cateno;
	}
	public void setCateno(int cateno) {
		this.cateno = cateno;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	   
}





