package com.techelevator.money;

public class UserMoney {
	
	private double money;

	public double getMoney() {
		return money;
	} 
	
	public void addMoney(double value) {
		if (value >= 0) {
			money += value;
		}
		else {}
	}
	
	public void subtractMoney(double value) {
		if (money >= value) {
			money -= value;
		}
		else {}
	}
	
}