package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.*;
import com.sist.dao.*;
import com.sist.vo.EmpVO;
public class EmpModel {
 @RequestMapping("emp/emp.do")
 public String empAllData(HttpServletRequest request)
 {
	 List<EmpVO> list=EmpDAO.empAllData();
	 request.setAttribute("list", list);
	 return "../emp/emp.jsp";
 }
}
