package com.edu.di.car.mycar6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Car2 {

	ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/com/edu/di/car/mycar6/appCtx2.xml");
	
	Tire tire = ctx.getBean("tire", Tire.class);
	
	
	
	public String getTireBrand() {
		return "장착된 타이어는" + tire.getBrand() + "입니다.";
	}
}
