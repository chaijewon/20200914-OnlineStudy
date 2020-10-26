package com.sist.di3;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class EmpDAO extends SqlSessionDaoSupport{
    public List<EmpVO> empListData()
    {
    	return getSqlSession().selectList("empListData");
    }
}
