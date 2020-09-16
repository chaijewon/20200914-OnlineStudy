package com.sist.xml;

import javax.xml.bind.annotation.XmlRootElement;

/*
 *   news => naver ==> JAXB (XML => Java Class변환) : 언마샬
 *   ==============    JAXB (Java Class=> XML) :마샬
 *   <rss>  태그 (태그) ==> 클래명 
 *     <channel> => 클래스 
 *       <item>
 *         <title>aaa</title> 변수명 
 *         <description>aaa</description>
 *         <author>aaa</author>
 *         <link>aaa</link>
 *       </item>
 *       <item>
 *         <title>aaa</title>
 *         <description>aaa</description>
 *         <author>aaa</author>
 *         <link>aaa</link>
 *       </item> ==> <item> => 50개
 *    </channel>
 *  </rss>
 *  
 *     <member>  ==> class Member
 *       <list>  ==> class List 
 *                   {
 *                       private String name
 *                       private String sex
 *                   }
 *         <name>aaa</name>
 *         <sex>aaa</sex>
 *       </list>
 *     </member>
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








