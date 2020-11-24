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
}






