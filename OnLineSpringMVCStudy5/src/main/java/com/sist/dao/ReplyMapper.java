package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import java.util.*;
public interface ReplyMapper {
  // 목록 읽기
  @Select("SELECT no,bno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
		 +"FROM spring_reply "
		 +"WHERE bno=#{bno} "
		 +"ORDER BY no DESC")
  public List<ReplyVO> replyListData(int bno);
}
