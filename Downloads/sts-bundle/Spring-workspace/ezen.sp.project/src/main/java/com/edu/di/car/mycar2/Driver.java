package com.edu.di.car.mycar2;

public class Driver {

	public static void main(String[] args) { //운전자가 타이어를 생산 후 자동차를 생산해 타이어를 장착한다.
		
		Tire tireK = new KoreaTire();
		Tire tireE = new EuropeTire();
		
		Car car1 = new Car(tireK);
		Car car2 = new Car(tireE);
		System.out.println(car1.getTireBrand());
		System.out.println(car2.getTireBrand());

	}

}
