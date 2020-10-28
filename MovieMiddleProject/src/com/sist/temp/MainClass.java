package com.sist.temp;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String res=getRand(); System.out.println(res); StringTokenizer st=new
		 * StringTokenizer(res,","); MovieDAO dao=new MovieDAO();
		 * while(st.hasMoreTokens()) { String s=st.nextToken(); String
		 * r=dao.theaterInfoData(Integer.parseInt(s)); System.out.println(r); }
		 */
		/*
		 * MovieDAO dao=new MovieDAO(); List<Integer> list=dao.movieData(); for(int
		 * no:list) { String res=getRand(); dao.theaterInsert(no, res); }
		 * System.out.println("Insert 완료!!");
		 */
		MovieDAO dao=new MovieDAO();
		for(int i=1;i<=18;i++)
		{
			String rday=getRand();
			dao.theater_rday(i, rday);
		}
		System.out.println("Update완료");
	}
	public static String getRand()
	{
		String result="";
		int count=7+(int)(Math.random()*6);// 5~14
		System.out.println(count);
		int[] com=new int[count];
		int su=0;
		boolean bCheck=false;
		for(int i=0;i<count;i++)
		{
			bCheck=true;
			while(bCheck)
			{
				su=(int)(Math.random()*31)+1;
				bCheck=false;
				for(int j=0;j<i;j++)
				{
					if(com[j]==su)
					{
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		
		for(int a:com)
		{
			result+=a+",";
		}
		result=result.substring(0,result.lastIndexOf(","));
		return result;
	}

}






