package com.sist.dao;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;
public class BoardVO {
   private int no;
   private String name;
   private String subject;
   private String content;
   private String pwd;
   private Date regdate;
   private int hit;
   private String filename;
   private String filesize;
   private int filecount;
   private List<MultipartFile> files;
   
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getFilesize() {
	return filesize;
}
public void setFilesize(String filesize) {
	this.filesize = filesize;
}
public int getFilecount() {
	return filecount;
}
public void setFilecount(int filecount) {
	this.filecount = filecount;
}
public List<MultipartFile> getFiles() {
	return files;
}
public void setFiles(List<MultipartFile> files) {
	this.files = files;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public int getHit() {
	return hit;
}
public void setHit(int hit) {
	this.hit = hit;
}
   
}
