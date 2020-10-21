package com.sist.di2;

import com.sist.di.Sawon;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ApplicationContext app=
        		 new ApplicationContext("C:\\springDev\\springStudy\\OnLineSpringDIStudy1\\src\\main\\java\\com\\sist\\di2\\app.xml");
	    Sawon sa=(Sawon)app.getBean("sa");
	    System.out.println("sa="+sa);
	    sa.init();
	    sa.print();
	    
	    Sawon sa1=(Sawon)app.getBean("sa");
	    System.out.println("sa1="+sa1);
	    sa.init();
	    sa.print();
	}

}
