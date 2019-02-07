package com.techelevator.items;

public class Gum implements Item {
	
	private String name;
	private String message; 
	private double price;

	public Gum(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getmessage() {
		return "Chew Chew, Yum!";
	}

	@Override
	public double getPrice() {
		return 0;
	}

}