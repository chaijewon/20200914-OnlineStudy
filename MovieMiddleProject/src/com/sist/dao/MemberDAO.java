package com.sist.dao;

import java.nio.channels.SeekableByteChannel;

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
  
  /*
   *   <select id="memberLogin" resultType="com.sist.vo.MemberVO" parameterType="String">
	     SELECT id,name,pwd,admin
	     FROM member
	     WHERE id=#{id}
	   </select>
   */
  public static MemberVO memberLogin(String id,String pwd)
  {
	  MemberVO vo=new MemberVO();
	  SqlSession session=ssf.openSession();
	  int count=session.selectOne("memberIdcheck", id);
	  if(count==0)
	  {
		  vo.setMsg("NOID");
	  }
	  else
	  {
		  MemberVO dVO=session.selectOne("memberLogin", id);
		  if(pwd.equals(dVO.getPwd()))
		  {
			  vo.setMsg("OK");
			  vo.setId(dVO.getId());
			  vo.setName(dVO.getName());
			  vo.setAdmin(dVO.getAdmin());
		  }
		  else
		  {
			  vo.setMsg("NOPWD");
		  }
	  }
	  
	  return vo;
  }
}















