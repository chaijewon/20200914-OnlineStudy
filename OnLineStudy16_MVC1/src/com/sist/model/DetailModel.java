package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;
// ==> 게시판 상세보기 처리 
public class DetailModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// detail.do?no=1
		// request.setParameter("no",1); ==>  ==> request.getParameter("no") ==> 1
		// 사용자가 보낸 값을 request에 묶어서 넘겨주는 역할 (톰캣)
		// service(HttpServletRequest request) => request가 매개변수 ==> 화면이 변경될때마다 request가 초기화
		// 1. 사용자 보내준 게시물번호를 받는다 
		String no=request.getParameter("no");
		// 2. BoardDAO를 통해서 게시물 한개를 읽어 온다 (BoardVO) ==> SQL문장 실행 => board-mapper.xml
		BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
		// 3. 읽어온 BoardVO값을 jsp로 전송 
		
		request.setAttribute("vo", vo);
		return "board/detail.jsp";
	}

}




