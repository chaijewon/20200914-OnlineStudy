package com.sist.di2;
/*
 *    ~VO
 *    ~DTO
 *    ~Bean 
 *    =============> 데이터를 모아서 전송 (일반 데이터형)
 *    스프링에서 메모리 할당을 하지 않고 프로그래머가 필요시마다 메모리 할당을 한다
 */
public class MusicVO {
    private int mno;
    private String title;
    private String singer;
    private String album;
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
   
}
