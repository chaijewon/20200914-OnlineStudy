package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
  @Select("SELECT no,title,poster,subject "
		 +"FROM food_category")
  public List<FoodCategoryVO> foodCategoryAllData();
}
