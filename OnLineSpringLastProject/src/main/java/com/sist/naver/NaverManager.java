package com.sist.naver;

import java.io.File;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.util.*;
/*
 *    {
 *       "lastBuildDate": "Tue, 24 Nov 2020 14:36:40 +0900",
 *       "total": 1507,
 *       "start": 1,
 *       "display": 100,
 *       "items": [
 *                   {"title": "제주여행코스 / 제주석양스팟 오조포구 / 성산맛집 <b>남양수산</b>",
 *                   "link": "https:\/\/blog.naver.com\/attifelt?Redirect=Log&logNo=222148955743",
 *                   "description": "제주여행코스 / 제주석양스팟 오조포구 / 성산맛집 <b>남양수산</b> #제주도여행코스 #제주여행 #제주석양스팟 #제주뚜벅이여행 #제주동부여행코스 #제주오조포구 #제주사진찍기좋은곳 #제주맛집 #성산맛집<b>남양수산</b>... ","bloggername": "아티아티크. Attiattique","bloggerlink": "https://blog.naver.com/attifelt","postdate": "20201119"},{"title": "[제주] <b>남양수산</b> : 참돔회&amp;지리탕 린다G / 포장&amp;식당에서 먹은... ","link": "https:\/\/blog.naver.com\/cedargrove?Redirect=Log&logNo=222128786189","description": "추천하는 곳은 제주 성산에 위치한 <b>남양수산</b>!  제주 서귀포시 성산읍 고성동서로56번길 11  매일 14:00 - 20... 택시탔어요 <b>남양수산</b>은 회 포장 가능한 곳이고 출입문 옆에 수족관 안 물고기가 헤엄치는 모습을 볼... ","bloggername": "블라블라✿*","bloggerlink": "https://blog.naver.com/cedargrove","postdate": "20201028"},{"title": "[제주/성산] <b>남양수산</b> :: 인생 참돔회 제주도민 추천 횟집","link": "https:\/\/blog.naver.com\/jooeungen?Redirect=Log&logNo=222109447949","description": "<b>남양수산</b> 주소: 제주특별자치도 서귀포시 성산읍 고성동서로56번길 11 / (지번) 성산읍 고성리 1191-6... 고등어는 근처에 #성산수산 을 추천합니다. 회도 넘 많이먹음 질린다구여! 역시 탄수화물이 있어줘야... ","bloggername": "DUNDIN STUDIO","bloggerlink": "https://blog.naver.com/jooeungen",
 */
@Component
public class NaverManager {
   public void naverData(String fd) {
	   ApiExamSearchBlog api=
			   new ApiExamSearchBlog();
	   String json=api.naverFindData(fd);
	   System.out.println(json);
	   try
	   {
		   JSONParser jp=new JSONParser();
		   // {} []
		   JSONObject root=(JSONObject)jp.parse(json);
		   JSONArray arr=(JSONArray)root.get("items");
		   String result="";
		   for(int i=0;i<arr.size();i++)
		   {
			   JSONObject obj=(JSONObject)arr.get(i);
			   System.out.println(obj.get("description"));
			   result+=obj.get("description")+"\r\n";
		   }
		   result=result.replace("<", "");
		   result=result.replace(">", "");
		   result=result.replace("/", "");
		   result=result.replace("#", "");
		   result=result.replace(".", "");
		   result=result.replaceAll("[0-9]", "");
		   result=result.replaceAll("[A-Za-z]", "");
		   
		   FileWriter fw=new FileWriter("c:\\upload\\naver.txt");
		   fw.write(result);
		   fw.close();
	   }catch(Exception ex){}
	   /*try
	   {
		   JAXBContext jb=JAXBContext.newInstance(Rss.class);
		   Unmarshaller un=jb.createUnmarshaller();
		   Rss rss=(Rss)un.unmarshal(new File("c:\\upload\\naver.xml"));
		   List<Item> list=rss.getChannel().getItem();
		   for(Item i:list)
		   {
			   String s=i.getDescription();
			   s=s.replace("<", "");
			   s=s.replace(">", "");
			   s=s.replace(";", "");
			   s=s.replace("#", "");
			   s=s.replace("/", "");
			   s=s.replaceAll("[0-9]", "");
			   s=s.replaceAll("[A-Za-z]", "");
			   System.out.println(s);
		   }
	   }catch(Exception ex){}*/
   }
}
