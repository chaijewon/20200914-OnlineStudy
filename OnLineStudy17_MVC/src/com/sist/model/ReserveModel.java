package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

/*
 *   1. 영화목록
 *   2. 극장목록
 *   ===========
 *   3. 날짜정보
 *   4. 시간정보
 *   5. 인원정보
 *   6. 예매정보 
 */
public class ReserveModel {
	 @RequestMapping("reserve/movie.do")
     public String movieList(HttpServletRequest request)
     {
    	 // 값전송(jsp) ==> request에 담아준다 
    	 request.setAttribute("msg", "예매=>영화정보");
    	 request.setAttribute("main_jsp", "../reserve/movie.jsp");
   	     return "../main/main.jsp";// request를 전송할 jsp파일명 
     }
	 @RequestMapping("reserve/theater.do")
     public String theaterList(HttpServletRequest request)
     {
    	 request.setAttribute("msg", "예매=>극장정보");
    	 request.setAttribute("main_jsp", "../reserve/theater.jsp");
   	     return "../main/main.jsp";// request를 전송할 jsp파일명 
     }
}







