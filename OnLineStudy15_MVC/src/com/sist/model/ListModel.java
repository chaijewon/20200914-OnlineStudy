package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class ListModel {
   public void execute(HttpServletRequest request)
   {
	    String msg="ListModel=>list.jsp로 값을 전송";
	    request.setAttribute("msg", msg);
   }
}
