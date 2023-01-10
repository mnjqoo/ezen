package com.edu.di.car.mycar2;

public class Car { //스프링 없이 의존성 주입하기 - 생성자를 이용
	
	Tire tire;
	
	public Car(Tire tire) { //타이어의 종류를 생성자를 통해서 설정한다.
		this.tire = tire;
	}
	
	public String getTireBrand() {
		return "장착된 타이어는 " + tire.getBrand() + "입니다.";
	}
}
