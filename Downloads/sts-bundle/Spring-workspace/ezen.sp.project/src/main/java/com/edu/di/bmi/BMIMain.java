package com.edu.di.bmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BMIMain {

	public static void main(String[] args) {

		String conf = "classpath:applicationContext.xml"; //classpath: src/main/resources를 가리킨다.
		
		ApplicationContext ctx = new GenericXmlApplicationContext(conf); //스프링 컨테이너가 형성된다.
		
		MyInfo myInfo = ctx.getBean("myinfo", MyInfo.class);
		
		myInfo.getInfo();
	}

}
