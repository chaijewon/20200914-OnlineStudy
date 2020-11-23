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
}
