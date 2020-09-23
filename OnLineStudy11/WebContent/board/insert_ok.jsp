<%@page import="com.sist.dao.*,java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.oreilly.servlet.*,com.oreilly.servlet.multipart.*"%>
<%--
   화면 출력은 하지 않는다 (html을 필요로 하지 않는다)
   사용자가 보내준 글쓰기 데이터를 받아서 오라클에 전송 
   마지막에 => list.jsp로 이동 종료 
  사용자 보내준 => 데이터 받아서 처리를 하고 다른 파일  == insert_ok.jsp : list.jsp
                                           update_ok.jsp : detail.jsp
                                           delete_ok.jsp : list.jsp
 --%>
 <%
     request.setCharacterEncoding("utf-8");// 한글 디코딩
     String path="c:\\download"; // 파일이 업로드가 되면 어디에 저장 폴더 
     String enctype="UTF-8"; //한글파일명을 사용 여부 
     int size=1024*1024*100;//파일의 최대크기 
     // 사용자가 보내준 데이터를 받는다 (request=>파일을 받을 수 없다 , 일반데이터만 받는다)
     MultipartRequest mr=
          new MultipartRequest(request,path,size,enctype,new DefaultFileRenamePolicy());
     
     String name=mr.getParameter("name"); // 업로드시에만 사용
     String subject=mr.getParameter("subject");
     String content=mr.getParameter("content");
     String pwd=mr.getParameter("pwd");
     
     // 받은 데이터들을 DAO => DAO에서 오라클에 INSERT
     DataBoardVO vo=new DataBoardVO();
     vo.setName(name);
     vo.setSubject(subject);
     vo.setContent(content);
     vo.setPwd(pwd);
     
     // filename,filesize => 없는 경우 (파일을 올리지 않을 경우,파일 올릴 경우)
     String filename=mr.getOriginalFileName("upload");
     // 사용자가 보낸 파일명을 읽어 온다 
     // <input type=file name=upload size=20 class="input-sm">
     if(filename==null)//파일을 올리지 않을 경우
     {
    	 vo.setFilename("");
    	 vo.setFilesize(0);
     }
     else//파일 올릴 경우
     {
    	 File file=new File("c:\\download\\"+filename);
    	 // 업로드된 파일의 정보를 얻어온다 (파일 크기를 확인) => 다운로드 (프로그래바)
    	 vo.setFilename(filename);
    	 vo.setFilesize((int)file.length()); //length() => long
     }
     
     // DAO를 호출한 다음에 INSERT요청 => 저장하는 SQL (databoard-mapper.xml)
     response.sendRedirect("../main/main.jsp?mode=1");
 %>
 
 
 
 
 
 
 

 
 
 
 