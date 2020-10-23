package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;
import com.sist.dao.MovieDAO;
import com.sist.vo.MovieVO;

import java.text.SimpleDateFormat;
import java.util.*;
public class ReserveModel {
  @RequestMapping("reserve/reserve.do")
  public String reserve_main(HttpServletRequest request)
  {
	  request.setAttribute("main_jsp", "../reserve/reserve.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("reserve/date.do")
  public String reserve_date(HttpServletRequest request)
  {
	  String strYear=request.getParameter("year");
	  String strMonth=request.getParameter("month");
	  Date date=null;
		try {
			date = new Date();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  // 2020-10
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
	  // MM dd (X)  M d 01 ~ 09 10 11 12   09
	  // 1 2 3 .... 10 11 12
	  String today=sdf.format(date);
	  StringTokenizer st=new StringTokenizer(today,"-");
	  
	  if(strYear==null)
	  {
		  strYear=st.nextToken();// yyyy
	  }
	  
	  if(strMonth==null)
	  {
		  strMonth=st.nextToken();
	  }
	  
	  int day=Integer.parseInt(st.nextToken());// 화면 
	  int year=Integer.parseInt(strYear);
	  int month=Integer.parseInt(strMonth);
	  
	  Calendar cal=Calendar.getInstance();// Calendar클래스 생성 
	  cal.set(Calendar.YEAR,year);
	  cal.set(Calendar.MONTH,month-1);// month=>0~11
	  cal.set(Calendar.DATE,1);
	  
	  // 요일을 구한다
	  int week=cal.get(Calendar.DAY_OF_WEEK);// 1~7 ==> week-1
	  int lastday=cal.getActualMaximum(Calendar.DATE);
	  String[] strWeek={"일","월","화","수","목","금","토"};
	  System.out.println("요일:"+strWeek[week-1]);
	  System.out.println("마지막날:"+lastday);
	  
	  // jsp로 전송 
	  request.setAttribute("year", year);
	  request.setAttribute("month", month);
	  request.setAttribute("day", day);
	  request.setAttribute("week", week-1);
	  request.setAttribute("strWeek", strWeek);
	  request.setAttribute("lastday", lastday);
	  // 1일자의 요일 
	  return "../reserve/date.jsp";
  }
  @RequestMapping("reserve/movie.do")
  public String reserve_movie(HttpServletRequest request)
  {
	    List<MovieVO> list=MovieDAO.movieReserveData();
	    request.setAttribute("list", list);
	    return "../reserve/movie.jsp";
  }
  // 극장 
  // 시간
  // 인원
  // 예매 
  // 마이페이지
  // 어드민 페이지
}











