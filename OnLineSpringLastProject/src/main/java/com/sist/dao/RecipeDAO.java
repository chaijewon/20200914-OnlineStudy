package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
@Repository
public class RecipeDAO {
   @Autowired
   private MongoTemplate mt;
   public List<RecipeVO> recipeListData()
   {
	   Query query=new Query();
	   return mt.find(query, RecipeVO.class,"recipe");
   }
}
