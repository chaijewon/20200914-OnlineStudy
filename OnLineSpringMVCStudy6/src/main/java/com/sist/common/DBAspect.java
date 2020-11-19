package com.sist.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.board.dao.DBConnection;

@Aspect
//<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
@Component
public class DBAspect {
   @Autowired
   private DBConnection dbCon;
   
   @Before("execution(* com.sist.board.dao.BoardDAO.board*(..))")
   public void before()
   {
	   dbCon.getConnection();
   }
   @After("execution(* com.sist.board.dao.BoardDAO.board*(..))")
   public void after()
   {
	   dbCon.disConnection();
   }
}










