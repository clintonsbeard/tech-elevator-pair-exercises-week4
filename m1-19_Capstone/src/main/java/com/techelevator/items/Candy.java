package com.techelevator.items;

public class Candy implements Item {
	
	private String name; 
	private double price;
	private int quantity;
	
	public Candy(String name, double price,int quantity) {
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
		return "Munch Munch, Yum!";
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}
	
	public int subtractQuantity() {
		quantity --;
		return quantity;
	}
	
}