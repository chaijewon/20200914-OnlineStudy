package com.sist.r;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;

// C:\springDev\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\OnLineSpringMVCStudy6\
@Component
public class RManager {
   public void rGraph()
   {
	   try
	   {
	      RConnection rc=new RConnection();
	      rc.voidEval("library(rJava)");// Rserve에 R명령어 전송
	      rc.voidEval("data<-read.csv(\"c:/upload/emp.csv\",header=T,sep=\",\")");
	      rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/OnLineSpringMVCStudy6/emp.png\")");
	      //rc.voidEval("pie(data$sal,labels=data$ename,col=rainbow(15))");
	      //rc.voidEval("barplot(data$sal,names=data$ename,col=rainbow(15))");
	      rc.voidEval("hist(data$sal)");
	      rc.voidEval("dev.off()");
	      rc.close();
	   }catch(Exception ex){}
   }
}






