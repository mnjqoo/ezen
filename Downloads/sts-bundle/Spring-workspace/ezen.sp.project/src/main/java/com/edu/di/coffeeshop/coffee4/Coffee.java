package com.edu.di.coffeeshop.coffee4;

public class Coffee {

	private HotAmericano hme;
	
	public Coffee() {
		hme = new HotAmericano();
	}
	
	public void CoffeeType() {
		System.out.println("주문하신 커피는 " + hme.getName() + "입니다.");
	}
}
