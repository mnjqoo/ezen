package com.edu.di.car.mycar1;

public class Car {

	Tire tire;
	
	public Car() {
		tire = new KoreaTire(); //의존 관계가 일어나는 부분, 타이어 종류를 직접 지정해 만든다.
	}
	
	public String getTireBrand() {
		return "현재 장착된 타이어는 " + tire.getBrand() + "입니다.";
	}
}
