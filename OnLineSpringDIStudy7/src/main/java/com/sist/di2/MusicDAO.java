package com.sist.di2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 스프링에서 관리 
/*
 *   스프링에서 관리 대상(여러곳에서 사용하는 기능)
 *   1) DAO
 *   2) Manager
 *   ================= web에서 사용
 *   3) Model
 *   4) Service
 */
import java.util.*;
/*
 *    BasicDataSource  => SqlSessionFactoryBean => MusicDAO
 *    오라클 정보                         Connection             => PreparedStatement,ResultSet
 */
/*
 *   <bean id="dao" class="com.sist.di.MusicDAO"
       p:sqlSessionFactory-ref="ssf"
    />
 */
@Repository
// ID : musicDAO
public class MusicDAO extends SqlSessionDaoSupport{
	
    @Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<MusicVO> musicListData()
    {
    	return getSqlSession().selectList("musicListData");
    }
}










