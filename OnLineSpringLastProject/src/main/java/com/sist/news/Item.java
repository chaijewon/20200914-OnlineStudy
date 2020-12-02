package com.sist.news;
/*
 *  <title>뜨는 배달 창업아이템 '도쿄라멘3900', 분식집창업과 공유주방 가능해 수익성 높여</title>
<link>http://www.epnc.co.kr/news/articleView.html?idxno=109645</link>
<description>
<![CDATA[ 오픈 후에는 본사의 30분 교육과 정량화된 레시피, HACCP 인증을 받은 비법 육수/소스를 가맹점에 공급하는 원-팩 시스템 등을 통해 전문 조리 인력 없이 안정적인 운영이 가능하다. 이에 소규모창업을 고려 중이던 예비... ]]>
</description>
<pubDate>Thu, 26 Nov 2020 14:30:00 +0900</pubDate>
<author>테크월드</author>

 */
public class Item {
    private String title;
    private String link;
    private String description;
    private String pubDate;
    private String author;
    private String day;
    
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
   
}
