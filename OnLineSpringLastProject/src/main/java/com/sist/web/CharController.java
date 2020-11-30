package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class CharController {
    @RequestMapping("chat/chat.do")
    public String chat_chat(HttpSession session)
    {
    	String name=(String)session.getAttribute("id");
    	return name;
    }
}
