package com.techelevator.items;

public class Chips implements Item {
	
	private String name;
	private String message; 
	private double price;
	
	public Chips(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getmessage() {
		return "Crunch Crunch, Yum!";
	}

	@Override
	public double getPrice() {
		return 0;
	}

}
