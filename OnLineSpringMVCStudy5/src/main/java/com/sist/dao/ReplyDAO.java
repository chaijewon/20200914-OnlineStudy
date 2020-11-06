package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class ReplyDAO {
   @Autowired
   private ReplyMapper mapper;
   public List<ReplyVO> replyListData(int bno)
   {
	   return mapper.replyListData(bno);
   }
}
