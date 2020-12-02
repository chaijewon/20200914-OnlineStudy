package com.sist.data;
/*
 *  popular_top_list_wrap
 * <section class="module popular_top_list_wrap">
  <div class="module_title_wrap">
    <h2 class="title">지역별 인기 맛집</h2>
  </div>
  <div class="slider-container toplist-slider">
    <button class="btn-nav prev"></button>
    <button class="btn-nav next"></button>

    <div class="top_list_slide">
        <ul class="list-toplist-slider" style="width: 531px;">
            <li>
              <img class="center-croping" alt="2020 제주 인기 맛집 TOP 60 사진"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/7zsdxmpu4kauzpk7.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>

              <a href="/top_lists/2264_jeju2020"
                 onclick="trackEvent('CLICK_TOPLIST', {&quot;section_position&quot;:6,&quot;section_title&quot;:&quot;지역별 인기 맛집&quot;,&quot;position&quot;:0,&quot;link_key&quot;:&quot;PQQTL_E&quot;});">
                <figure class="ls-item">
                  <figcaption class="info">
                    <div class="info_inner_wrap">
                      <span class="title">2020 제주 인기 맛집 TOP 60</span>
                      <p class="desc">"제주의 인기 맛집만 쏙쏙 골라 모았다!"</p>
                      <p class="hash">
                          <span>#제주도 </span>
                          <span>#제주 </span>
                          <span>#서귀포시 </span>
                          <span>#제주시 </span>
                          <span>#제주여행 </span>
                          <span>#제주맛집 </span>
                          <span>#고기국수 </span>
                          <span>#돔베고기 </span>
                          <span>#흑돼지 </span>
                          <span>#고등어회 </span>
                          <span>#갈치회 </span>
                          <span>#몸국 </span>
                          <span>#오겹살 </span>
                          <span>#2020망고플레이트인기맛집 </span>
                      </p>
                    </div>
                  </figcaption>
                </figure>
              </a>
            </li>
 * <div class="top_list_slide">
        <ul class="list-toplist-slider" style="width: 531px;">
            <li>
              <img class="center-croping" alt="부산 광안리 맛집 베스트 25곳 사진"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/la_vlgj7bh5oqani.png?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>

              <a href="/top_lists/2720_gwanganri"
                 onclick="trackEvent('CLICK_TOPLIST', {&quot;section_position&quot;:0,&quot;section_title&quot;:&quot;믿고 보는 맛집 리스트&quot;,&quot;position&quot;:0,&quot;link_key&quot;:&quot;FSCPVRH&quot;});">
                <figure class="ls-item">
                  <figcaption class="info">
                    <div class="info_inner_wrap">
                      <span class="title">부산 광안리 맛집 베스트 25곳</span>
                      <p class="desc">"광안리에 이거 먹을 갈 사람?"</p>
                      <p class="hash">
                          <span>#부산시 수영구 </span>
                          <span>#부산 수영구 </span>
                          <span>#수영구 </span>
                          <span>#부산 남구 </span>
                          <span>#부산시 남구 </span>
                          <span>#수영구청 </span>
                          <span>#광안대교 </span>
                          <span>#광안리바닷가 </span>
                          <span>#광안리해변 </span>
                          <span>#광안리 </span>
                          <span>#광안리역 </span>
                          <span>#금련산역 </span>
                          <span>#수영역 </span>
                      </p>
                    </div>
                  </figcaption>
                </figure>
              </a>
            </li>
 */
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FoodManager {
    public void foodCategoryAllData()
    {
    	FoodDAO dao=new FoodDAO();
    	try
    	{
    		Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
    		Elements title=doc.select("div.info_inner_wrap span.title");
    		Elements poster=doc.select("ul.list-toplist-slider img.center-croping");
    		Elements subject=doc.select("div.info_inner_wrap p.desc");
    		Elements link=doc.select("ul.list-toplist-slider a");
    		for(int i=0;i<title.size();i++)
    		{
    			System.out.println((i+1)+"번");
    			System.out.println("제목:"+title.get(i).text());
    			System.out.println("부제목:"+subject.get(i).text());
    			System.out.println("링크:"+link.get(i).attr("href"));
    			System.out.println("이미지:"+poster.get(i).attr("data-lazy"));
    			FoodCategoryVO vo=new FoodCategoryVO();
    			vo.setNo(i+1);
    			vo.setTitle(title.get(i).text());
    			String p=poster.get(i).attr("data-lazy");
    			p=p.replace("&", "^");
    			vo.setPoster(p);
    			String s=subject.get(i).text();
    			s=s.replace("\"", "");
    			vo.setSubject(s);
    			vo.setLink(link.get(i).attr("href"));
    			dao.foodGategoryInsert(vo);
    			try
    			{
    				Thread.sleep(50);
    			}catch(Exception ex){}
    		}
    	}catch(Exception ex){}
    	
    }
    // https://www.mangoplate.com/
    // <a href="http://localhost:8080/main/main.do">
    //  <a href="../main/main.do">
    public FoodVO foodDetailData()
    {
    	FoodVO vo=new FoodVO();
    	FoodDAO dao=new FoodDAO();
    	try
    	{
    		List<FoodCategoryVO> list=dao.foodCategoryListData();
    		for(FoodCategoryVO fvo:list)
    		{
    			/*
    			 *  <figure class="restaurant-item">
                    <a href="/restaurants/YKkbu955qj"
    			 */
    			String url="https://www.mangoplate.com"+fvo.getLink();
    			int cateno=fvo.getNo();
    			/*
    			 *  span class="title 
    			 */
    			Document doc=Jsoup.connect(url).get();
    			Elements link=doc.select("figure.restaurant-item span.title a");
    			System.out.println(link.size());
    			System.out.println("카테고리 번호:"+cateno);
    			for(int i=0;i<link.size();i++)
    			{
    				
    				try
    				{
    				System.out.println("사이트:"+link.get(i).attr("href"));
    				System.out.println("==============================");
    				String url2="https://www.mangoplate.com"+link.get(i).attr("href");
    			    Document doc2=Jsoup.connect(url2).get();
    			    /*
    			     *      POSTER NOT NULL VARCHAR2(1000) 
							TITLE  NOT NULL VARCHAR2(200)  
							SCORE  NOT NULL VARCHAR2(5)    
							ADDR   NOT NULL VARCHAR2(200)  
							TEL    NOT NULL VARCHAR2(15)   
							TYPE   NOT NULL VARCHAR2(200)  
							PRICE           VARCHAR2(100)  
							MENU            VARCHAR2(500)  
							GOOD            NUMBER         
							SOSO            NUMBER         
							BAD             NUMBER  
    			     */
    			    FoodVO vo2=new FoodVO();
    			    String strPoster="";
    			    try
    			    {
	    			    Elements poster=doc2.select("img.center-croping");
	    			    
	    			    for(int j=0;j<poster.size();j++)
	    			    {
	    			    	String s=poster.get(j).attr("src");
	    			    	strPoster+=s+"^";
	    			    }
	    			    strPoster=strPoster.substring(0,strPoster.lastIndexOf("^"));
    			    }catch(Exception ex){
    			    	strPoster="no";
    			    }
    			    vo2.setPoster(strPoster);
    			    
    			    Element title=doc2.selectFirst("span.title h1.restaurant_name");
    			    Element score=doc2.selectFirst("span.title strong.rate-point span");
    			    Element addr=doc2.select("tr.only-desktop td").get(0);
    			    Element tel=doc2.select("tr.only-desktop td").get(1);
    			    Element type=doc2.select("tr td span").get(2);
    			    /// 공통으로 출력 
    			    vo2.setCateno(cateno);
    			    vo2.setTitle(title.text());
    			    vo2.setScore(score.text());
    			    vo2.setAddr(addr.text());
    			    vo2.setTel(tel.text());
    			    vo2.setType(type.text());
    			    
    			    String strPrice="";
    			    try{
    			         Element price=doc2.select("tr td").get(3);
    			         strPrice=price.text();
    			    }catch(Exception e)
    			    {
    			    	strPrice="no";
    			    }
    			    vo2.setPrice(strPrice);
    			    
    			    String strMenu="";
    			    try
    			    {
    			    	Elements menu=doc2.select("td.menu_td li.Restaurant_MenuItem");
    			       for(int j=0;j<menu.size();j++)
    			        {
    			      	  strMenu+=menu.get(j).text()+"^";
    			        }
    			        strMenu=strMenu.substring(0,strMenu.lastIndexOf("^"));
    			    }catch(Exception e)
    			    {
    			    	strMenu="no";
    			    }
    			    vo2.setMenu(strMenu);
    			    /*
    			     *  <script id="reviewCountInfo" type="application/json">
    			     *  [{"action_value":1,"count":6},
    			     *  {"action_value":2,"count":14},
    			     *  {"action_value":3,"count":50}]</script>
    			     */
    			    String temp=doc2.selectFirst("#reviewCountInfo").data();
    			    
    			    try
    			    {
    			    	JSONParser jp=new JSONParser();
    			    	JSONArray arr=(JSONArray)jp.parse(temp);
    			    	for(int a=0;a<arr.size();a++)
    			    	{
    			    		JSONObject obj=(JSONObject)arr.get(a);
    			    		if(a==2)
    			    		{
    			    		  System.out.println("좋아요:"+obj.get("count"));
    			    		  vo2.setGood(Integer.parseInt(String.valueOf(obj.get("count"))));
    			    		}
    			    		else if(a==1)
    			    		{
    			    		   System.out.println("괜찮다:"+obj.get("count"));
    			    		   vo2.setSoso(Integer.parseInt(String.valueOf(obj.get("count"))));
    			    		}
    			    		else
    			    		{
    			    	     	System.out.println("별로:"+obj.get("count"));
    			    	     	vo2.setBad(Integer.parseInt(String.valueOf(obj.get("count"))));
    			    		}
    			    	}
    			    }catch(Exception ex){}
    			    
    			    System.out.println("제목:"+title.text());
    			    System.out.println("주소:"+addr.text());
    			    System.out.println("평점:"+score.text());
    			    System.out.println("전화:"+tel.text());
    			    System.out.println("종류:"+type.text());
    			    System.out.println("가격:"+strPrice);
    			    System.out.println("메뉴:"+strMenu);
    			    System.out.println("리뷰:"+temp);
    			    
    			    dao.foodDetailInsert(vo2);
    			    
    				}catch(Exception e)
    				{
    					System.out.println(e.getMessage());
    				}
    			}
    			
    		}
    		
    	}catch(Exception ex){System.out.println(ex.getMessage());}
    	return vo;
    }
}



