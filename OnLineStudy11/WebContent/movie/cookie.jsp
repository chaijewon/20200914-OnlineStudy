<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
  String no=request.getParameter("no");
  MovieVO vo=MovieDAO.movieDetailData(Integer.parseInt(no));
  Cookie cookie=new Cookie("m"+no,vo.getPoster());
  cookie.setPath("/");
  //cookie.setDomain("211.238.142.181");
  // 저장 
  // 기간 
  cookie.setMaxAge(60*60); // 하루 저장  (초단위)
  // 클라이언트 컴퓨터로 전송 
  // http://211.238.142.181
  response.addCookie(cookie);
  response.sendRedirect("../main/main.jsp?mode=8&no="+no);
  // 한 파일안에서 => 응답을 두번을 받을 수 없다
  /*
       1. cookie.jsp => cookie를 받아서 저장 
       2. 이동 => 상세보기 화면을 다시 받는다 detail.jsp
       
       => 쿠키 생성단계
          1. 쿠키 생성 단계
              Cookie cookie=new Cookie(키,값);
          2. 쿠키 저장 단계
              cookie.setAge(60*60*24)
          3. 쿠키 전송 단계  ==> 클라이언트로 전송시에 response (클라이언트 요청 한번만 수행)
                                                    쿠키 전송 , HTML전송 , 헤더 전송 
              response.addCookie(cookie); ==> 클라이언트에 전송 
              
       => 쿠키를 가지고 오는 방법 
          => 쿠키가 여러개 생성 
          Cookie[] cookies=request.getCookies();
          // 본인 컴퓨터에서 저장된 Cookie를 가지고 온다 
          for(Cookie c:cookies)
          {
        	  => c.getName(); => 키읽을 경우
        	  => c.getValue(); => 키에 해당되는 값을 읽을 경우에 사용 
        	  => Cookie 삭제
        	     c.setAge(0)
        	     => 삭제하고 클라이언트에 전송 => response.addCookie()
        	     확인 => getName()
          }
  */
%>






