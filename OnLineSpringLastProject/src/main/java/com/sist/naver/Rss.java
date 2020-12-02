package com.sist.naver;

import javax.xml.bind.annotation.XmlRootElement;
/*
 *    <rss>  =======> class Rss
 *     <channel> ====> class Channel
 *       <item>   ===> class Item{}
 *         <title>aaa</title>
 *         <description>aaa</description>
 *       </item>
 *       <item>
 *         <title>aaa</title>
 *         <description>aaa</description>
 *       </item>
 *       ..
 *     </channel>
 *   </rss>
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
