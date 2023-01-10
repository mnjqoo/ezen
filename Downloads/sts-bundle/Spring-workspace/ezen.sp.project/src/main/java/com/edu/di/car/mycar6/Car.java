package com.edu.di.car.mycar6;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

	@Autowired //의존성 주입
	Tire tire;
	
	public String getTireBrand() {
		return "장착된 타이어는" + tire.getBrand() + "입니다.";
	}
}
