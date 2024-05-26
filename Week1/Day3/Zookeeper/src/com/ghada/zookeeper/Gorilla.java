package com.ghada.zookeeper;

public class Gorilla extends Mammal {
	
	

	public Gorilla(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}

	public void throwSomething() {
		System.out.println("Throwing things at people.");
		super.setEnergyLevel(super.getEnergyLevel() - 5);
		super.displayEnergy();

	}

	public void eatBananas() {
		System.out.println("Eating bananas.");
		super.setEnergyLevel(super.getEnergyLevel() + 10);
		super.displayEnergy();
		
	}

	public void climb() {
		System.out.println("Climbing a tree.");
		super.setEnergyLevel(super.getEnergyLevel() - 10);
		super.displayEnergy();
		
	}

}
