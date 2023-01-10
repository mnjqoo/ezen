package com.edu.di.car.mycar6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {

		//스프링 설정 파일을 읽어들인다. => 컨테이너가 구성된다.
		//컨테이너 구성 => 설정파일에서 <bean>으로 지정한 것이 Bean으로 등록된다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/edu/di/car/mycar6/appCtx.xml");
		//=> <bean id="tire" class="com.edu.di.car.mycar5.EuropeTire"/> EuropeTire tire = new EuropeTire();
		
		//필요한 bean을 가져온다.
		Car car = ctx.getBean("car", Car.class);
		System.out.println(car.getTireBrand());

	}

}
