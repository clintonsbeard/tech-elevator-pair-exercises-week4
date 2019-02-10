package com.techelevator.items;

public class Drink implements Item {
	
	private String name; 
	private double price;
	private int quantity;

	public Drink(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getMessage() {
		return "Glug Glug, Yum!";
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public int subtractQuantity() {
		quantity --;
		return quantity;
	}

}