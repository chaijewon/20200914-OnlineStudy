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
     public List<FoodVO> foodLocationFindData(String gu)
     {
    	 return mapper.foodLocationFindData(gu);
     }
     public List<FoodVO> foodTop10()
     {
    	 return mapper.foodTop10();
     }
     public List<RecipeVO> recipeTop10()
     {
    	 return mapper.recipeTop10();
     }
     public List<String> recipeTitleData()
     {
    	 return mapper.recipeTitleData();
     }
     public List<FoodVO> recommandFindData(String title)
     {
    	 return mapper.recommandFindData(title);
     }
}
