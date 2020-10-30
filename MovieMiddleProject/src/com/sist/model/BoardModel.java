package com.sist.model;
/*
 *   1. table 제작 (오라클)
 *   2. mapper , Config에 등록 
 *   3. DAO 셋팅
 *   ============================
 *   4. jsp
 *   5. Model
 *   
 *   Controller (DispatcherServlet)
 *     |
 *   Model <===> DAO
 *     | request,session
 *    jsp(View)   ============> MVC
 *    === 출력
 *            request               request  
 *    list.do  ===> DispatcherServlet ==> Model  ====> DAO
 *                                    <==
 *             <===                  request
 *             request
 *    =======
 *      요청 
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;
public class BoardModel {
   @RequestMapping("board/list.do")
   public String board_list(HttpServletRequest request)
   {
	   // jsp => 데이터 전송 (오라클 연동 => DAO)
	   return "../main/main.jsp";//include
   }
}






