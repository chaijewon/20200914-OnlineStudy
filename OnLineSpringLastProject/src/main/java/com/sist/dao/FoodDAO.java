package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class FoodDAO {
     @Autowired
     private FoodMapper mapper;
     public List<FoodCategoryVO> foodCategoryAllData()
     {
    	 return mapper.foodCategoryAllData();
     }
     public List<FoodVO> foodCategoryFoodListData(int cateno)
     {
    	 return mapper.foodCategoryFoodListData(cateno);
     }
     public FoodCategoryVO foodCategoryInfoData(int no)
     {
    	 return mapper.foodCategoryInfoData(no);
     }
     public FoodVO foodDetailData(int no)
     {
    	 return mapper.foodDetailData(no);
     }
     public List<RecipeVO> foodLikeRecipeData(String finddata)
     {
    	 return mapper.foodLikeRecipeData(finddata);
     }
}
