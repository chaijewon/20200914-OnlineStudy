package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.board.dao.*;

@Controller
// forward,sendRedirect  => 파일명=> 전송 (<script>사용할 수 없다)
// @RestController를 사용 
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
	   int totalpage=dao.boardTotalPage();
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
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
   
   @RequestMapping("update.do")
   public String board_update(int no,Model model)
   {
	   BoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   return "board/update";
   }
   @RequestMapping("update_ok.do")
   public String board_update_ok(BoardVO vo,Model model)
   {
	   // DAO연동
	   boolean bCheck=dao.boardUpdate(vo);
	   model.addAttribute("bCheck", bCheck);
	   model.addAttribute("no", vo.getNo());
	   return "board/update_ok";//ajax
   }
   
   @RequestMapping("delete.do")
   public String board_delete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "board/delete";
   }
   
   @RequestMapping("delete_ok.do")
   public String board_delete_ok(int no,String pwd,Model model)
   {
	   boolean bCheck=dao.boardDelete(no, pwd);
	   model.addAttribute("bCheck", bCheck);
	   return "board/delete_ok";
   }
   
}








