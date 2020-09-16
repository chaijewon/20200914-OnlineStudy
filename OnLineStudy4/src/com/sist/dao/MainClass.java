package com.sist.dao;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       List<MusicVO> list=MusicDAO.musicAllData();
       for(MusicVO vo:list)
       {
    	   System.out.println(vo.getTitle());
       }
	}

}
