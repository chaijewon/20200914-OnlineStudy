package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.BoardVO;
public class BoardDAO {
   private static SqlSessionFactory ssf;
   static 
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   // 구현 
   /*
    *   <select id="boardListData" resultType="BoardVO" parameterType="hashmap">
		    SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num
		    FROM (SELECT no,subject,name,regdate,hit,rownum as num
		    FROM (SELECT no,subject,name,regdate,hit 
		    FROM movie_board ORDER BY no DESC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
    */
   public static List<BoardVO> boardListData(Map map)
   {
	   // 연결 (오라클 연결) => Connection => SqlSession
	   SqlSession session=ssf.openSession();//getConnection()
	   List<BoardVO> list=session.selectList("boardListData",map);
	   // 반환 => DBCP
	   session.close();
	   return list;
   }
   /*
    *    DQL : SELECT
    *    DML : INSERT , UPDATE , DELETE => COMMIT
    *    DDL : CREATE , DROP ,ALTER ,RENAME
    *    DCL : GRANT , REVOKE = DBA
    *    TCL : COMMIT , ROLLBACK
    */
   /*
    *   <insert id="boardInsert" parameterType="BoardVO">
		    <selectKey keyProperty="no" resultType="int" order="BEFORE">
		     SELECT NVL(MAX(no)+1,1) as no FROM movie_board
		    </selectKey>
		    INSERT INTO movie_board VALUES(
		      #{no},
		      #{name},
		      #{subject},
		      #{content},
		      #{pwd},
		      SYSDATE,
		      0
		    )
		  </insert>
    */
   public static void boardInsert(BoardVO vo)
   {
	   SqlSession session=ssf.openSession(true);// commit(X)
	   // commit() ==> DML
	   session.insert("boardInsert",vo);
	   session.close();
   }
   /*
    *   <select id="boardTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/10.0) FROM movie_board
		  </select>
    */
   // 총페이지
   public static int boardTotalPage()
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("boardTotalPage");
	   session.close();
	   return total;
   }
}




