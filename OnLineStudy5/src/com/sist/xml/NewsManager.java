package com.sist.xml;
// XML에 있는 데이터를 채우는 프로그램 
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.net.*;//웹 서버에 데이터 전송시에 인코딩해서 전송 URLEncoder
public class NewsManager {
   public List<Item> newsAllData(String fd)
   {
	   List<Item> list=new ArrayList<Item>();
	   try
	   {
		   // 웹사이트 연결 
		   // where=rss(XML로 전송을 받는다)&query=(검색어=>사용자가 보내준) => 한글=>반드시 인코딩을 해서 보낸다
		   String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
				        +URLEncoder.encode(fd, "UTF-8");
		  // 연결
		   URL url=new URL(strUrl);
		   // Rss.class ==> @XMLRootElement가 설정되어 있는 클래스를 설정
		   JAXBContext jb=JAXBContext.newInstance(Rss.class);
		   // 파싱 데이터를 읽어서 => 자바 클래스에 값을 설정 요청 
		   Unmarshaller un=jb.createUnmarshaller();
		   Rss rss=(Rss)un.unmarshal(url);
		   // 데이터 전체 수집 
		   list=rss.getChannel().getItem();
		   // 데이터 수집해서 검색어별로 모아주는 과정 종료 
	   }catch(Exception ex){}
	   return list;
   }
   public static void main(String[] args) {
	  NewsManager m=new NewsManager();
	  List<Item> list=m.newsAllData("맛집");
	  for(Item i:list)
	  {
		  System.out.println(i.getTitle());
		  System.out.println(i.getDescription());
		  System.out.println(i.getAuthor());
		  System.out.println("=========================================");
	  }
   }
}




