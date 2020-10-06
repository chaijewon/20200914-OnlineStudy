package com.sist.manager;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
public class BoardManager {
   public void boardListData(HttpServletRequest request)
   {
	   // page를 받는다 
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1"; //JSP에서 page가 존재(객체)
	   int curpage=Integer.parseInt(page);
	   // 페이지 나누기 
	   int rowSize=10;
	   int start=(curpage*rowSize)-(rowSize-1);
	   int end=curpage*rowSize;
	   /*
	    *     <select id="boardListData" resultType="BoardVO" parameterType="hashmap">
			    SELECT no,subject,name,regdate,hit,num 
			    FROM (SELECT no,subject,name,regdate,hit,rownum as num 
			    FROM (SELECT no,subject,name,regdate,hit 
			    FROM freeboard ORDER BY no DESC))
			    WHERE num BETWEEN #{start} AND #{end}
			  </select>
	    */
	   // 결과값 읽기
	   Map map=new HashMap();
	   map.put("start", start);
	   map.put("end",end);
	   List<BoardVO> list=BoardDAO.boardListData(map);
	   request.setAttribute("list", list);//JSP에서 request를 받아서 JSTL,EL
	   // M(Model) => 자바 (기능(요청) 처리) , V(View) => JSP(HTML) => 출력만 한다 
	   // 자바 <==> JSP(HTML)   => MV구조 ==> MVC // 자바와 HTML분리 (데이터를 받을 경우 => request,session)
	   // 데이터 공유 => session에 저장 
	   // 한개의 JSP에서만 사용 => request에 저장 
	   // Front-End (React=>Redux, Vue => Vuex) => Flux
	   Date date=new Date();
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	   String today=sdf.format(date);
	   request.setAttribute("today", today);
	   /*
	    *   request.setAttribute() => JSP출력할 내용을 request에 담아서 전송 
	    *   => 1번만 사용하는 것이 아니라 => 필요한 모든 데이터를 담을 수 있다 
	    */
	   int totalpage=BoardDAO.boardTotalPage();
	   
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
   }
   // JSP에서 보낸 사용자 요청정보를 받아서 처리 => 결과값을 (request에 첨부해서 전송)
   public void boardDetailData(HttpServletRequest request)
   {
	   // request => JSP에서 전송
	   // 요청한 게시물을 찾는다  ==> no값
	   // detail.jsp?no=10
	   String no=request.getParameter("no");
	   // 데이터 읽기 시작  (데이터베이스)
	   BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
	   // 결과값을 request에 담아서 => JSP로 전송 
	   request.setAttribute("vo", vo);
	   
   }
   // 게시물 추가 
   public void boardInsert(HttpServletRequest request,HttpServletResponse response)
   {
	   try
	   {
		   // 한글 처리 
		   request.setCharacterEncoding("UTF-8");
		   // 사용자 요청값 받기 
		   String name=request.getParameter("name");
		   String subject=request.getParameter("subject");
		   String content=request.getParameter("content");
		   String pwd=request.getParameter("pwd");
		   
		   BoardVO vo=new BoardVO();
		   vo.setName(name);
		   vo.setSubject(subject);
		   vo.setContent(content);
		   vo.setPwd(pwd);
		   // BoardDAO ==> 처리 (오라클 insert) => insert (SQL)
		   BoardDAO.boardInsert(vo);
		   // 이동 => list.jsp
		   response.sendRedirect("list.jsp");
	   }catch(Exception ex){}
   }
   // 모든 JSP에서 요청한 내용 ==> 처리해주는 장소
   // 객체지향 프로그램 : 재사용 (기능별 분리 ===> 조립)
   // 필수 (사이트) : 게시판 (CURD), 회원 , 공지사항 
   public void boardUpdateData(HttpServletRequest request)
   {
	   // detail.jsp :  update.jsp?no=${vo.no }
	   String no=request.getParameter("no");
	   BoardVO vo=BoardDAO.boardUpdateData(Integer.parseInt(no));
	   // vo ==> update.jsp로 전송 
	   request.setAttribute("vo", vo);
   }
   // 실제 수정하기 
   public void boardUpdate(HttpServletRequest request)
   {
	   try
	   {
		   // 한글 변환 => 컴파일예외처리 
		   request.setCharacterEncoding("UTF-8");
		   // 사용자가 보내준 데이터 받기 
		   String no=request.getParameter("no");
		   String name=request.getParameter("name");
		   String subject=request.getParameter("subject");
		   String content=request.getParameter("content");
		   String pwd=request.getParameter("pwd");
		   // BoardVO에 묶어서 => BoardDAO로 전송 ==> 오라클에서 수정
		   /*
		    *    BoardManager : 사용자 요청을 받아서 처리 
		    *    BoardDAO : 오라클 연결 => 오라클에서 기능 수행이 가능 
		    *    BoardVO : 데이터를 묶어서 전송하는 역할
		    *    ~.jsp : 결과값 출력만 하는 역할 
		    */
		   BoardVO vo=new BoardVO();
		   vo.setName(name);
		   vo.setSubject(subject);
		   vo.setContent(content);
		   vo.setPwd(pwd);
		   vo.setNo(Integer.parseInt(no));
		   // vo=>DAO로 전송 
		   
		   boolean bCheck=BoardDAO.boardUpdate(vo);
		   
		   // 결과값 => update_ok.jsp로 전송 
		   request.setAttribute("bCheck", bCheck);// 처리(X) => javascript를 전송할 수 없다 
		   // request를 통해서 보낼 수 있는 데이터 => Object 
		   // Spring : RestController
		   request.setAttribute("no", vo.getNo());
	   }catch(Exception ex) {}
   }
   
   
}





