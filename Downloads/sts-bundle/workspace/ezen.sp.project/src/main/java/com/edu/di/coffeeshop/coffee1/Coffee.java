package com.edu.di.coffeeshop.coffee1;

public class Coffee {

	private IceAmericano ame;
	private HotAmericano hme;
	public Coffee() {
		hme = new HotAmericano();
	}
	
	public void coffeeType() {
		System.out.println(hme.getName());
	}
}
