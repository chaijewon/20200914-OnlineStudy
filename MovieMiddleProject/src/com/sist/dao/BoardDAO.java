package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
public class BoardDAO {
   private static SqlSessionFactory ssf;
   static 
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   // 구현 
}
