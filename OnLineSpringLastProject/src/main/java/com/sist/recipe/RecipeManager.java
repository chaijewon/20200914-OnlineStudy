package com.sist.recipe;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
/*
 *     데이터 저장 ==> 데이터베이스 
 *     ========
 *     변수,배열,클래스,파일(사용이 불편) ==> RDBMS(오라클)(SQL) => XML => 몽고디비
 *     ============
 *        메모리  => SELECT , INSERT , UPDATE , DELETE
 *                =======
 *                 JOIN , SUBQUERY => 메소드 (PL/SQL) => 
 *                 
 *             class A
 *             {
 *                 int a=10;
 *                 a=20;
 *             }
 */
public class RecipeManager {
	
    private static ArrayList<RecipeVO> recipeList
                     =new ArrayList<RecipeVO>();
    // 초기값 
    static
    {
    	try
    	{
    		FileInputStream fis=
    				new FileInputStream("c:\\project_data\\recipe.txt");
    		ObjectInputStream ois=
    				new ObjectInputStream(fis);
    		recipeList=(ArrayList<RecipeVO>)ois.readObject();
    		ois.close();
    	}catch(Exception e){System.out.println(e.getMessage());}
    }
    // 페이지별로 전송 (목록)
    public ArrayList<RecipeVO> recipeListData(int page)
    {
    	ArrayList<RecipeVO> list=
    			new ArrayList<RecipeVO>();
    	int rowSize=12;
    	int pagecnt=(page*rowSize)-rowSize;
    	// 0 -> 10  10 -> 20  20->23
    	int end=pagecnt+rowSize;
    	int total=recipeTotalPage();
    	if(page==total && recipeList.size()%rowSize>0)
    	{
    		end=pagecnt+recipeList.size()%rowSize;
    	}
    	System.out.println(recipeList.size());
    	for(int i=pagecnt;i<end;i++)
    	{
    		list.add(recipeList.get(i));
    	}
    	/*
    	 *   0~11
    	 *   12
    	 *   
    	 *   for(int i=pagecnt;i<pagecnt+rowSize;i++)
    	 *   {
    	 *      list.add(recipeList.get(i));
    	 *   }
    	 */
		/*
		 * for(int i=0;i<recipeList.size();i++) { if(j<12 && i>=pagecnt) {
		 * list.add(recipeList.get(i)); j++; } }
		 */
    	return list;
    }
    // 상세보기 
    public RecipeDetailVO recipeDetailData(String url)
    {
    	RecipeDetailVO vo=new RecipeDetailVO();
    	// http://www.10000recipe.com/recipe/6907454
    	try
    	{
    		Document doc=Jsoup.connect("http://www.10000recipe.com"+url).get();
    		Element poster=doc.selectFirst("div.centeredcrop img");// doc.select("").get(0)
    		/*
    		 *  <div class="view2_summary">
            <h3>초간단, 초스피드, 스팸으로 재미난 밥전 만들기</h3>
    		 */
    		Element title=doc.selectFirst("div.view2_summary h3");
    		Element chef=doc.selectFirst("div.profile_cont p.cont_name");
    		Element chef_poster=doc.selectFirst("div.profile_pic img");
    		Element chef_profile=doc.selectFirst("div.profile_cont p.cont_intro");
    		Element content=doc.selectFirst("div.view2_summary_in");
    		Elements foodmake=doc.select("div.view_step_cont");
    		Element info1=doc.selectFirst("span.view2_summary_info1");
    		Element info2=doc.selectFirst("span.view2_summary_info2");
    		Element info3=doc.selectFirst("span.view2_summary_info3");
    		
    		String food="";
    		for(int i=0;i<foodmake.size();i++)
    		{
    			food+=(i+1)+"."+foodmake.get(i).text()+"\n";
    		}
    		vo.setPoster(poster.attr("src"));
    		vo.setChef(chef.text());
    		vo.setChef_poster(chef_poster.attr("src"));
    		vo.setChef_profile(chef_profile.text());
    		vo.setContent(content.text());
    		vo.setFoodmake(food);
    		vo.setTitle(title.text());
    		vo.setInfo1(info1.text());
    		vo.setInfo2(info2.text());
    		vo.setInfo3(info3.text());
    		
    		System.out.println("제목:"+vo.getTitle());
    		System.out.println("쉐프:"+vo.getChef());
    		System.out.println("내용:"+vo.getContent());
    		System.out.println("조리방법:"+vo.getFoodmake());
    		System.out.println("정보1:"+vo.getInfo1());
    		System.out.println("정보2:"+vo.getInfo2());
    		System.out.println("정보3:"+vo.getInfo3());
    		
    	}catch(Exception ex){}
    	return vo;
    }
    // 총페이지
    public int recipeTotalPage()
    {
    	return (int)(Math.ceil(recipeList.size()/12.0));
    }
    // 찾기 
    public ArrayList<RecipeVO> chefMakeFoodList(String chef,int page)
    {
    	ArrayList<RecipeVO> list=
    			new ArrayList<RecipeVO>();
    	ArrayList<RecipeVO> temp=
    			new ArrayList<RecipeVO>();
    	
    	for(RecipeVO vo:recipeList)
    	{
    		System.out.println("123:"+vo.getChef());
    		if(vo.getChef().contains(chef))
    		{
    			
    			temp.add(vo);
    		}
    	}
    	int j=0;
    	System.out.println("page:"+temp.size());
    	int pagecnt=(page*12)-12;
    	for(int i=0;i<temp.size();i++)
    	{
    		if(j<12 && i>=pagecnt)
    		{
    			list.add(temp.get(i));
    			j++;
    		}
    	}
    	return list;
    }
    public int chefMakeFoodTotalPage(String chef)
    {
    	// SELECT CEIL(COUNT(*)/10) FROM recipe
    	// WHERE num BETWEEN 1 AND 10
    	int total=0;
    	ArrayList<RecipeVO> temp=
    			new ArrayList<RecipeVO>();
    	
    	for(RecipeVO vo:recipeList)
    	{
    		if(vo.getChef().contains(chef))
    		{
    			
    			temp.add(vo);
    		}
    	}
    	total=(int)(Math.ceil(temp.size()/12.0));
    	return total;
    }
    
    public ArrayList<RecipeVO> recipeFindData(String fs,String ss)
    {
    	ArrayList<RecipeVO> list=
    			new ArrayList<RecipeVO>();
    	if(fs.equals("제목"))
    	{
    		for(RecipeVO vo:recipeList)
    		{
    			if(vo.getTitle().contains(ss))
    			{
    				list.add(vo);
    			}
    		}
    	}
    	else
    	{
    		for(RecipeVO vo:recipeList)
    		{
    			if(vo.getChef().contains(ss))
    			{
    				list.add(vo);
    			}
    		}
    	}
    	return list;
    }
    
    public ArrayList<RecipeVO> recipeRecommandData(String ss)
    {
    	ArrayList<RecipeVO> list=
    			new ArrayList<RecipeVO>();
    	int i=0;
    	for(RecipeVO vo:recipeList)
    		{
    			if(vo.getTitle().contains(ss))
    			{
    				list.add(vo);
    				if(i>10) break;
    				i++;
    			}
    			
    		}
    	
    	return list;
    }
    public RecipeVO recipeInfoData(String title)
    {
    	RecipeVO list=
    			new RecipeVO();
    	for(RecipeVO vo:recipeList)
    		{
    			if(vo.getTitle().equals(title))
    			{
    				list=vo;
    				break;
    			}
    			
    		}
    	
    	return list;
    }
}









