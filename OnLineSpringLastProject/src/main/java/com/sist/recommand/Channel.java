package com.sist.recommand;
import java.util.*;
/*
 *   데이터 제공 => XML을 사용하는 이유
 *   = XML은 모든 운영체제의 호환성 
 *   = 파일 호환성 
 *   = 정확한 데이터 전송 
 *   = 모든 언어가 XML파싱 라이브러리를 가지고 있다 
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
