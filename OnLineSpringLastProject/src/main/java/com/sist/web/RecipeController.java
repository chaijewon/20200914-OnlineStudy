package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class RecipeController {
    @Autowired
    private RecipeDAO dao;
    @RequestMapping("recipe/list.do")
    public String recipe_list(String page,Model model)
    {
       if(page==null)
    	   page="1";
       int curpage=Integer.parseInt(page);
       List<RecipeVO> list=dao.recipeListData(curpage);
       int count=dao.recipeCount();
       int totalpage=(int)(Math.ceil(count/12.0));
       
       model.addAttribute("curpage", curpage);
       model.addAttribute("count", count);
       model.addAttribute("totalpage", totalpage);
       model.addAttribute("list", list);
       return "recipe/list";	
    }
    @RequestMapping("recipe/recipe_detail.do")// 요청 
    /*
     *   "1.어린 따님들도 잘 먹고 남편도 좋아했던 소불고기 버섯전골 레시피 맛있게 만드는 법 알려드려요.\n
     *    2.냄비에 육수를 먼저 내어주세요. 물 100cc에 해물 육수 팩을 넣어 끓여주세요 육수 내는 동안 고기 양념을 해줄게요.\n
     *    3.소고기는 불고깃감으로 준비했어요. 다진 마늘 1/2수저, 진간장 1수저, 소주 1수저, 참기름 1수저, 후추 넣고 버무려 양념을 해주세요. 전 남은 소주가 있어서 넣었는데 소주는 맛술이나 생강술로 대체 가능해요.\n
     *    4.말린 표고버섯은 물에 불려 준비하고 버섯들은 물에 살짝만 헹궈 준비했어요. 새송이버섯은 썰어 준비하고\n5.느타리버섯 만가닥 버섯 팽이버섯은 가닥가닥 찢어 준비해 주세요.\n6.느타리버섯 만가닥 버섯 팽이버섯은 가닥가닥 찢어 준비해 주세요.\n7.양파 반 개는 채 썰어 준비하고\n8.쑥갓도 썰어 준비했어요.\n9.버섯 준비 완료~\n10.소고기 버섯전골 국물 양념장도 미리 만들었어요. 국간장 2수저, 멸치 액젓 1수저, 설탕 1/2수저, 후추를 넣어 국물에 넣어줄 양념장을 만들었어요.\n11.팬에 양념 소불고기를 넣어주고\n12.버섯을 양쪽으로 빙 둘러 가면 종류별로 놓아주세요. 큰따님이 당면을 좋아해서 당면도 얹어주었어요.\n13.끓여두었던 육수를 부어주고 센 불로 올려주세요.\n14.전 양념장도 함께 넣어 끓여주었어요.\n15.소 불고기가 다 익으면 완성~\n16.끓이는 건 10분 안쪽이에요. 고기와 당면이 다 익으면 끄시면 돼요.\n17.담백하고 국물 진한 소고기 버섯전골이 완성~ 부족한 간은 소금으로 하시면 되는데 저희는 심심하게 먹는 걸 좋아해서 추가 간을 하지 않았어요.\n"

     */
    public String recipe_detail(int no,Model model)
    {
    	RecipeDetailVO vo=dao.recipeDetailData(no);
    	StringTokenizer st=new StringTokenizer(vo.getFoodmake(),"\n");
    	while(st.hasMoreTokens())
    	{
    		vo.getmList().add(st.nextToken());
    	}
    	model.addAttribute("vo", vo);
    	return "recipe/detail";
    }
    
    @RequestMapping("recipe/chef_list.do")
    public String recipe_chef_list(String page,Model model)
    {
    	if(page==null)
    		page="1";
    	int curpage=Integer.parseInt(page);
    	List<ChefVO> list=dao.chefListData(curpage);
    	model.addAttribute("list", list);
    	return "recipe/chef_list";
    }
    
    @RequestMapping("recipe/chef_product.do")
    public String recipe_chef_product(String chef,String page,String fd,Model model)
    {
    	/*
    	 *   화면 변경 : forward (JSP 파일명)
    	 *   내용 변경 : redirect (.do 내용 변경)
    	 */
    	if(page==null)
    		page="1";
    	int curpage=Integer.parseInt(page);
    	List<RecipeVO> list=new ArrayList<RecipeVO>();
    	if(fd==null)
    	{
    	   list=dao.chefProductData(chef, curpage);
    	}
    	else
    	{
    		list=dao.chefProductFindData(chef, fd);
    	}
    	// JSP로 전송 
    	model.addAttribute("list", list);
    	model.addAttribute("chef", chef);
    	return "recipe/chef_product";
    }
}





