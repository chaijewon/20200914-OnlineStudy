package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 클라이언트에서 데이터 볼 수 있게 만드는 클래스
// WEB => JSP(View)
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MusicDAO dao=(MusicDAO)app.getBean("musicDAO");
        List<MusicVO> list=dao.musicListData();
        for(MusicVO vo:list)
        {
        	System.out.println("번호:"+vo.getMno());
        	System.out.println("노래명:"+vo.getTitle());
        	System.out.println("가수명:"+vo.getSinger());
        	System.out.println("앨범:"+vo.getAlbum());
        	System.out.println("======================================");
        }
	}

}



