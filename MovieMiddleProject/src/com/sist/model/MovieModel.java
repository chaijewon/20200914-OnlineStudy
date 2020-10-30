package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

public class MovieModel {
	@RequestMapping("movie/real.do")
	public String movie_real(HttpServletRequest request) {
		// 두개의 데이터를 받는다 (페이지,카테고리번호)
		String page = request.getParameter("page");
		if (page == null)
			page = "1";
		String cateno = request.getParameter("cateno");
		// Map
		// 현재 페이지
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;

		// Map에 저장
		Map map = new HashMap();
		map.put("cateno", cateno);
		map.put("start", start);
		map.put("end", end);
		// 데이터베이스 연결
		List<MovieVO> list = MovieDAO.movieListData(map);
		// 총페이지
		int totalpage = MovieDAO.movieTotalPage(Integer.parseInt(cateno));

		// JSP에서 필요한 데이터를 보내기 시작
		// request에 값을 채운다
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		// include 파일 지정
		request.setAttribute("main_jsp", "../movie/real.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("movie/sch.do")
	public String movie_sch(HttpServletRequest request) {
		// 두개의 데이터를 받는다 (페이지,카테고리번호)
		String page = request.getParameter("page");
		if (page == null)
			page = "1";
		String cateno = request.getParameter("cateno");
		// Map
		// 현재 페이지
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;

		// Map에 저장
		Map map = new HashMap();
		map.put("cateno", cateno);
		map.put("start", start);
		map.put("end", end);
		// 데이터베이스 연결
		List<MovieVO> list = MovieDAO.movieListData(map);
		// 총페이지
		int totalpage = MovieDAO.movieTotalPage(Integer.parseInt(cateno));

		// JSP에서 필요한 데이터를 보내기 시작
		// request에 값을 채운다
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		// include 파일 지정
		request.setAttribute("main_jsp", "../movie/sch.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("movie/box.do")
	public String movie_box(HttpServletRequest request) {
		// 두개의 데이터를 받는다 (페이지,카테고리번호)
		String page = request.getParameter("page");
		if (page == null)
			page = "1";
		String cateno = request.getParameter("cateno");
		// Map
		// 현재 페이지
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;

		// Map에 저장
		Map map = new HashMap();
		map.put("cateno", cateno);
		map.put("start", start);
		map.put("end", end);
		// 데이터베이스 연결
		List<MovieVO> list = MovieDAO.movieListData(map);
		// 총페이지
		int totalpage = MovieDAO.movieTotalPage(Integer.parseInt(cateno));

		// JSP에서 필요한 데이터를 보내기 시작
		// request에 값을 채운다
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		// include 파일 지정
		request.setAttribute("main_jsp", "../movie/box.jsp");
		return "../main/main.jsp";
	}

	@RequestMapping("movie/news.do")
	public String movie_news(HttpServletRequest request) {
		String page = request.getParameter("page");
		if (page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 20;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;

		map.put("start", start);
		map.put("end", end);
		List<NewsVO> nList = MovieDAO.movieNewsData(map);
		// 총페이지
		int totalpage = MovieDAO.newsTotalPage();

		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("nList", nList);
		// include => news.jsp
		request.setAttribute("main_jsp", "../movie/news.jsp");// ${}
		return "../main/main.jsp";
	}

	@RequestMapping("movie/total.do")
	public String movie_total(HttpServletRequest request) {
		// 데이터 읽어서 => jsp 전송(데이터베이스)
		// 페이지
		String page = request.getParameter("page");
		if (page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 12;
		int start = (rowSize * curpage) - (rowSize - 1);
		int end = rowSize * curpage;
		map.put("start", start);
		map.put("end", end);
		List<MovieVO> list = MovieDAO.movieTotalData(map);
		int totalpage = MovieDAO.movieTotalPage2();

		int BLOCK = 5;
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		/*
		 * 1 , 2 , 3 , 4 , 5 ==> 1 ==> 12345 2/5 4/5 => 0
		 * 
		 * 6 7 8 9 10 ==> 6
		 */
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;
		/*
		 * 1 2 3 4 5 ==> 5 6 7 8 9 10 ==> 10
		 */
		// 12 => totalpage 11 ~ 15
		if (endPage > totalpage)
			endPage = totalpage;

		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("main_jsp", "../movie/total.jsp");
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		// 쿠키 읽기
		Cookie[] cookies=request.getCookies();
		List<MovieVO> cList=new ArrayList<MovieVO>();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith(id))
				{
					String no=cookies[i].getValue();
					MovieVO vo=MovieDAO.movieDetailData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		request.setAttribute("cList", cList);
		return "../main/main.jsp";
	}

	/*
	 * @RequestMapping("movie/detail.do") public String
	 * movie_detail(HttpServletRequest request) { // 사용자가 보내준 데이터 읽기 String
	 * no=request.getParameter("no"); String page=request.getParameter("page");
	 * String cno=request.getParameter("cno"); if(page==null) page="1";
	 * 
	 * detail.do ==> page==null if(page==null) detail.do? page= 10 ==> " 10" ${
	 * vo.no } ==> page "" if(page.equals(""))
	 * 
	 * // 상세보기 데이터 읽기 // DataBase연결
	 * 
	 * request.setAttribute("main_jsp", "../movie/detail.jsp"); return
	 * "../main/main.jsp"; }
	 */
	@RequestMapping("movie/detail_before.do") // 쿠키 전송 받는다 => 요청 => detail
	/*
	 * cookie : 클라이언트 (브라우저) ==> 저장 내용을 서버에서 전송 (response) session : 서버에 저장
	 * (response를 이용하지 않는다)
	 */
	public String movie_detail_before(HttpServletRequest request,
			HttpServletResponse response) {
		// ../movie/detail_before.do?no=${vo.no }
		String no = request.getParameter("no");
		// no=1&aaa=1
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		//   shim123
		Cookie cookie=new Cookie(id+no, no);
		// 기간 
		cookie.setMaxAge(60*60*24);
		//전송
		response.addCookie(cookie);
		
		//cookie=new Cookie(id+no, no);
		return "redirect:../movie/detail.do?no=" + no;// 재요청 
	}

	@RequestMapping("movie/detail.do")
	public String movie_detail(HttpServletRequest request) {
		
		String no=request.getParameter("no");
		// DB연동
		MovieVO vo=MovieDAO.movieDetailData(Integer.parseInt(no));
		String str=vo.getStory();
		if(str.length()>300)
		{
		    str=str.substring(0,300);
		    str+="...";
		}
		vo.setStory(str);
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../movie/detail.jsp");
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		JjimVO jvo=new JjimVO();
		jvo.setId(id);
		jvo.setMno(Integer.parseInt(no));
		int count=MovieDAO.jjimCount(jvo);
		
		request.setAttribute("count", count);
		return "../main/main.jsp";
	}
	@RequestMapping("movie/like.do")
	public String movie_like(HttpServletRequest request)
	{
		String no=request.getParameter("no");
		MovieDAO.likeIncrement(Integer.parseInt(no));
		return "redirect:../movie/detail.do?no="+no;
	}
	
	@RequestMapping("movie/jjim.do")
	public String movie_jjim(HttpServletRequest request)
	{
		String no=request.getParameter("no");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		JjimVO vo=new JjimVO();
		vo.setId(id);
		vo.setMno(Integer.parseInt(no));
		MovieDAO.jjimInsert(vo);
		return "redirect:../movie/detail.do?no="+no;
	}
	@RequestMapping("movie/jjim_cancel.do")
	public String movie_jjim_cancel(HttpServletRequest request)
	{
		String no=request.getParameter("no");
		MovieDAO.jjimDelete(Integer.parseInt(no));
		return "redirect:../reserve/mypage.do";
	}
}





