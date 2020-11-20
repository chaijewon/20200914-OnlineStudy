package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

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
   public String board_detailData(int no,String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   BoardVO vo=dao.boardDetailData(no);
	   List<ReplyVO> list=dao.replyListData(3, no, curpage);
	   model.addAttribute("vo", vo);
	   model.addAttribute("list", list);
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
   
   @RequestMapping("login.do")
   public String board_login()
   {
	   return "board/login";
   }
   
   @RequestMapping("login_ok.do")
   public String board_login_ok(String id,String pwd,Model model,HttpSession session)
   {
	   MemberVO vo=dao.memberLogin(id, pwd);
	   if(vo.getMessage().equals("OK"))
	   {
		   session.setAttribute("id", id);
		   session.setAttribute("name", vo.getName());
	   }
	   model.addAttribute("msg", vo.getMessage());
	   return "board/login_ok";
   }
   @RequestMapping("reply_insert.do")
   public String replyInsert(ReplyVO vo,HttpSession session)
   {
	   // cno , msg
	   vo.setId((String)session.getAttribute("id"));
	   vo.setName((String)session.getAttribute("name"));
	   vo.setType(3);
	   dao.replyInsert(vo);
	   return "redirect:detail.do?no="+vo.getCno();
   }
   
   @RequestMapping("reply_delete.do")
   public String reply_delete(int no,int cno)
   {
	   dao.replyDelete(no);
	   return "redirect:detail.do?no="+cno;
   }
   
   @RequestMapping("reply_update.do")
   public String reply_update(int no,int cno,String msg)
   {
	   dao.replyUpdate(no, msg);
	   return "redirect:detail.do?no="+cno;
   }
   
}








