package com.sist.xml2;
import java.io.*;
import javax.xml.parsers.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.w3c.dom.*;
// DOM 
/*
 *   메모리에 저장되는 방식 
 *   = list방식 => 일반 변수,클래스 => list방식
 *   = tree방식 (DOM) ==> ML (HTML,XML)
 *     WML , HDML , VML
 *     
 *     DOM (Document Object Model)
 *     SAX (Simple API FOR XML) 
 */
public class DOMManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			// 한번만 생성 ==> 싱글턴 ==> newInstance() 
			// DOM 파서기를 생성해주는 역할 
			DocumentBuilder db=dbf.newDocumentBuilder();
			// 파서기 => XML을 읽어서 트리형태로 저장을 해주는 역할 
			// 1. XML을 번역 => 메모리에 저장 
			// 저장하는 공간 이름 => Document
			Document doc=db.parse(new File("C:\\Users\\채제분\\git\\online\\OnLineStudy5\\src\\com\\sist\\xml2\\sawon.xml"));
		    // 2. 최상위 태그 (테이블)
			Element root=doc.getDocumentElement();
			System.out.println(root.getTagName());//sawon
			// 같은 태그를 묶어서 반복문으로 처리
			NodeList list=root.getElementsByTagName("list");
			// 묶인 <list> 태그 갯수 확인 
			System.out.println(list.getLength());
			/*
			 *    <list> <!-- Record , Row -->
				    <sabun>1</sabun> <!-- 컬럼명 -->
				    <name>홍길동</name>
				    <dept>개발부</dept>
				    <job>사원</job>
				    <sal>3000</sal>
				  </list>
			 */
			// 없는 태그명 , 속성을 이용하면 => error
			// MyBatis => 태그 ,속성 => 제공하는 XML태그,속성 
			/*
			 *    Reader reader=Resources.getResourceAsReader("config.xml");
		          sf=new SqlSessionFactoryBuilder().build(reader);
		          //  build
		           * 
		           * XML을 왜 사용하는지
		                    일반 txt파일 => 구분을 할 수 없다
		                    구분되는 파일 이용 : XML,JSON 
		           XML => 포맷 (운영체제마다 동일하다)
		           => 모든 프레임워크(Spring,struts,MyBatis,IBatis,Hibernate)
		           => Spring + MyBatis 
		           => Struts + Hibernate
			 */
			for(int i=0;i<list.getLength();i++)
			{
				list=root.getElementsByTagName("sabun");
				String sabun=list.item(i).getFirstChild().getNodeValue();
				list=root.getElementsByTagName("name");
				String name=list.item(i).getFirstChild().getNodeValue();
				list=root.getElementsByTagName("dept");
				String dept=list.item(i).getFirstChild().getNodeValue();
				list=root.getElementsByTagName("job");
				String job=list.item(i).getFirstChild().getNodeValue();
				list=root.getElementsByTagName("sal");
				String sal=list.item(i).getFirstChild().getNodeValue();
				
				System.out.println(sabun+" "+name+" "
						+dept+" "+job+" "+sal);
			}
		}catch(Exception ex) {}
	}

}





