package com.techelevator.items;

public class Drink implements Item {
	
	private String name;
	private String message; 
	private double price;

	public Drink(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getmessage() {
		return "Glug Glug, Yum!";
	}

	@Override
	public double getPrice() {
		return 0;
	}

}