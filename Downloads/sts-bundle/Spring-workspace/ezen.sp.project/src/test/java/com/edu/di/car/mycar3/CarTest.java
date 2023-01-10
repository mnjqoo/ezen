package com.edu.di.car.mycar3;

import org.junit.Test;

public class CarTest {

	@Test
	public void 자동차_한국타이어_장착_타이어브랜드_테스트() {
		
		Car car = new Car();
		car.setTire(new KoreaTire());
		System.out.println(car.getTireBrand());
	}
	
	@Test
	public void 자동차_미국타이어_장착_타이어브랜드_테스트() {
		
		Car car = new Car();
		car.setTire(new AmericaTire());
		System.out.println(car.getTireBrand());
	}
	
	@Test
	public void 자동차_유럽타이어_장착_타이어브랜드_테스트() {
		
		Car car = new Car();
		car.setTire(new EuropeTire());
		System.out.println(car.getTireBrand());
	}
	
}
