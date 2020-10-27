package com.sist.aop;

import org.springframework.stereotype.Repository;

// AOP는 사용자 정의(X) ==> Transaction,보안 
/*
 *       @Transactional
 *       public void allData()
 *       {
 *            insert(); // 입고
 *            insert(); // 재고
 *       }
 *       public void allData()
 *       {
 *           try
 *           {
 *                --getConnection();
 *                --conn.setAutoCommit(false);
 *                insert(); // 입고
 *                insert(); // 재고
 *                --conn.commit();
 *                
 *           }catch(Exception ex)
 *           {
 *                --conn.rollback();
 *           }
 *           finally
 *           {
 *                --conn.setAutoCommit(true);
 *                --disConnection();
 *           }
 *       }
 */
@Repository
public class MyDAO {
   public void getConnection()
   {
	   System.out.println("오라클 연결...");
   }
   public void disConnection()
   {
	   System.out.println("오라클 연결 종료...");
   }
   public void db_select(String name)
   {
	   //getConnection();
	   System.out.println("SELECT문장 실행...");
	   //disConnection();
   }
   public void db_insert()
   {
	   //getConnection();
	   System.out.println("INSERT문장 실행...");
	   //disConnection();
   }
   public void db_update()
   {
	   //getConnection();
	   System.out.println("UPDATE문장 실행...");
	   //disConnection();
   }
   public void print()
   {
	   System.out.println("완료");
   }
}
