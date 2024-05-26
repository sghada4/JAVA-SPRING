package com.ghada.zookeeper;

public class Mammal {
	private int energyLevel;
	

	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public String displayEnergy() {
		String message = "Energy level: " + this.energyLevel;
		System.out.println(message);
		return message;

	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
