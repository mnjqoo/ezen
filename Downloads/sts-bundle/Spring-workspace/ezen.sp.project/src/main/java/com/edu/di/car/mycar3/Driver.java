package com.edu.di.car.mycar3;

public class Driver {

	public static void main(String[] args) { //운전자가 타이어 생성 후 setter 메소드를 사용해 장착한다.
		
		Tire tireK = new KoreaTire();
		Tire tireA = new AmericaTire();
		Tire tireE = new EuropeTire();

		Car car = new Car();
		
		 car.setTire(tireK);
		 System.out.println(car.getTireBrand());
	}

}
