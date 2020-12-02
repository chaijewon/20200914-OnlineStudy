package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
   @RequestMapping("chat/chat.do")
   public String chat_chat()
   {
	   return "chat/chat";
   }
   
}
