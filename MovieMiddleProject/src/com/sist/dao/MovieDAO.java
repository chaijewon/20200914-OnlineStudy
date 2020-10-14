package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;

public class MovieDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
}
