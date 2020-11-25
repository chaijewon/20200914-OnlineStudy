package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class BoardController {
   @Autowired
   private BoardDAO bdao;
   
   @RequestMapping("board/list.do")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<BoardVO> bList=bdao.boardListData(curpage);
	   // 총페이지 
	   model.addAttribute("bList", bList);
	   return "board/list";
   }
   @RequestMapping("board/insert.do")
   public String board_insert()
   {
	   return "board/insert";
   }
   @RequestMapping("board/insert_ok.do")
   public String board_insert_ok(BoardVO vo)
   {
	   bdao.boardInsert(vo);
	   return "redirect:../board/list.do";
   }
}





