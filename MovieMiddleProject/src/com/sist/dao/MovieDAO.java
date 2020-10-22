package com.sist.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.*;
import com.sist.vo.*;
public class MovieDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   /*
    *   <select id="movieListData" resultType="MovieVO" parameterType="hashmap">
		    SELECT no,poster,title,num
		    FROM (SELECT no,poster,title,rownum as num
		    FROM (SELECT no,poster,title 
		    FROM daum_movie WHERE cateno=#{cateno} ORDER BY score DESC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
		  <select id="movieTotalPage" resultType="int" parameterType="int">
		    SELECT CEIL(COUNT(*)/12.0) FROM daum_movie
		    WHERE cateno=#{cateno}
		  </select>
    */
   public static List<MovieVO> movieListData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<MovieVO> list=session.selectList("movieListData",map);
	   session.close();// 반환
	   return list;
   }
   public static int movieTotalPage(int cateno)
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("movieTotalPage", cateno);
	   session.close();
	   return total;
   }
   /*
    *   <select id="movieNewsData" resultType="com.sist.vo.NewsVO" parameterType="hashmap">
		    <!-- Class.forName("com.sist.vo.NewsVO") 
		        private String title;
			    private String poster;
			    private String link;
			    private String content;
			    private String author;
		    -->
		    SELECT title,poster,link,content,author,num
		    FROM (SELECT title,poster,link,content,author,rownum as num 
		    FROM (SELECT title,poster,link,content,author 
		    FROM daum_news))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
    */
   // DAO ==> Model (List=>Controller=>JSP) => forward
   public static List<NewsVO> movieNewsData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<NewsVO> list=session.selectList("movieNewsData",map);
	   session.close();
	   return list;
   }
   /*
    *   <select id="newsTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/20.0) FROM daum_news
		  </select>
    */
   public static int newsTotalPage()
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("newsTotalPage");
	   session.close();
	   return total;
   }
   /*
    *   <select id="movieTotalData" resultType="MovieVO" parameterType="hashmap">
		    SELECT no,poster,title,num
		    FROM (SELECT no,poster,title,rownum as num
		    FROM (SELECT no,poster,title 
		    FROM daum_movie ORDER BY score DESC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
		  <select id="movieTotalPage2" resultType="int" parameterType="int">
		    SELECT CEIL(COUNT(*)/12.0) FROM daum_movie
		  </select>
    */
   public static List<MovieVO> movieTotalData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<MovieVO> list=session.selectList("movieTotalData",map);
	   session.close();// 반환
	   return list;
   }
   public static int movieTotalPage2()
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("movieTotalPage2");
	   session.close();
	   return total;
   }
   /*
    *   <update id="hitIncrement" parameterType="int">
		    UPDATE daum_movie SET
		    hit=hit+1
		    WHERE no=#{no}
		  </update>
		  <select id="movieDetailData" resultType="MovieVO" parameterType="int">
		    SELECT * FROM daum_movie
		    WHERE no=#{no}
		  </select>
    */
   public static MovieVO movieDetailData(int no)
   {
	   SqlSession session=ssf.openSession();
	   session.update("hitIncrement", no);
	   session.commit();
	   MovieVO vo=session.selectOne("movieDetailData", no);
	   session.close();
	   return vo;
   }
   
   public static List<MovieVO> movieReserveData()
   {
	   SqlSession session=ssf.openSession();
	   List<MovieVO> list=session.selectList("movieReserveData");
	   session.close();// 반환
	   return list;
   }
}




