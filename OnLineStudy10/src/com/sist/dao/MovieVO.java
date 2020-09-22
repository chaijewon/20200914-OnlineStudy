package com.sist.dao;
/*
 *     ==> jsp:include
 *      NO       NOT NULL NUMBER        
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
		
		
		==> JSP     ===> 새로운 데이터형 만들기 (여러개 데이터를 모아서 관리) : ~Bean
		    MyBatis ===> 데이터를 모아서(데이터베이스) 전송을 목적 : ~DTO
		    Spring  ===> 값을 저장하는 클래스 : ~VO
		    
		    Bean , DTO , VO ==> 동일 이름
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
    private String key;// 동영상 
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






