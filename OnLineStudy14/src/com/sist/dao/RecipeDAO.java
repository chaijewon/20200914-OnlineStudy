package com.sist.dao;
import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class RecipeDAO {
   // XML을 파싱 
   private static SqlSessionFactory ssf;
   static 
   {
	   try
	   {
		   // XML을 읽기 시작 
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // 기능 처리  ==> jstl + el  ==> 망고플레이트 ==> 지도
   // 1. 레시피 목록
   public static List<RecipeVO> recipeListData(Map map)
   {
	   List<RecipeVO> list=new ArrayList<RecipeVO>();
	   SqlSession session=null;
	   try
	   {
		   // 연결
		   session=ssf.openSession();
		   // 데이터 처리
		   list=session.selectList("recipeListData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
   // 총페이지 구하기 
   public static int recipeTotalPage()
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   // 연결
		   session=ssf.openSession();
		   total=session.selectOne("recipeTotalPage");
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return total;
   }
   // 2. chef 목록
   public static List<ChefVO> chefListData(Map map)
   {
	   List<ChefVO> list=new ArrayList<ChefVO>();
	   SqlSession session=null;
	   try
	   {
		   // 연결
		   session=ssf.openSession();
		   // 데이터 처리
		   list=session.selectList("chefListData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
   // 총페이지 구하기 
   public static int chefTotalPage()
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   // 연결
		   session=ssf.openSession();
		   total=session.selectOne("chefTotalPage");
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return total;
   }
   // 3. chef => 레시피 
   // 4. 검색
}







