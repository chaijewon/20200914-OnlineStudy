package com.sist.data;
/*
 *   NO     NOT NULL NUMBER         
CATENO          NUMBER         
POSTER NOT NULL VARCHAR2(1000) 
TITLE  NOT NULL VARCHAR2(200)  
SCORE  NOT NULL VARCHAR2(5)    
ADDR   NOT NULL VARCHAR2(200)  
TEL    NOT NULL VARCHAR2(15)   
TYPE   NOT NULL VARCHAR2(200)  
PRICE           VARCHAR2(100)  
MENU            VARCHAR2(500)  
GOOD            NUMBER         
SOSO            NUMBER         
BAD             NUMBER      
 */
public class FoodVO {
   private int no;
   private int cateno;
   private String poster;
   private String title;
   private String score;
   private String addr;
   private String tel;
   private String type;
   private String price;
   private String menu;
   private int good;
   private int soso;
   private int bad;
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
public String getPoster() {
	return poster;
}
public void setPoster(String poster) {
	this.poster = poster;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getMenu() {
	return menu;
}
public void setMenu(String menu) {
	this.menu = menu;
}
public int getGood() {
	return good;
}
public void setGood(int good) {
	this.good = good;
}
public int getSoso() {
	return soso;
}
public void setSoso(int soso) {
	this.soso = soso;
}
public int getBad() {
	return bad;
}
public void setBad(int bad) {
	this.bad = bad;
}
   
}
