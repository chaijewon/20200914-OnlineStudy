package com.sist.xml;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.net.*;
/*
 *   거의 없다 : 파싱하는 내용 
 *   => XML (MyBatis) => XML을 어떻게 읽어 갔는지 
 *      오픈 API => XML => 파싱 => 데이터만 넘겨준다 
 *      JAXP : 파싱 (태그를 한개씩 읽어서 데이터 추출)
 *             읽기전용 (O) SAX파싱=>대부분 API에서 사용하는 방법 , 읽기전용(X) : DOM파싱
 *      JAXB : 연결 (자바클래스)
 *      
 *      =====> XML이 사라지고 있다 ==> XML을 대체하는 프로그램 (Annotation)
 *      =====> MVC =====> Spring =====> 지능형웹  ==> 가상 메모리 (Vue,React)
 *                                                              ======= React Native
 *                                                              안드로이드,아이폰 
 *      
 */
public class NewsManager {
   public List<Item> naverNewsData(String fd)
   {
	   List<Item> list=new ArrayList<Item>();
	   try
	   {
		   String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
				        +URLEncoder.encode(fd, "UTF-8");
		   URL url=new URL(strUrl);
		   // 네이버에 연결 ==> 한글을 반드시 인코딩 URLEncoder.encode(fd, "UTF-8");
		   JAXBContext jb=JAXBContext.newInstance(Rss.class);
		   Unmarshaller un=jb.createUnmarshaller();
		   Rss rss=(Rss)un.unmarshal(url);// 데이터를 읽으면 => Rss클래스에 값을 채워라 
		   /*
		    *   Rss => Channel => Item
		    */
		   list=rss.getChannel().getItem();
	   }catch(Exception ex) {}
	   return list;
   }
   public static void main(String[] args) {
	  NewsManager m=new NewsManager();
	  List<Item> list=m.naverNewsData("영화");
	  for(Item i:list)
	  {
		  System.out.println(i.getTitle());
		  System.out.println(i.getDescription());
		  System.out.println(i.getAuthor());
		  System.out.println("===================================================");
	  }
   }
}







