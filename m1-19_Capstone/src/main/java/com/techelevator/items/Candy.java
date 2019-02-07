package com.techelevator.items;

public class Candy implements Item {
	
	private String name;
	private String message; 
	private double price;
	
	public Candy(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getmessage() {
		return "Munch Munch, Yum!";
	}

	@Override
	public double getPrice() {
		return 0;
	}

}