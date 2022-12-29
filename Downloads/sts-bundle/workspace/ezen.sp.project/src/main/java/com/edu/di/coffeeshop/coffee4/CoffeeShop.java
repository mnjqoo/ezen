package com.edu.di.coffeeshop.coffee4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CoffeeShop {
	//스프링 컨테이너의 기본 객체 관리는 컨테이너 생성 시 자신이 포함할 Bean 객체를 모두 생성한다.
	//객체를 제거하는 것은 컨테이너가 삭제될 때 다 제거된다.
	public static void main(String[] args) { 

		ApplicationContext ctx = new GenericXmlApplicationContext("com/edu/di/coffeeshop/coffee4/applicationContext.xml");
		
		Coffee coffee = ctx.getBean("coffee", Coffee.class);
		
		coffee.CoffeeType();
		
	}

}
