package com.sist.di2;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
   @Select("SELECT empno,ename,job,sal FROM emp")
   public List<EmpVO> empAllData();
}
