package com.sist.di3;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {
   @Bean
   public DataSource dataSourceInfo()
   {
	   BasicDataSource ds=new BasicDataSource();
	   ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	   ds.setUrl("jdbc:oracle:thin:@211.238.142.181:1521:XE");
	   ds.setUsername("hr");
	   ds.setPassword("happy");
	   return ds;
   }
   @Bean
   public SqlSessionFactory sqlSessionInfo()
   {
	   SqlSessionFactory ssf=
			   (SqlSessionFactory) new SqlSessionFactoryBean();
	   DataSource ds=dataSourceInfo();
	   ((SqlSessionFactoryBean) ssf).setDataSource(ds);
	   Resource res=new ClassPathResource("Config.xml");
	   return ssf;
   }
   @Bean("dao")
   public EmpDAO empInfo()
   {
	   SqlSessionFactory ssf=sqlSessionInfo();
	   EmpDAO dao=new EmpDAO();
	   dao.setSqlSessionFactory(ssf);
	   return dao;
   }
}







