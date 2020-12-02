package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
@RequestMapping("board/")
public class BoardController {
   @Autowired
   private BoardDAO bdao;
   @Autowired
   private FoodDAO fdao;
   @RequestMapping("list.do")
   public String board_list(String page,Model model)
   {
	   /*
	    *    MySQL , 마리아디비 : 소형 => 중소기업 
	    *    MS-SQL,Oracle :중형 => 대기업
	    *    DB2,사이베이스 :대형 => 학교 , 금융
	    *    몽고디비,카산드라  : noSql => AI
	    */
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<BoardVO> bList=bdao.boardListData(curpage);
	   // 총페이지 
	   int totalpage=bdao.boardTotalPage();
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("bList", bList);
	     //<definition name="*/*" extends="main">
		 //<put-attribute name="content" value="/WEB-INF/{1}/{2}.jsp"/>
		 //</definition>
	   commonData(model);
	   return "board/list";
   }
   @RequestMapping("insert.do")
   public String board_insert(Model model)
   {
	   commonData(model);
	   return "board/insert";
   }
   @RequestMapping("insert_ok.do")
   public String board_insert_ok(BoardVO vo)
   {
	   bdao.boardInsert(vo);
	   return "redirect:../board/list.do";
   }
   @RequestMapping("detail.do")
   public String board_detail(int no,Model model)
   {
	   BoardVO vo=bdao.boardDetailData(no,1);
	   model.addAttribute("vo", vo);
	   return "board/detail";
   }
   @RequestMapping("update.do")
   public String board_update(int no,Model model)
   {
	   BoardVO vo=bdao.boardDetailData(no,2);
	   model.addAttribute("vo", vo);
	   commonData(model);
	   return "board/update";
   }
   @RequestMapping("delete.do")
   public String board_delete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   commonData(model);
	   return "board/delete";
   }
   @RequestMapping("food_find.do")
   public String food_find(String no,Model model)
   {
	   System.out.println(no);
	   String[] gu= { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
				      "은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
				      "성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
				      "강동구" };
	   List<FoodVO> list=new ArrayList<FoodVO>();
	   if(no!=null)
	   {
		   System.out.println(gu[Integer.parseInt(no)]);
		   list=fdao.foodLocationFindData(gu[Integer.parseInt(no)]);
	   }
	   model.addAttribute("list", list);
	   model.addAttribute("count", list.size());
	   return "food_find";
   }
   public void commonData(Model model)
   {
	   List<FoodVO> fList=fdao.foodTop10();
	   List<RecipeVO> rList=fdao.recipeTop10();
	   model.addAttribute("fList", fList);
	   model.addAttribute("rList", rList);
   }
   
}





