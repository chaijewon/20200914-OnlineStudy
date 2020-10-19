package com.sist.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDAO {
  private static SqlSessionFactory ssf;
  static
  {
	 ssf=CreateSqlSessionFactory.getSsf();
  }
  /*
   *   <select id="memberIdcheck" resultType="int" parameterType="string">
		    SELECT COUNT(*) FROM member
		    WHERE id=#{id}
		  </select>
   */
  public static int memberIdCheck(String id)
  {
	  SqlSession session=ssf.openSession();
	  int count=session.selectOne("memberIdcheck", id);
	  session.close();
	  return count;
  }
}



