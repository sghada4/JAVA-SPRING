package com.ghada.zookeeper;

public class Bat extends Mammal {
	
	public Bat(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}
	
	public void fly() {
		System.out.println("Bat taking off.");
		super.setEnergyLevel(super.getEnergyLevel() - 50);
		super.displayEnergy();

	}

	public void eatHumans() {
		System.out.println("Eating humans.");
		super.setEnergyLevel(super.getEnergyLevel() + 25);
		super.displayEnergy();
		
	}

	public void attackTown() {
		System.out.println("Town on fire.");
		super.setEnergyLevel(super.getEnergyLevel() - 100);
		super.displayEnergy();
		
	}
}
