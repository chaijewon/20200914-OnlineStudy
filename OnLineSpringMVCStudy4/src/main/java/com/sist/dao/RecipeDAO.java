package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *   스프링에서 어노테이션으로 메모리 할당 요청 
 *   ==============================
 *   @Controller  : Model클래스 => return시 반드시 jsp파일명,.do
 *                  화면 변경,이동
 *                  => @ResponseBody
 *   @RestController: Model클래스 => 화면 변경이 아니다 , 스크립트,XML,JSON
 *                  => ajax , react (json)
 *   ==============================
 *   @Repository : 저장소 (데이터베이스 관련 => DAO)
 *   @Component  : Jsoup,뉴스 ,openApi
 *   @Service : DAO+DAO(DAO가 여러개 일때 조립하서 사용)
 *   ****** DAO VS Service
 *   
 *   스프링에서 어노테이션으로 할당된 클래스의 메모리 주소를 받는다 (DI)
 *   @Autowired : 스프링 내부에 찾아서 자동으로 주입
 *   @Resource : 프로그래머가 요청 => 반드시 (id명을 사용한다)
 */
import java.util.*;
@Repository
public class RecipeDAO {
   @Autowired
   private RecipeMapper mapper;
   public List<RecipeVO> recipeListData(Map map)
   {
	   return mapper.recipeListData(map);
   }
   public int recipeTotalPage()
   {
	   return mapper.recipeTotalPage();
   }
}








