package com.sist.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.MemberVO;

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
  
  // <insert id="memberInsert" parameterType="com.sist.vo.MemberVO"> ==> MemberModel
  public static void memberInsert(MemberVO vo)
  {
	  SqlSession session=ssf.openSession(true);
	  session.insert("memberInsert", vo);
	  session.close();
  }
}















