package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
// 스프링에 메모리 할당 요청 
@Repository
public class RecipeDAO extends SqlSessionDaoSupport{
    @Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
    /*
     *   <select id="recipeListData" resultType="RecipeVO" parameterType="hashmap">
		    SELECT no,title,chef,poster,num 
		    FROM (SELECT no,title,chef,poster,rownum as num 
		    FROM (SELECT no,title,chef,poster 
		    FROM recipe))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
     */
    public List<RecipeVO> recipeListData(Map map)
    {
    	/*
    	 *   getSqlSession() => 1. session=ssf.openSession()
    	 *                      2. session.close()
    	 */
    	return  getSqlSession().selectList("recipeListData",map);
    }
    /*
     *  <!-- 총페이지  -->
		  <select id="recipeTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/20.0) FROM recipe
		  </select>
     */
    public int recipeTotalPage()
    {
    	return getSqlSession().selectOne("recipeTotalPage");
    }
    
    /*
     *  <select id="recipeChefData" resultType="RecipeVO" parameterType="hashmap">
		    SELECT no,title,chef,poster,num 
		    FROM (SELECT no,title,chef,poster,rownum as num 
		    FROM (SELECT no,title,chef,poster 
		    FROM recipe WHERE chef=#{chef}))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
   */
    public List<RecipeVO> recipeChefData(Map map)
    {
    	return getSqlSession().selectList("recipeChefData",map);
    }
    /*
		  <select id="recipeChefTotalPage" resultType="int" parameterType="string">
		    SELECT CEIL(COUNT(*)/20.0) FROM recipe
		    WHERE chef=#{chef}
		  </select>
     */
    public int recipeChefTotalPage(String chef)
    {
    	return getSqlSession().selectOne("recipeChefTotalPage", chef);
    }
}




