package com.sist.recommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import com.sist.dao.*;
@Component
public class RecommandManager {
   @Autowired
   private FoodDAO dao;
   public List<RecommandVO> recommandData()
   {
	   List<RecommandVO> list=new ArrayList<RecommandVO>();
	   try
	   {
		   JAXBContext jb=JAXBContext.newInstance(Rss.class);//@XMLRootElement
		   Unmarshaller un=jb.createUnmarshaller();
		   /*
		    *   Unmarshaller : XML => Java Class로 변환
		    *   Marshaller : Java Class => XML로 변환 
		    */
		   Rss rss=(Rss)un.unmarshal(new File("c:\\upload\\recommand.xml"));
		   
		   List<Item> iList=rss.getChannel().getItem();
		   
		   List<String> fList=dao.recipeTitleData();
		   // 데이터 사전 (영화제목, 맛집이름,노래 제목)
		   /*
		    *   단어 패턴 
		    *   맛있고 , 맛있게 ....  => 긍정,부정 
		    *   맛있+ *
		    *   맛없
		    */
		   Pattern[] p=new Pattern[fList.size()];
		   Matcher[] m=new Matcher[fList.size()];
		   
		   for(int i=0;i<p.length;i++)
		   {
			   p[i]=Pattern.compile(fList.get(i));
		   }
		   
		   int[] count=new int[fList.size()];
		  
		   for(Item item:iList)
		   {
			   System.out.println("데이터:"+item.getDescription());
			   for(int i=0;i<m.length;i++)
			   {
				   // contains()
				   m[i]=p[i].matcher(item.getDescription());
				   while(m[i].find())
				   {
					   String title=m[i].group();
					   System.out.println("찾은 데이터:"+title);
					   count[i]++;
				   }
			   }
		   }
		   
		   // 출력
		   int j=0;
		   for(String title:fList)
		   {
			 if(count[j]!=0)
			 {
				 RecommandVO vo=new RecommandVO();
				 vo.setTitle(title);
				 vo.setCount(count[j]);
			     System.out.println(title+":"+count[j]);
			     list.add(vo);
			 }
			     j++;
		   }
		   
	   }catch(Exception ex){System.out.println(ex.getMessage());}
	   return list;
   }
}






