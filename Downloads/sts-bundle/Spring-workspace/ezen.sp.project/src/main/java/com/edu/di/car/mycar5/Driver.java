package com.edu.di.car.mycar5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/edu/di/car/mycar5/appCtx.xml");
		
		Car car = ctx.getBean("car", Car.class);
		System.out.println(car.getTireBrand());

	}

}
