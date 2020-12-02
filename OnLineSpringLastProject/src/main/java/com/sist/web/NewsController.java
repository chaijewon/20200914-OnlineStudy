package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.news.*;
import java.text.*;
@Controller
public class NewsController {
   @Autowired
   private NewsManager mgr;
   @RequestMapping("news/list.do")
   public String news_list(String fd,Model model)
   {
	   if(fd==null)
		   fd="맛집";
	   List<Item> list=mgr.newsAllData(fd);
	   for(Item i:list)
	   {
		   i.setDay(new SimpleDateFormat("yyyy-MM-dd").format(new Date(i.getPubDate())));
	   }
	   model.addAttribute("list", list);
	   return "news/list";
   }
}





