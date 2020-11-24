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
}
