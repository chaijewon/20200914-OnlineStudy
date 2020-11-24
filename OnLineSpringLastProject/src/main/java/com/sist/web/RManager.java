package com.sist.web;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
// C:\springDev\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\OnLineSpringLastProject
@Component
public class RManager {
  public void graph(int no)
  {
	  try
	  {
		  RConnection rc=new RConnection();
		  rc.voidEval("library(rJava)");
		  rc.voidEval("library(KoNLP)");
		  rc.voidEval("library(wordcloud)");
		  
		  rc.voidEval("data<-readLines(\"c:/upload/naver.txt\",encoding = \"UTF-8\")");
		  rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/OnLineSpringLastProject/naver"+no+".png\")");
		  rc.voidEval("data1<-sapply(data, extractNoun,USE.NAMES = F)");
		  rc.voidEval("data2<-unlist(data1)");
		  rc.voidEval("data3<-Filter(function(x){nchar(x)>=2},data2)");
		  rc.voidEval("data4<-table(data3)");
		  rc.voidEval("data5<-head(sort(data4,decreasing = T),50)");
		  rc.voidEval("wordcloud(names(data5),freq=data5,min.freq = 3,max.words = 100,random.order = F,rot.per=.1,scale = c(4,0.5),colors = rainbow(15))");
		  rc.voidEval("dev.off()");
		  rc.close();
	  }catch(Exception ex){System.out.println(ex.getMessage());}
  }
}
