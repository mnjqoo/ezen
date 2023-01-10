package com.edu.di.car.mycar4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Driver { 
	//스프링을 통한 의존성 투입 -xml 파일을 사용
	//타이어 브랜드를 변경할 때 재컴파일/재배포 하지 않고 xml 파일만 수정하면 된다.
	public static void main(String[] args) {
		
		//ApplicationContext ctx = new GenericXmlApplicationContext("com/edu/di/car/mycar4/appCtx.xml");
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/com/edu/di/car/mycar4/appCtx.xml");
		
		Car car = ctx.getBean("car", Car.class);
		Tire tire = ctx.getBean("tire", Tire.class);
		
		car.setTire(tire);
		System.out.println(car.getTireBrand());
	}

}
