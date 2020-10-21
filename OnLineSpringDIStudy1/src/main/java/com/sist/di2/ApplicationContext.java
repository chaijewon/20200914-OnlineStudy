package com.sist.di2;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*
 *    class A
 *    {
 *        B b;
 *        public void setB(B b)
 *        {
 *           this.b=b;
 *        }
 *    }
 *    
 *    <bean id="a" class="A">
 *      <property name="b" ref="b">
 *    </bean>
 *    <bean id="b" class="B">
 */
import java.io.*;
public class ApplicationContext {
   private Map map=new HashMap();
   public ApplicationContext(String path)
   {
	   try
	   {
		   SAXParserFactory spf=SAXParserFactory.newInstance();
		   SAXParser sp=spf.newSAXParser();
		   XMLParser xp=new XMLParser();
		   sp.parse(new File(path), xp);
		   map=xp.map;
	   }catch(Exception ex){}
   }
   // DL (lookup) => 이름(key)를 가지고 클래스 객체 주소를 찾아주는 역할 
   public Object getBean(String key)
   {
	   return map.get(key);
   }
   
}
