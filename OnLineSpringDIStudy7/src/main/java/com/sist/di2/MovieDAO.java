package com.sist.di2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *    public void display(@Autowired A a,B b)
 */
import java.util.*;
@Repository
public class MovieDAO extends SqlSessionDaoSupport{
    //  CONSTRUCTOR, FIELD, METHOD, PARAMETER
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
   // ssf
	public List<MovieVO> movieListData()
	{
		return getSqlSession().selectList("movieListData");
	}
   
}






