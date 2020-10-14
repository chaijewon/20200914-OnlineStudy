package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

public class MovieModel {
	@RequestMapping("movie/movie.do")
	  public String main_page(HttpServletRequest request)
	  {
		  request.setAttribute("msg", "Movie.jsp");
		  return "../movie/movie.jsp";
	  }
}
