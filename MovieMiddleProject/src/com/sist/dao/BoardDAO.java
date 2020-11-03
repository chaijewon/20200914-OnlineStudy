package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.BoardVO;
import com.sist.vo.ReplyVO;
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
   // 내용보기
   /*
    *    <update id="hitIncrement" parameterType="int">
		    UPDATE movie_board SET
		    hit=hit+1
		    WHERE no=#{no}
		  </update>
		  <select id="boardDetailData" parameterType="int" resultType="BoardVO">
		    SELECT * FROM movie_board
		    WHERE no=#{no}
		  </select>
		  
		  JSP <=========== Model (데이터받기,이동할 주소) <======> (Mapper=>DAO)DAO  
		  링크 / 클릭 (.do)
    */
   public static BoardVO boardDetailData(int no)
   {
	   // 연결
	   SqlSession session=ssf.openSession();
	   // 조회수 증가 
	   session.update("boardHitIncrement",no);
	   session.commit();
	   // 데이터 읽기
	   BoardVO vo=session.selectOne("boardDetailData", no);
	   session.close();
	   return vo;
   }
   /*
    *  <insert id="replyInsert" parameterType="ReplyVO">
	    <!-- 적용할 수 없다(한번) -->
	    <selectKey keyProperty="no" resultType="int" order="BEFORE">
	      SELECT NVL(MAX(no)+1,1) as no FROM movie_reply
	    </selectKey>
	    INSERT INTO movie_reply(no,bno,id,name,msg,group_id) VALUES(
	      #{no},
	      #{bno},
	      #{id},
	      #{name},
	      #{msg},
	      (SELECT NVL(MAX(group_id)+1,1) FROM movie_reply)
	    )
	  </insert>
    */
   public static void replyInsert(ReplyVO vo)
   {
	   SqlSession session=ssf.openSession(true);// commit(X)
	   // commit() ==> DML
	   session.insert("replyInsert",vo);
	   session.close();
   }
   /*
    *   <select id="replyListData" resultType="ReplyVO" parameterType="int">
		    SELECT no,bno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,
		    group_tab FROM movie_reply
		    WHERE bno=#{bno}
		  </select>
    */
   public static List<ReplyVO> replyListData(int bno)
   {
	   SqlSession session=ssf.openSession();
	   List<ReplyVO> list=session.selectList("replyListData",bno);
	   session.close();
	   return list;
   }
   /*
    *   <select id="replyParentData" parameterType="int" resultType="ReplyVO">
   SELECT group_id,group_step,group_tab
   FROM movie_reply
   WHERE no=#{no}
  </select>
  <update id="replyStepIncrement" parameterType="ReplyVO">
    UPDATE movie_reply SET
    group_step=group_step+1
    WHERE group_id=#{group_id} AND group_step>#{group_step}
  </update>
  <insert id="resplyReplyInsert" parameterType="ReplyVO">
    <selectKey keyProperty="no" resultType="int" order="BEFORE">
      SELECT NVL(MAX(no)+1,1) as no FROM movie_reply
    </selectKey>
    INSERT INTO movie_reply(no,bno,id,name,msg,group_id,group_step,group_tab,root,depth) VALUES(
      #{no},
      #{bno},
      #{id},
      #{name},
      #{msg},
      #{group_id},
      #{group_step},
      #{group_tab},
      #{root},
      0
    )
  </insert>
  <update id="replyDepthIncrement" parameterType="int">
    UPDATE movie_reply SET
    depth=depth+1
    WHERE no=#{no}
  </update>
    */
   public static void replyReplyInsert(int root,ReplyVO vo)
   {
	   SqlSession session=ssf.openSession();
	   ReplyVO pvo=session.selectOne("replyParentData",root);
	   session.update("replyStepIncrement", pvo);
	   vo.setGroup_id(pvo.getGroup_id());
	   vo.setGroup_step(pvo.getGroup_step()+1);
	   vo.setGroup_tab(pvo.getGroup_tab()+1);
	   vo.setRoot(root);
	   
	   session.insert("resplyReplyInsert", vo);
	   session.update("replyDepthIncrement", root);
	   session.commit();
	   session.close();
   }
   /*
    *  <update id="replyUpdate" parameterType="ReplyVO">
		    UPDATE movie_reply SET
		    msg=#{msg}
		    WHERE no=#{no}
		  </update>
    */
   public static void replyUpdate(ReplyVO vo)
   {
	   SqlSession session=ssf.openSession(true);
	   session.update("replyUpdate",vo);
	   session.close();
	   
   }
}




