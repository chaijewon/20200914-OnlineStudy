package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "글쓰기");
		return "board/insert.jsp";
	}

}
