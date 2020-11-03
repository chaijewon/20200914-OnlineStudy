package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.RecipeDAO;
import com.sist.dao.RecipeVO;

/*
 *      MVC 
 *      ====
 *        음식점 
 *        =====
 *               DispatcherServlet
 *               ========== 배달부 
 *          손님 ==== 서빙  ========> 주방 (Model)
 *              주문              주문서 
 *          손님<====     <======== 주방
 *                        음식 (request,session)
 *          xml,annotation => 메뉴판 
 */
import java.util.*;
@Controller
public class RecipeController {
	@Autowired
    private RecipeDAO dao;
	
	// 사용자가 요청이 있을 때 처리 
	// 웹 => 사용자 요청 (URL주소)  ==> 서버주소(X) ==> URI  ==> .do
	@RequestMapping("recipe/list.do")
	// 사용자 요청 처리 
	public String recipe_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		// 데이터 받기 => 스프링에서 메모리 할당=>한개만 저장 (재사용) = 싱글턴
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		// Map에서 채워서 => DAO로 전송 
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<RecipeVO> list=dao.recipeListData(map);
		for(RecipeVO vo:list)
		{
			String title=vo.getTitle();
			if(title.length()>22)
			{
				title=title.substring(0,22);
				title+="...";
			}
			vo.setTitle(title);
		}
		// 총페이지 
		int totalpage=dao.recipeTotalPage();
		
		// 전송 
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "recipe/list";// forward => list.jsp=>request를 전송 
	}
	/*
	 *    @RequestMapping() => 통합 (GET,POST)
	 *    @GetMapping => Get방식으로 전송 
	 *                   <a> ,sendRedirect() , location.href
	 *    @PostMapping => ajax , form
	 */
	@GetMapping("recipe/chef.do")
	public String recipe_chef(String chef,Model model)
	{
		return "";
	}
	
}







