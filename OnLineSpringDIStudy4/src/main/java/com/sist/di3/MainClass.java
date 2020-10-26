package com.sist.di3;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.di2.EmpDAO;
import com.sist.di2.EmpVO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(AppConfig.class);
        EmpDAO dao=(EmpDAO)app.getBean("dao");
        List<EmpVO> list=dao.empListData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob()+" "
        			+vo.getSal()+" "
        			+vo.getRegdate().toString());
        }
	}

}
