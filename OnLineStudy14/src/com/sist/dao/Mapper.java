package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import java.util.*;
import com.sist.dao.*;
public interface Mapper {
  @Select("SELECT * FROM emp")
  public List<RecipeVO> listAllData();
}
