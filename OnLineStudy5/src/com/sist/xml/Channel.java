package com.sist.xml;
import java.util.*;
// Item태그를 가지고 있다 => 50개 => List에 데이터를 모아준다 
public class Channel {
    private List<Item> item=new ArrayList<Item>();

	public List<Item> getItem() {
		return item;
	}
	
	public void setItem(List<Item> item) {
		this.item = item;
	}
   
}
