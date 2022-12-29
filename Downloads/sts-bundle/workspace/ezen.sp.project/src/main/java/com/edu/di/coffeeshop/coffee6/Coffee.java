package com.edu.di.coffeeshop.coffee6;

public class Coffee {

	private Americano americano;
	
	public void setCoffee(Americano americano) {
		this.americano = americano;
	}
	
	public void coffeeType() {
		System.out.println("주문하신 커피는 " + americano.getName() + "입니다.");
	}
}
