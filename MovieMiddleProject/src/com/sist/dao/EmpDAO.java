package com.sist.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.*;
import com.sist.vo.*;
public class EmpDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   public static List<EmpVO> empAllData()
   {
	   SqlSession session=ssf.openSession();
	   List<EmpVO> list=session.selectList("empDetpJoinData");
	   session.close();
	   return list;
   }
}
