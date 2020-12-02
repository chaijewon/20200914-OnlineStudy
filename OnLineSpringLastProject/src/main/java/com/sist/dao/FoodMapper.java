package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
  @Select("SELECT no,title,poster,subject "
		 +"FROM food_category")
  public List<FoodCategoryVO> foodCategoryAllData();
  @Select("SELECT no,title,score,poster,addr,tel "
		 +"FROM food_detail "
		 +"WHERE cateno=#{cateno}")
  public List<FoodVO> foodCategoryFoodListData(int cateno);
  @Select("SELECT title,subject "
		 +"FROM food_category "
		 +"WHERE no=#{no}")
  public FoodCategoryVO foodCategoryInfoData(int no);
  
  @Select("SELECT * FROM food_detail "
		 +"WHERE no=#{no}")
  public FoodVO foodDetailData(int no);
  
  @Select("SELECT title,poster,chef,rownum "
		 +"FROM recipe "
		 +"WHERE rownum<=5 AND "
		 +"REGEXP_LIKE(title,#{finddata})")// 국수 / 면   => 국수|면
  public List<RecipeVO> foodLikeRecipeData(String finddata);
  
  @Select("SELECT no,poster,title,rownum "
		 +"FROM food_detail "
		 +"WHERE rownum<=12 AND "
		 +"addr LIKE '%'||#{gu}||'%'")
  public List<FoodVO> foodLocationFindData(String gu);
  
  @Select("SELECT no,title,poster,rownum "
		 +"FROM (SELECT no,title,poster "
		 +"FROM food_detail ORDER BY good DESC) "
		 +"WHERE rownum<=5")
  public List<FoodVO> foodTop10();
  
  @Select("SELECT no,title,poster,rownum "
		 +"FROM recipe "
		 +"WHERE rownum<=5")
  
  public List<RecipeVO> recipeTop10();
  
  @Select("SELECT DISTINCT title FROM food_detail")
  public List<String> recipeTitleData();
  
  @Select("SELECT no,title,poster "
		 +"FROM food_detail "
		 +"WHERE title=#{title}")
  public List<FoodVO> recommandFindData(String title);
  
}






