package com.edu.di.coffeeshop.coffee2;

public class CoffeeShop {

	public static void main(String[] args) {
		
		Coffee coffee1 = new Coffee(new IceAmericano());
		coffee1.coffeeType();
		
		Coffee coffee2 = new Coffee(new HotAmericano());
		coffee2.coffeeType();
	}

}
