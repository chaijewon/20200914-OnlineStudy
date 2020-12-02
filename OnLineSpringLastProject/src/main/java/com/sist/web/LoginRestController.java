package com.sist.web;

import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;
import com.sist.dao.ReplyDAO;

@RestController
public class LoginRestController {
   @Autowired
   private ReplyDAO dao;
   @Autowired
   private BoardDAO bdao;
   @RequestMapping("main/login.do")
   public String main_login(String id,String pwd,HttpSession session)
   {
	   String result="";
	   String s=dao.isLogin(id, pwd);
	   if(s.equals("NOID"))
	   {
		   result="1";
	   }
	   else if(s.equals("NOPWD"))
	   {
		   result="2";
	   }
	   else
	   {
		   result="3";
		   StringTokenizer st=new StringTokenizer(s,"|");
		   session.setAttribute("id", st.nextToken());
		   session.setAttribute("name", st.nextToken());
	   }
	   return result;
   }
   @RequestMapping("board/update_ok.do")
   public String board_update_ok(BoardVO vo)
   {
	   String result="";
	   boolean bCheck=bdao.boardUpdate(vo);
	   if(bCheck==false)
	   {
		   result="<script>"
				 +"alert(\"Password Fail!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   else
	   {
		   result="<script>location.href=\"../board/detail.do?no="+vo.getNo()+"\";</script>";
	   }
	   return result;
   }
   
   @RequestMapping("board/delete_ok.do")
   public String board_delete_ok(int no,String pwd)
   {
	   String result="";
	   boolean bCheck=bdao.boardDelete(no, pwd);
	   if(bCheck==false)
	   {
		   result="<script>"
				 +"alert(\"Password Fail!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   else
	   {
		   result="<script>location.href=\"../board/list.do\";</script>";
	   }
	   return result;
   }
}




