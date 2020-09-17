package com.sist.xml2;
import java.io.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class SAXManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// SAX파서기를 생성하는 클래스
        	SAXParserFactory spf=SAXParserFactory.newInstance();
        	// SAX 파서기 
        	SAXParser sp=spf.newSAXParser();
        	// 파일읽기 요청
        	XMLParser xp=new XMLParser();
        	sp.parse(new File("C:\\Users\\채제분\\git\\online\\OnLineStudy5\\src\\com\\sist\\xml2\\sawon2.xml"), xp);
        }catch(Exception ex) {}
	}

}
