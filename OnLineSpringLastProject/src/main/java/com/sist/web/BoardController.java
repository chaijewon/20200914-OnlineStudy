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
	   return "board/update";
   }
   @RequestMapping("delete.do")
   public String board_delete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "board/delete";
   }
}





