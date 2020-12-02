package com.sist.naver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONExample {
   
   public static void main(String[] args) {
	   String json="{\"sawon\":[{\"name\":\"홍길동\",\"sex\":\"남자\",\"age\":30},"
			      +"{\"name\":\"심청이\",\"sex\":\"여자\",\"age\":20},"
			      +"{\"name\":\"박문수\",\"sex\":\"남자\",\"age\":40}]}";
	   try
	   {
		   JSONParser jp=new JSONParser();
		   JSONObject root=(JSONObject)jp.parse(json);
		   JSONArray arr=(JSONArray)root.get("sawon");
		   for(int i=0;i<arr.size();i++)
		   {
			   JSONObject obj=(JSONObject)arr.get(i);
			   System.out.println(obj.get("name"));
			   System.out.println(obj.get("sex"));
			   System.out.println(obj.get("age"));
			   System.out.println("============");
		   }
	   }catch(Exception ex){}
	   /*try
	   {
		   JSONParser jp=new JSONParser();
		   JSONArray arr=(JSONArray)jp.parse(json);
		   for(int i=0;i<arr.size();i++)
		   {
			   JSONObject obj=(JSONObject)arr.get(i);
			   System.out.println(obj.get("name"));
			   System.out.println(obj.get("sex"));
			   System.out.println(obj.get("age"));
			   System.out.println("============");
		   }
	   }catch(Exception ex){}*/
	   /*try
	   {
		   JSONParser jp=new JSONParser();
		   JSONObject info=(JSONObject)jp.parse(json);
		   System.out.println(info.toJSONString());
		   
		   System.out.println(info.get("name"));
		   System.out.println(info.get("sex"));
		   System.out.println(info.get("age"));
	   }catch(Exception ex){System.out.println(ex.getMessage());}*/
	   
   }
}




