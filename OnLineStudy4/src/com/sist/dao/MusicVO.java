package com.sist.dao;
/*
 *  1. XML 태그 제작 방법
 *  2. XML문법 
 *  3. 자바 파싱 (자바에서 XML의 데이터를 읽어온다)
 *     = DOM (데이터베이스 대체) : 수정,추가 ,삭제,검색
 *     = SAX : 검색 
 *     = JAXB : 자바클래스와 XML을 연결(빅데이터,외부 XML을 읽을 경우)
 */
// Mybatis => 변수명 = 컬럼명이 반드시 일치
// DESC 테이블명 
public class MusicVO {
    private int mno;
    private String title;
    private String singer;
    private String album;
    private String poster;
    private String state;
    private int idcrement;
    private String key;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
    
    
}
