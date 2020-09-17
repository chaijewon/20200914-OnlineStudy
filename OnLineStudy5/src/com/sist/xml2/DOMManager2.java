package com.sist.xml2;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class DOMManager2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	// 파서기(XML의 데이터를 메모리에 저장(트리형태)를 생성
        	DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        	// 파서기 이용
        	DocumentBuilder db=dbf.newDocumentBuilder();
        	// XML을 읽어서 트리형태로 메모리에 저장 
        	Document doc=db.parse(new File("C:\\Users\\채제분\\git\\online\\OnLineStudy5\\src\\com\\sist\\xml2\\sawon2.xml"));
        	// 최상위 태그 => 테이블명
        	Element root=doc.getDocumentElement();
        	System.out.println(root.getTagName());
        	
        	// sawon태그를 묶어서 처리
        	NodeList list=root.getElementsByTagName("sawon");
        	System.out.println(list.getLength());
        	// for 
        	for(int i=0;i<list.getLength();i++)
        	{
        		//sawon태그를 한개씩 읽어 온다 
        		Element sawon=(Element)list.item(i);
        		String sabun=sawon.getAttribute("sabun");
        		String name=sawon.getAttribute("name");
        		String dept=sawon.getAttribute("dept");
        		System.out.println(sabun+" "+name+" "+dept);
        	}
        }catch(Exception ex) {}
	}

}





