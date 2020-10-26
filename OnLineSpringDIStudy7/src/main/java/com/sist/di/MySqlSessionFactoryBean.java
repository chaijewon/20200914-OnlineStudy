package com.sist.di;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/*
 *   <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
       p:dataSource-ref="ds"
       p:configLocation="classpath:Config.xml"
    />
 */
@Component
// ID : mySqlSessionFactoryBean
// 라이브러리 => XML(공통 사용부분)
// 사용자 정의 => Annotation
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{
    //  CONSTRUCTOR (생성자), FIELD(멤버변수), METHOD(메소드), PARAMETER(매개변수)
	/*
	 *   class A
	 *   {
	 *       @Autowired
	 *       B b;
	 *       
	 *       @Autowired
	 *       public A(B b){}
	 *       
	 *       @Autowired
	 *       public void setB(B b){}
	 *       
	 *       @Autowired
	 *       public void display(B b){}
	 *   }
	 */
	// p:dataSource-ref="ds"
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	
	
	public MySqlSessionFactoryBean()
	{
		try
		{
			// p:configLocation="classpath:Config.xml"
			Resource res=new ClassPathResource("Config.xml");
			setConfigLocation(res);
		}catch(Exception ex){}
	}
   
}



