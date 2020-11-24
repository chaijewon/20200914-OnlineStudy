package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
@RequestMapping("food/")
public class FoodController {
   @Autowired
   private FoodDAO fdao;
   @RequestMapping("list.do")
   public String food_list(Model model)
   {
	   List<FoodCategoryVO> list=fdao.foodCategoryAllData();
	   model.addAttribute("list", list);
	   return "food/list";
   }
   @RequestMapping("food_category.do")
   public String food_category(int no,Model model)
   {
	   List<FoodVO> list=fdao.foodCategoryFoodListData(no);
	   for(FoodVO vo:list)
	   {
		   String s=vo.getPoster();
		   s=s.substring(0,s.indexOf("^"));
		   vo.setPosterOne(s);
	   }
	   FoodCategoryVO vo=fdao.foodCategoryInfoData(no);
	   model.addAttribute("list", list);
	   model.addAttribute("vo", vo);
	   return "food/category";
   }
}
