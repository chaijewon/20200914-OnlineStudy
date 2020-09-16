package com.sist.xml;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.net.*;
public class NewsManager {
   public List<Item> naverNewsData(String fd)
   {
	   List<Item> list=new ArrayList<Item>();
	   try
	   {
		   String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
				        +URLEncoder.encode(fd, "UTF-8");
		   URL url=new URL(strUrl);
		   JAXBContext jb=JAXBContext.newInstance(Rss.class);
		   Unmarshaller un=jb.createUnmarshaller();
		   Rss rss=(Rss)un.unmarshal(url);
		   list=rss.getChannel().getItem();
	   }catch(Exception ex) {}
	   return list;
   }
   public static void main(String[] args) {
	  NewsManager m=new NewsManager();
	  List<Item> list=m.naverNewsData("¿µÈ­");
	  for(Item i:list)
	  {
		  System.out.println(i.getTitle());
	  }
   }
}







