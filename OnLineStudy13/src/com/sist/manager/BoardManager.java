package com.sist.manager;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

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
   }
}





