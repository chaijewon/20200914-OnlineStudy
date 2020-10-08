package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class UpdateModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "수정하기");
		return "board/update.jsp";
	}

}
