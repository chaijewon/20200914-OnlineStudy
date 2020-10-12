package com.sist.model;

import javax.servlet.http.HttpServletRequest;
// 게시판 목록처리 ==>
/*
 *    <%@ page contentType="text/html;charset=UTF-8" %>
 *    <%
 *         목록처리 
 *         List에 값을 채운다  ==> Model
 *    %>
 *    ==============================
 *    <html>
 *     <body>
 *        List를 출력하는 내용 
 *     </body>
 *    </html>
 *    ============================== View
 */
import java.util.*;
import com.sist.dao.*;
public class ListModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 게시물 목록을 가지고 온다 => request에 값을 담아서 JSP로 전송
		String page=request.getParameter("page"); // 사용자가 요청한 페이지를 받는다 
		if(page==null) // 게시판을 실행할때 => 첫페이지 
			page="1"; //default 
		int curpage=Integer.parseInt(page);
		// 현재 페이지 ==> list목록을 가지고 온다
		Map map=new HashMap();
		// WHERE num BETWEEN #{start} AND #{end}
		// start(시작위치,끝위치) => MyBatis에서 처리  
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1); // rownum은 시작이 1부터 
		int end=rowSize*curpage;
		/*
		 *   1page ==> 1 AND 10
		 *   2page ==> 11 AND 20
		 */
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> list=BoardDAO.boardListData(map);
		
		int totalpage=BoardDAO.boardTotalPage();
		
		/*
		 *   JSP로 전송해야될 데이터는 3개 (현재페이지,총페이지 , list목록)
		 */
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		// 여기서 전송된 것이 아니라 ==> Controller에서 request를 받아서 전송 
		/*
		 *    사용자 요청   ====> Controller  ===> Model ===== BoardDAO 
		 *    Model ==== Controller ===> JSP
		 */
		return "board/list.jsp";// 어떤 JSP로 request를 보낼것인지 
	}

}





