package com.sist.temp;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] data={"11/26","10/20","5일전","11/30","6일전","11/25"};
        int month=11;
        //String rday="";
        int[] arr=new int[31];
        for(String s:data)
        {
        	int a=s.indexOf("/");
        	if(a>=0)
        	{
        		StringTokenizer st=new StringTokenizer(s,"/");
        		int m=Integer.parseInt(st.nextToken());
        		int d=Integer.parseInt(st.nextToken());
        		if(month==m)
        		{
        			arr[d-1]=d;
        		}
        	}
        }
	}

}
