package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
/*
 *    substring(0,10)
 *    public MapperFacoryBean implements EmpMapper
 *    {
 *        public List<EmpVO> empListData()
 *        {
 *            List<EmpVO> list=new ArrayList<EmpVO>();
 *            getConnection();
 *            String sql="SELECT * FROM emp";
 *            ps=conn.preparedStatement(sql);
 *            ResultSet rs=ps.executeQuery()
 *            while(rs.next())
 *            {
 *                EmpVO vo=new EmpVO();
 *                vo.set...
 *            }
 *            return list;
 *        }
 *    }
 */
public interface EmpMapper {
  @Select("SELECT * FROM emp")
  public List<EmpVO> empListData();
}
