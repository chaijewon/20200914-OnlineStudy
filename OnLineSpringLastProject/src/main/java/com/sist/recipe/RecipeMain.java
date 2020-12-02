package com.sist.recipe;
import java.io.*;
import java.net.URL;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 *  <div class="col-xs-4">
        <a class="thumbnail" href="/recipe/6907357">
			            <span class="thumbnail_over"><img src="http://recipe1.ezmember.co.kr/img/thumb_over.png"></span>
          <img src="http://recipe1.ezmember.co.kr/cache/recipe/2019/02/26/d7f2629195c05e84979b4b02af7f1a8c1_m.jpg" style="width:275px; height:275px;">
          <div class="caption">
            <h4 class="ellipsis_title2">���ڻ� �������� �ְ�</h4>
            <p>by �����޺�</p>
          </div>
        </a>
          <div style="position:absolute;top:365px;width:100%;text-align:right;right:20px;"><span style="color:#74b243;font-size:10px;" class="glyphicon glyphicon-certificate"></span></div>
    </div>

 */
public class RecipeMain {
	RecipeDAO dao=new RecipeDAO();
	public void recipeAllData()
	{
	     /*
	      *   <li class="common_sp_list_li">
                <div class="common_sp_thumb">
                    <a href="/recipe/19746" class="common_sp_link">
                                                <img src="https://recipe1.ezmember.co.kr/cache/recipe/2015/06/05/a6f37b18fd96bb31c76076d7c69a0de5_m.jpg">
                    </a>
                </div>
                <div class="common_sp_caption">
                    <div class="common_sp_caption_tit line2">BLET샌드위치</div>
                    <div class="common_sp_caption_rv_name" style="display: inline-block; vertical-align: bottom;">
                        <a href="/profile/recipe.html?uid=cools"><img src="https://recipe1.ezmember.co.kr/img/df/pf_100_100.png">쿨스</a>
                    </div>
                    <div class="common_sp_caption_rv">
                                                <span class="common_sp_caption_buyer" style="vertical-align: middle;">조회수 2,212</span>
                    </div>
                </div>
            </li>
	      */
	     int k=1;
	     try
	     {
	    	 for(int i=1;i<=3672;i++)
	    	 {
	    		 // https://www.10000recipe.com/recipe/list.html?order=reco&page=2
	    		 Document doc=Jsoup.connect("http://www.10000recipe.com/recipe/list.html?order=reco&page="+i).get();
	    		 Elements title=doc.select("div.common_sp_caption div.common_sp_caption_tit");
	    		 Elements poster=doc.select("img[src*=/recipe/]");
	    		 Elements chef=doc.select("div.common_sp_caption_rv_name a");
	    		 Elements link=doc.select("div.common_sp_thumb a.common_sp_link");
	    		 Elements hit=doc.select("div.common_sp_caption_rv span.common_sp_caption_buyer");
	    		 for(int j=0;j<title.size();j++)
	    		 {
	    			try
	    			{
		    			 RecipeVO vo=new RecipeVO();
		    			 vo.setNo(k);
		    			 vo.setTitle(title.get(j).text());
		    			 vo.setPoster(poster.get(j).attr("src"));
		    			 vo.setChef(chef.get(j).text());
		    			 vo.setLink(link.get(j).attr("href"));
		    			 vo.setHit(hit.get(j).text());
		    			 System.out.println("no:"+k);
		    			 System.out.println("Title:"+vo.getTitle());
		    			 System.out.println("Chef:"+vo.getChef());
		    			 System.out.println("Poster:"+vo.getPoster());
		    			 System.out.println("Link:"+vo.getLink());
		    			 System.out.println("hit:"+vo.getHit());
		    			 System.out.println("k="+k);
		    			 //dao.recipeInsert(vo);
		    			 recipeDetailData(vo.getLink(),k);
		    			 k++;
		    			 
	    			}catch(Exception e) {e.printStackTrace();}
	    		 }
	    	 }
	    	 System.out.println("End...");
	     }catch(Exception ex){ex.printStackTrace();}
	    
	}
	public ArrayList<ChefVO> chefAllData()
	{
		ArrayList<ChefVO> list=new ArrayList<ChefVO>();
		try
		{
			int k=1;
			for(int i=1;i<=27;i++)
			{
				// https://www.10000recipe.com/chef/chef_list.html?order=chef_no_follower&term=all&page=27
				Document doc=Jsoup.connect("http://www.10000recipe.com/chef/chef_list.html?order=chef_no_follower&term=all&page="+i).get();
				Elements poster=doc.select("div.list_mem3 a.mem_pic img");
				Elements chef=doc.select("div.list_cont4 a");
				Elements mem_cont1=doc.select("span.mem_cont1");
				Elements mem_cont3=doc.select("span.mem_cont3");
				Elements mem_cont7=doc.select("span.mem_cont7");
				Elements mem_cont2=doc.select("span.mem_cont2");
				
				for(int j=0;j<poster.size();j++)
				{
					try
					{
						ChefVO vo=new ChefVO();
						vo.setPoster(poster.get(j).attr("src"));
						vo.setChef(chef.get(j).text());
						vo.setMem_cont1(mem_cont1.get(j).text());
						vo.setMem_cont3(mem_cont3.get(j).text());
						vo.setMem_cont7(mem_cont7.get(j).text());
						vo.setMem_cont2(mem_cont2.get(j).text());
						System.out.println("Poster:"+vo.getPoster());
						System.out.println("Chef:"+vo.getChef());
						System.out.println("Mem-cont1:"+vo.getMem_cont1());
						System.out.println("Mem-cont3:"+vo.getMem_cont3());
						System.out.println("Mem-cont7:"+vo.getMem_cont7());
						System.out.println("Mem-cont2:"+vo.getMem_cont2());
						System.out.println("k="+k);
						System.out.println("---------------------------------------------------------");
						dao.chefInsert(vo);
					    k++;
					}catch(Exception ex){}
					//list.add(vo);
				}
			}
		}catch(Exception ex){ex.printStackTrace();}
		return list;
	}
	public RecipeDetailVO recipeDetailData(String url,int no)
    {
    	RecipeDetailVO vo=new RecipeDetailVO();
    	// http://www.10000recipe.com/recipe/6907454
    	int k=1;
    	try
    	{
    		Document doc=Jsoup.connect("http://www.10000recipe.com"+url).get();
    		Element poster=doc.selectFirst("div.centeredcrop img");// doc.select("").get(0)
    		
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
    		vo.setNo(no);
    		
    		dao.recipeDetailData(vo);
    		System.out.println("제목:"+vo.getTitle());
    		System.out.println("세프:"+vo.getChef());
    		System.out.println("내용:"+vo.getContent());
    		System.out.println("방법:"+vo.getFoodmake());
    		System.out.println("1.인용:"+vo.getInfo1());
    		System.out.println("2.시간:"+vo.getInfo2());
    		System.out.println("3.급수:"+vo.getInfo3());
    		
    		System.out.println("k="+k);
    		k++;
    	}catch(Exception ex){}
    	return vo;
    }
	public void test() throws Exception
	{
		URL location = this.getClass().getResource("/src");
		String path = location.getPath();
		System.out.println(path);
		String rightPath = path.substring(1, path.lastIndexOf("build"))+"src";
		System.out.println(rightPath);
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RecipeMain rm=new RecipeMain();
		//rm.chefAllData();
		rm.recipeAllData();
	    
	}
	
}












