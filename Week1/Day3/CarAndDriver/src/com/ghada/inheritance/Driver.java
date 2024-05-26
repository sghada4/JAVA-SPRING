package com.ghada.inheritance;

public class Driver extends Car {
	
	public void driving() {
		super.setGas(super.getGas()-1);
		System.out.println("You drive the car.");
		super.display();
	}
	
	public void usingBoosters() {
		super.setGas(super.getGas()-3);
		System.out.println("You are using boosters.");
		super.display();
	}
	
	public void refueling() {
		super.setGas(super.getGas()-2);
		System.out.println("You are refueling.");
		super.display();
	}
	

}
