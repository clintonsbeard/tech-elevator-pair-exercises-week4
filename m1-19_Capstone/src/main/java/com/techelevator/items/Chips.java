package com.techelevator.items;

public class Chips implements Item {
	
	private String name; 
	private double price;
	private int quantity;
	
	public Chips(String name, double price, int quantity) {
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
		return "Crunch Crunch, Yum!";
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