package com.techelevator.view;

public class Coins {

    private int quarters, dimes, nickels;
    
    public String moneyConverter(double money) {

    	if (money > 0 ) {
    		quarters = (int) (money / 0.25);
        	money %= 0.25;
    	}
    	if (money > 0) {
        	dimes = (int) (money / 0.10);
            money %= 0.10;
    	} 
    	if (money > 0) {
            nickels = (int) (money / 0.05);
            money %= 0.05;
    	}
		return " in " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels.  Thank you!\n";
    }

}