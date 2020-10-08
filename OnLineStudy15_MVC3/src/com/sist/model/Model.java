package com.sist.model;

import javax.servlet.http.HttpServletRequest;
/*
 *   execute()  ==> Struts
 *   handlerRequest() ==> Spring
 */
public interface Model {
  public String handlerRequest(HttpServletRequest request);
}
