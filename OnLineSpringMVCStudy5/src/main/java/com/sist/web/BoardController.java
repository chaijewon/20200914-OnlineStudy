package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;
import com.sist.dao.*;
/*
 *    public void display()
 *    {
 *        @Autowired (X)
 *        BoardDAO dao;
 *    }
 */
@Controller
public class BoardController {
   // 1. 스프링으로부터 필요한 클래스 객체를 받아 둔다 
   // 스프링에서 생성된 객체 주소를 받을 경우에 => 지역변수는 사용 할 수 없다 
	/*
	 *    CONSTRUCTOR, FIELD, METHOD, PARAMETER
	 *    
	 *    class A
	 *    {
	 *        @Autowired
	 *        B b;  ===> FIELD
	 *        @Autowired
	 *        public void display(B b)
	 *        {
	 *        }
	 *        @Autowired
	 *        public A(B b)
	 *        {
	 *           
	 *        }
	 *        
	 *        public void display(@Autowired B b, @Autowired C c)
	 *        {
	 *        }
	 *    }
	 */
	@Autowired
	private BoardDAO dao;
	@RequestMapping("board/list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		// 현재 페이지 데이터값을 읽어 온다
		Map map=new HashMap();
		int rowSize=10;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=dao.boardListData(map);
		// 총페이지 
		int totalpage=dao.boardTotalPage();
		// JSP로 데이터 전송 => 전송만 담당 => Model
		// Spring => request를 사용하지 않는다 
		/*
		 *   request 
		 *     1. 사용자 보내준 데이터를 받을 수 있다 => getParameter()
		 *        => 스프링에서 메소드의 매개변수를 이용해서 데이터값을 받는다
		 *     2. 결과값을 모아서 전송해준 기능 
		 *        => Model 인터페이스를 이용해서 데이터 전송 
		 *     3. request안에는 사용자의 정보 (IP,PORT) 존재 => 보안에 목적 
		 *        ===============================================
		 *        request에 첨부되어 있는 값을 DispatcherServlet이 처리 
		 *        *** 필요한 모든 데이터나 객체는 매개변수로 받는다 
		 *        예) HttpSession 생성 
		 *           일반 MVC에서 사용
		 *           public String login(HttpServletRequest request)
		 *           {
		 *              HttpSession session=request.getSession();
		 *           }
		 *           Spring 
		 *           public String login(HttpSession session)
		 *           {
		 *           }
		 *           *** 매개변수는 순서가 없다 
		 *           
		 *           
		 */
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "board/list";// forward ,sendRedirect => return "redirect:.do";
	}
	@RequestMapping("board/insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	@RequestMapping("board/insert_ok.do")
	/*
	 *   스프링 => 데이터를 받는 경우 
	 *     일반 데이터 (String,int...)
	 *     VO단위로 데이터를 받는다 => <input type=text name=subject>
	 *                                                ========
	 *                                                VO에 변수명이 동일
	 *     List로 데이터를 받을 수 있다 => <input type=text name=name[0]>
	 *                                              ============
	 *     같은 값 여러개  ==> String[]
	 *     <input type=checkbox name=cb>
	 *     <input type=checkbox name=cb>
	 *     <input type=checkbox name=cb>
	 */
	public String board_insert_ok(BoardVO vo) throws Exception
	{
		List<MultipartFile> list=vo.getFiles();
		if(list==null || list.size()<1)
		{
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}
		else
		{
			String fn="";
			String fs="";
			for(MultipartFile mf:list)
			{
				//System.out.println(mf.getOriginalFilename());
				String filename=mf.getOriginalFilename();
				File file=new File("c:\\upload\\"+filename);
				mf.transferTo(file);// 업로드하는 소스 
				fn+=filename+",";
				fs+=file.length()+",";
			}
			fn=fn.substring(0,fn.lastIndexOf(","));
			fs=fs.substring(0,fs.lastIndexOf(","));
			vo.setFilename(fn);
			vo.setFilesize(fs);
			vo.setFilecount(list.size());
		}
		
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping("board/detail.do")
	public String board_detail(int no,Model model)
	{
		// DB연동 
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	
	@RequestMapping("board/update.do")
	public String board_update(int no,Model model)
	{
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
	
	@RequestMapping("board/delete.do")
	public String board_delete(int no,Model model)
	{
		model.addAttribute("no", no);
		return "board/delete";
	}
	/*
	 *    1. 사용자 요청(브라우저) ==> .do
	 *       .do (요청) 
	 *       1) <a> 
	 *       2) <form>
	 *       3) ajax
	 *       4) location.href=""
	 *    2. DispatcherServlet ==> 스프링에서 지원
	 *       =================
	 *         1) 해당 RequestMapping()를 찾는다 => HandlerMapping
	 *         =================================================================
	 *         ***2) 찾은 클래스에서 요청 처리 => 프로그래머 작성 (@Controller,@RestController)
	 *         ***3) 결과값을 Model(인터페이스) : 오라클
	 *         =================================================================
	 *         4) ViewResolver ==> JSP를 찾아서 (Model => request로 변환에 전송)
	 *         =========================================================
	 *         ***5) 전송받은 request를 출력 : Jquery,Ajax,React,Vue
	 *         =========================================================
	 */
}







