package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
/*
 *    12.2~12.4 => React,Hooks (Spring)
 *    ==================================
 *    12.7~12.11 => 코틀린 (레시피) , 챗봇
 *    12.14~12.17 => 코틀린(맛집) 
 *    ================================== 야간 Redux,=>(보안(블록체인),실시간 분석(Spark))
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class ReactController {
	@Autowired
	private RecipeDAO dao;
	@RequestMapping(value="react_chef/chef_list.do",produces="text/plain;charset=UTF-8")
	public String chef_list(String page)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<ChefVO> list=dao.chefListData(curpage);
		String json="";
		try
		{
			//[{},{},{},{}]
			/*
			 *   private String poster;
			     private String chef;
			     private String mc1;
			     private String mc3;
			     private String mc7;
			     private String mc2;
			 */
			JSONArray arr=new JSONArray();
			for(ChefVO vo:list)
			{
				JSONObject obj=new JSONObject();
				obj.put("poster", vo.getPoster());
				obj.put("chef", vo.getChef());
				obj.put("mc1", vo.getMc1());
				obj.put("mc3", vo.getMc3());
				obj.put("mc7", vo.getMc7());
				obj.put("mc2", vo.getMc2());
				
				arr.add(obj);
			}
			
			json=arr.toJSONString();
		}catch(Exception ex){}
		return json;
	}
	@RequestMapping("react_chef/totalpage.do")
	public String chef_total()
	{
		int total=0;
		try
		{
			total=dao.chefTotalPage();
		}catch(Exception ex){}
		return String.valueOf(total);
	}
	@RequestMapping(value="react_chef/chef_detail.do",produces="text/plain;charset=UTF-8")
	public String chef_detail(String chef,String page)
	{
		String result="";
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<RecipeVO> list=dao.chefProductData(chef, curpage);
		try
		{
			JSONArray arr=new JSONArray();
			//[{"poster":"",title:"",chef:""},{},{},{}]
			for(RecipeVO vo:list)
			{
				JSONObject obj=new JSONObject();
				obj.put("poster", vo.getPoster());
				obj.put("title", vo.getTitle());
				obj.put("chef", vo.getChef());
				arr.add(obj);
			}
			result=arr.toJSONString();
		}catch(Exception ex){}
		return result;
	}
	
}








