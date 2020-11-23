package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// http://localhost:8080/web/main/main.do
@Controller
public class MainController {
   @RequestMapping("main/main.do")
   public String main_main()
   {
	   return "main";
   }
   @RequestMapping("recipe/list.do")
   public String recipe_list()
   {
	   return "recipe/list";
   }
}
