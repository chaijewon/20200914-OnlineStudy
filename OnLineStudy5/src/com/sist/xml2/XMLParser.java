package com.sist.xml2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/*
 *      <?xml version="1.0" encoding="UTF-8"?> startDocument() 메소드 자동 호출 
		<sawon_list>  태그 시작 (startElement()) 
		  startElement()                           endElement()
		  <sawon sabun="1" name="홍길동" dept="개발부"/>
		  startElement()                           endElement()
		  <sawon sabun="2" name="박문수" dept="총무부"/>
		  startElement()                           endElement()
		  <sawon sabun="3" name="심청이" dept="기획부"/>
		  startElement()                           endElement()
		  <sawon sabun="4" name="춘향이" dept="자재부"/>
		  startElement()                           endElement()
		  <sawon sabun="5" name="이순신" dept="영업부"/>
		  startElement()                           endElement()
		</sawon_list> endElement()
		endDocuement() ==> 문서 종료

 */
public class XMLParser extends DefaultHandler{

	@Override
	public void startElement(String uri, String localName, 
			String qName, 
			Attributes attributes) throws SAXException {
		System.out.println(qName+"을 읽기 시작"); // qName : 태그명
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("XML문서가 시작!!");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("XML 문서 읽기 종료!!");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		 System.out.println(qName+"태그 읽기 종료");
	}
	
   
}
