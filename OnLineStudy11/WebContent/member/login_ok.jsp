<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    // 1. 사용자가 보낸 id,pwd
    String id=request.getParameter("id");
    //<input type=text class="input-sm" name=id> => hong
    //
    String pwd=request.getParameter("pwd");
    //<input type=password class="input-sm" name=pwd>
    // pwd=1234
    // login_ok.jsp?id=hong&pwd=1234
    // 2. DAO에서 => 로그인 
    // mapper.xml ==> SQL => DAO에 처리 
    MemberVO vo=MemberDAO.memberLogin(id, pwd);
    // 3. 로그인이 되면 => main.jsp
    		
    if(vo.getMsg().equals("NOID")) // id가 틀린경우 => 로그인 창으로 이동
    {
%>
        <!-- Ajax -->
        <script>
        alert("ID가 존재하지 않습니다!!");
        history.back();
        </script>
<%
    }
    else if(vo.getMsg().equals("NOPWD")) // id가 존재 => 비밀번호가 틀린 경우  => 로그인 창으로 이동
    {
%>
        <script>
        alert("비밀번호가 틀립니다!!");
        history.back();
        </script>
<%
    }
    else // OK ==> 로그인 ==> main.jsp
    {
    	// id,name,admin=> 서버에 저장을 하고 => main.jsp로 이동 (session)
        session.setAttribute("id", vo.getId());
    	session.setAttribute("name", vo.getName());
    	session.setAttribute("admin", vo.getAdmin());
    	// 사용하고 있는(프로젝트 안에 있는 모든 JSP에서 세션에 등록된 모든 데이터 사용이 가능)
    	response.sendRedirect("../main/main.jsp");
    }
%>








