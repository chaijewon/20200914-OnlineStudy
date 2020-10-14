package com.sist.controller;
import java.util.*;
import java.io.*;
// com.sist.model
// C:\Users\채제분\git\online\OnLineStudy18_MVCFinal\src\\com\\sist\\model
public class ComponentScan {
    public List<String> fileConfig(String pack,String path)
    {
    	List<String> list=new ArrayList<String>();
    	try
    	{
    		path=path+"\\"+pack.replace(".", "\\");
    		File dir=new File(path);
    		File[] files=dir.listFiles();
    		for(File f:files)
    		{
    			//System.out.println(f.getName());
    			String name=f.getName();
    			String ext=name.substring(name.lastIndexOf(".")+1);
    			if(ext.equals("java"))
    			{
    				String s=pack+"."+name.substring(0,name.lastIndexOf("."));
    				//System.out.println(s);
    				System.out.println("====="+pack+"=====");
    				System.out.println(s);
    				list.add(s);
    			}
    		}
    	}catch(Exception ex) {}
    	return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ComponentScan cs=new ComponentScan();
        String pack="com.sist.model";
        String path="C:\\Users\\채제분\\git\\online\\OnLineStudy18_MVCFinal\\src";
        cs.fileConfig(pack, path);
	}

}
