package com.sist.news;

import javax.xml.bind.annotation.XmlRootElement;
// newsseacrch.naver.com/search.naver?where=rss&query=레시피
@XmlRootElement
public class Rss {
    private Channel channel=new Channel();

	public Channel getChannel() {
		return channel;
	}
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
   
}
