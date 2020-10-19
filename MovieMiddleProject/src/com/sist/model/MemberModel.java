package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;
/*
 *     request ==> main.jsp
 *     ** 파일이 include가 되면 request를 공유
 *     ** request => forward,include
 */
public class MemberModel {
   @RequestMapping("member/join.do")
   public String member_join(HttpServletRequest request)
   {
	   request.setAttribute("main_jsp", "../member/join.jsp");//include(메인에 들어갈 파일 지정)
	   return "../main/main.jsp";//include
   }
   @RequestMapping("member/idcheck.do")
   public String member_idcheck(HttpServletRequest request)
   {
	   return "../member/idcheck.jsp";// 새로운 창을 연다 ==> Ajax 
   }
   @RequestMapping("member/idcheck_ok.do")
   public String member_idcheck_ok(HttpServletRequest request)
   {
	    String id=request.getParameter("id");
	    // DB연동
	    int count=MemberDAO.memberIdCheck(id);
	    request.setAttribute("count", count);
	    return "../member/idcheck_ok.jsp";
   }
   @RequestMapping("member/join_ok.do")
   public String member_join_ok(HttpServletRequest request)
   {
	   System.out.println("join_ok...");
	   try
	   {
		   //한글 변환 
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex){}
	   String id=request.getParameter("id");
	   String pwd=request.getParameter("pwd");
	   String name=request.getParameter("name");
	   String email=request.getParameter("email");
	   String post=request.getParameter("post");
	   String addr1=request.getParameter("addr1");
	   String addr2=request.getParameter("addr2");
	   String tel1=request.getParameter("tel1");
	   String tel2=request.getParameter("tel2");
	   String birthday=request.getParameter("birthday");
	   String content=request.getParameter("content");
	   
	   // MemberVO에 값을 설정 ==> DAO로 전송
	   MemberVO vo=new MemberVO();
	   vo.setId(id);
	   vo.setPwd(pwd);
	   vo.setName(name);
	   vo.setEmail(email);
	   vo.setBirthday(birthday);
	   vo.setPost(post);
	   vo.setAddr1(addr1);
	   vo.setAddr2(addr2);
	   vo.setTel(tel1+"-"+tel2);
	   vo.setContent(content);
	   //Insert문장 실행
	   MemberDAO.memberInsert(vo);
	   
	   return "../member/join_ok.jsp";
   }
   @RequestMapping("member/login.do")
   public String member_login(HttpServletRequest request)
   {
	   // 데이터 받기 
	   String id=request.getParameter("id");
	   String pwd=request.getParameter("pwd");
	   // DAO로 전송 결과값을 가지고 온다 
	   // 받은 결과값을 ==> login.jsp전송 
	   MemberVO vo=MemberDAO.memberLogin(id, pwd);
	   if(vo.getMsg().equals("OK"))
	   {
		   // 세션 저장위치 : 서버에 클라이언트 일부 정보를 저장해서 모든 JSP에 사용이 가능 
		   /*
		    *   서버에 저장 ( session vs cookie )
		    *   저장  setAttribute()
		    *   저장 읽기 getAttribute()
		    *   전체 해제 invalidate()
		    *   default ==> 저장 기간 : 30분
		    *   일부만 해제  => removeAttribute()
		    */
		   HttpSession session=request.getSession();
		   // request ==> Session/Cookie생성이 가능 
		   session.setAttribute("id", vo.getId());
		   session.setAttribute("name", vo.getName());
		   session.setAttribute("admin", vo.getAdmin());
		   
	   }
	   
	   request.setAttribute("msg", vo.getMsg());
	   return "../member/login.jsp";
   }
   @RequestMapping("member/logout.do")
   public String member_logout(HttpServletRequest request)
   {
	   HttpSession session=request.getSession();
	   session.invalidate();
	   return "../member/logout.jsp";
   }
}






