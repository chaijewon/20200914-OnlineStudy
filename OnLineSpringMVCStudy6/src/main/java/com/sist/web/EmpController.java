package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.*;
import java.util.*;
import com.sist.dao.*;
import com.sist.r.RManager;
@Controller
public class EmpController {
   @Autowired
   private RManager rm;
   @Autowired
   private EmpDAO dao;
   @GetMapping("emp/list.do")
   public String emp_list(Model model)
   {
	   List<EmpVO> list=dao.empListData();
	   String csv="empno,ename,sal\n";
	   for(EmpVO vo:list)
	   {
		   csv+=vo.getEmpno()+","+vo.getEname()+","+vo.getSal()+"\n";
	   }
	   try
	   {
		   FileWriter fw=new FileWriter("c:\\upload\\emp.csv");
		   fw.write(csv);
		   fw.close();
	   }catch(Exception ex){}
	   rm.rGraph();
	   model.addAttribute("list", list);
	   
	   return "emp/list";
   }
}






