package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDAO {
   @Autowired
   private EmpMapper mapper;
   public List<EmpVO> empListData()
   {
	   return mapper.empListData();
   }
   
}
