package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

public class MovieModel {
   @RequestMapping("movie/real.do")
   public String movie_real(HttpServletRequest request)
   {
	   request.setAttribute("msg", "현재상영영화");// DB
	   return "../movie/real.jsp";
   }
   @RequestMapping("movie/sch.do")
   public String movie_sch(HttpServletRequest request)
   {
	   request.setAttribute("msg", "개봉예정영화");
	   return "../movie/sch.jsp";
   }
   @RequestMapping("movie/box.do")
   public String movie_box(HttpServletRequest request)
   {
	   request.setAttribute("msg", "박스오피스");
	   return "../movie/box.jsp";
   }
}
