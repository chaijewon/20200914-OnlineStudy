package com.sist.naver;
import java.util.*;
/*
 *   jaxb => XML => Java   Java => XML  ==> bind
 *           언마셜                 마셜
 *   jaxp => dom,sax
 */
public class Channel {
    private List<Item> item=new ArrayList<Item>();

	public List<Item> getItem() {
		return item;
	}
	
	public void setItem(List<Item> item) {
		this.item = item;
	}
   
}
