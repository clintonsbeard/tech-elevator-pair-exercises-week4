package com.techelevator.items;

public interface Item {
	
	String getName();
	String getMessage(); 
	double getPrice();
	int getQuantity();
	int subtractQuantity();

}