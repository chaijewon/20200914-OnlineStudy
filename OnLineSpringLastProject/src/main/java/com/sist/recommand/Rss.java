package com.sist.recommand;

import javax.xml.bind.annotation.XmlRootElement;

/*
 *   네이버 => key (카페)
 *   <rss>
 *     <channel>
 *       <item></item> => 100
 *       <item></item>
 *       <item></item>   ==> List
 *     </channel>
 *   </rss>
 *   
 *   => class Rss
 *      {
 *          Channel channel=new Channel()
 *      }
 *   => JAXB => XML의 모든 태그로 클래스로 매칭
 */
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





