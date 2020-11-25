package com.sist.web;

import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.ReplyDAO;

@RestController
public class LoginRestController {
   @Autowired
   private ReplyDAO dao;
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
}




