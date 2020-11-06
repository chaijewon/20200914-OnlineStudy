package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class BoardDAO {
	@Autowired
    private BoardMapper mapper;
	// 목록 읽기
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	// 총페이지 읽기
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	// 상세보기 
	public BoardVO boardDetailData(int no)
	{
		mapper.boardHitIncrement(no);
		return mapper.boardDeteilData(no);
	}
	// 추가 
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	// 수정 
	public BoardVO boardUpdateData(int no)
	{
		return mapper.boardDeteilData(no);
	}
	// 실제 수정 
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck=true;
			mapper.boardUpdate(vo);
		}
		else
		{
			bCheck=false;
		}
		return bCheck;
	}
	// 삭제
	public boolean boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			bCheck=true;
			mapper.boardDelete(no);
		}
		else
		{
			bCheck=false;
		}
		return bCheck;
	}
	public BoardVO boardFileInfoData(int no)
	{
		return mapper.boardFileInfoData(no);
	}
	
}
