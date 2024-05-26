package com.ghada.inheritance;

public class Car {
	private int gas;

	public Car() {
		this.gas = 10;
	}

	public void display() {
		System.out.println("Gas remaining: " + this.gas + "/10");
	}

	public int getGas() {
		return gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}

}
