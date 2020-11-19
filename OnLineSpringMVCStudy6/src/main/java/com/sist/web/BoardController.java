package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.board.dao.*;

@Controller
@RequestMapping("board/")
public class BoardController {
   @Autowired
   private BoardDAO dao;
   
   @RequestMapping("list.do")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<BoardVO> list=dao.boardListData(curpage);
	   
	   model.addAttribute("list", list);
	   return "board/list";
   }
   
   @RequestMapping("insert.do")
   public String board_insert()
   {
	   return "board/insert";
   }
   
   @RequestMapping("insert_ok.do")
   public String board_insert_ok(BoardVO vo)
   {
	   dao.boardInsert(vo);
	   return "redirect:../board/list.do";
   }
   
   @RequestMapping("detail.do")
   public String board_detailData(int no,Model model)
   {
	   BoardVO vo=dao.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   return "board/detail";
   }
   
}








