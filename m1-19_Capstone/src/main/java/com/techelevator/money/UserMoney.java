package com.techelevator.money;

public class UserMoney {
	
	private double money;

	public double getMoney() {
		return money;
	} 
	
	public void addMoney(double value) {
		money += value;
	}
	
	public void subtractMoney(double value) {
		money -= value;
	}
	
}