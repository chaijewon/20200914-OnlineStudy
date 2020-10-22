package com.sist.di;
import java.util.*;
public class School {
   private List<Student> list=
		   new ArrayList<Student>();

	public void setList(List<Student> list) {
		this.list = list;
	}
   
	public void print()
	{
		for(Student s:list)
		{
			System.out.println(s.getName()+" "
					+s.getKor()+" "
					+s.getEng()+" "
					+s.getMath());
		}
	}
}
