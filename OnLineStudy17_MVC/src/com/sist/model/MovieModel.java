package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

// interface를 사용하지 않는다 (일반자바 => POJO)
// 전체 목록 출력
// 상세보기
public class MovieModel {
  @RequestMapping("movie/list.do")
  public String movieListData(HttpServletRequest request)
  {
	  request.setAttribute("msg", "영화목록");
	  // include에 포함될 jsp파일 전송
	  //request.setAttribute("main_jsp", "../movie/list.jsp");
	  return "../main/main.jsp";// request를 전송할 jsp파일명 
  }
  @RequestMapping("movie/detail.do")
  public String movieDetailData(HttpServletRequest request)
  {
	  request.setAttribute("msg", "영화상세보기");
	  request.setAttribute("main_jsp", "../movie/detail.jsp");
	  return "../main/main.jsp";// request를 전송할 jsp파일명 // forward , sendRedirect (jsp => _ok.jsp)
	  /*
	   *   1. 화면에 출력할 내용이 있는 경우 (request를 유지) ==> forward
	   *   2. 화면에 출력하는 내용이 아닌 경우 (데이터베이스 추가,수정,삭제) ==> 수행후에 sendRedirect() 다른 화면으로 이동
	   *      예) insert_ok.jsp ==> list.jsp
	   *          login_ok.jsp ==> main.jsp
	   *          
	   */
	  
  }
}





