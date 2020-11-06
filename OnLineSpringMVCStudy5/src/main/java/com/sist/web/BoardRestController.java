package com.sist.web;

import java.io.File;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.*;
import java.util.*;
// 필요한 JavaScript
@RestController
// ajax , react 
// 단점 => IE (실행이 안됨)
public class BoardRestController {
   @Autowired
   private BoardDAO dao;
   
   @RequestMapping("board/update_ok.do")
   public String board_update_ok(BoardVO vo)
   {
	   String result="";
	   BoardVO pvo=dao.boardFileInfoData(vo.getNo());
	   List<MultipartFile> list=vo.getFiles();
	   /*
	    *     수정 
	    *     1. 데이터 추가 => 업로드가 없는 상태
	    *           => 수정
	    *              1 => 업로드 없는 상태 ===> (X)
	    *              2 => 업로드한 상태    ===> 
	    *     2. 데이터 추가 => 업로드가 된 상태
	    *           => 수정
	    *              1. => 업로드 안한 상태 ()
	    *              2. => 업로드 한 상태 ()
	    */
	   // 파일 업로드가 안된 상태
	   if(list==null || list.size()<1)
	   {
		   if(vo.getFilecount()<1)
		   {
			   vo.setFilename("");
			   vo.setFilesize("");
			   vo.setFilecount(0);
		   }
		   else
		   {
			   vo.setFilename(pvo.getFilename());
			   vo.setFilesize(pvo.getFilesize());
			   vo.setFilecount(pvo.getFilecount());
		   }
	   }
	   // 파일 업로드가 된 상태 
	   else
	   {
		   String fn="";
		   String fs="";
		   for(MultipartFile mf:list)
		   {
			   String filename=mf.getOriginalFilename();
			   File files=new File("c:\\upload\\"+filename);
			   try
			   {
			        mf.transferTo(files);// 업로드 
			   }catch(Exception ex){}
			   fn+=filename+",";
			   fs+=files.length()+",";
		   }
		   fn=fn.substring(0,fn.lastIndexOf(","));
		   fs=fs.substring(0,fs.lastIndexOf(","));
		   
		   vo.setFilename(fn);
		   vo.setFilesize(fs);
		   vo.setFilecount(list.size());
		   // 기존에 파일이 있다면 
		   if(pvo.getFilecount()>0)
		   {
			   StringTokenizer st=new StringTokenizer(pvo.getFilename(),",");
			   while(st.hasMoreTokens())
			   {
				   File file=new File("c:\\upload\\"+st.nextToken());
				   file.delete();
			   }
		   }
		   //기존 있던 파일 제거 
		   /*
		    *   오라클 : subquery , PL/SQL ==> 게시판
		    *                    ======= 1. Procedure , Function , Trigger 
		    *   마이바티스 : 동적 쿼리 , PL/SQL 호출 
		    *   
		    *   스프링 : 템플릿 (타일즈)
		    *   
		    *   데이터 분석 : 지능형 웹 
		    *   =====================================================
		    *   Front : React,Vue  => Node.js , Mongodb
		    *   =====================================================
		    *   앱 : 코틀린 
		    */
	   }
	   boolean bCheck=dao.boardUpdate(vo);
	   if(bCheck==true)
	   {
		   
		   result="<script>"
				 +"location.href=\"detail.do?no="+vo.getNo()+"\";"
				 +"</script>";
		   
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"Password Fail!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
   
   @RequestMapping("board/delete_ok.do")
   public String board_delete_ok(int no,String pwd)
   {
	   String result="";
	   // 먼저
	   BoardVO vo=dao.boardFileInfoData(no);
	   // 나중
	   boolean bCheck=dao.boardDelete(no, pwd);
	   if(bCheck==true)
	   {
		   // 파일을 삭제하는 부분 
		   try
		   {
			   if(vo.getFilecount()>0)
			   {
				   //File dir=new File("c:\\upload");
				   StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
				   while(st.hasMoreTokens())
				   {
					   File file=new File("c:\\upload\\"+st.nextToken());
					   file.delete();
				   }
			   }
		   }catch(Exception ex){}
		   result="<script>"
				 +"location.href=\"list.do\";"
				 +"</script>";
		   
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"비밀번호가 틀립니다!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
}





