<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.net.*"%>
<%
    request.setCharacterEncoding("UTF-8");
    // 한글 파일 
    /*
       ../board/download.jsp?fn=a.jpg
    */
    String fn=request.getParameter("fn");
    
    // 다운로드 => 서버 (설정) : 1. 파일명 , 2. 파일크기  ==> 실제데이터 보내기전에 필요한 데이터 보내준다(header)
    try
    {
    	response.setHeader("Content-Disposition", "attachment;filename="
    			                        +URLEncoder.encode(fn,"UTF-8"));
    	File file=new File("c:\\download\\"+fn);
    	// 파일 크기
    	response.setContentLength((int)file.length());
    	
    	// 다운로드 창을 보내주는 방법
    	// 실제 데이터를 복사 
    	BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
    	BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
    	// response.getOutputStream() : 다운로드를 하는 사람의 저장공간 
    	byte[] buffer=new byte[1024];
    	int i=0;// 몇바이트 읽었는지 확인 
    	while((i=bis.read(buffer, 0, 1024))!=-1)
    	{
    		// -1 EOF (End Of File)
    		bos.write(buffer, 0, i);//실제 사용자의 파일에 복사 
    	}
    	out.clear(); // out=>파일 쓰기 => 파일을 다 쓴 경우에 메모리를 지운다 
    	// out => 원래 기능 => html을 출력 (임시로 파일 출력)
    	out=pageContext.pushBody();// 원래 out의 기능으로 돌려주는 상태 
    	bis.close();// 서버의 파일 닫기
    	bos.close(); // 사용자의 파일 닫기
    }catch(Exception ex){}
    
%>




