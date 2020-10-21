package com.sist.di2;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
// empDAO  Abc  => abc
public class EmpDAO {
	@Autowired
    private EmpMapper mapper;
	public List<EmpVO> empAllData()
	{
		return mapper.empAllData();
	}
    
}
