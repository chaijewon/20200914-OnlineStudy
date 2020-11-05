package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
// 필요한 JavaScript
@RestController
// ajax , react 
// 단점 => IE (실행이 안됨)
public class BoardRestController {
   @Autowired
   private BoardDAO dao;
   
   @RequestMapping("board/update_ok.do")
   public String board_update_ok(BoardVO vo)
   {
	   String result="";
	   boolean bCheck=dao.boardUpdate(vo);
	   if(bCheck==true)
	   {
		   result="<script>"
				 +"location.href=\"detail.do?no="+vo.getNo()+"\";"
				 +"</script>";
		   
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"Password Fail!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
   
   @RequestMapping("board/delete_ok.do")
   public String board_delete_ok(int no,String pwd)
   {
	   String result="";
	   boolean bCheck=dao.boardDelete(no, pwd);
	   if(bCheck==true)
	   {
		   result="<script>"
				 +"location.href=\"list.do\";"
				 +"</script>";
		   
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"비밀번호가 틀립니다!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
}





