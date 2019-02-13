package com.techelevator.view;

import java.text.DecimalFormat;

public class Coins {

    private int quarters, dimes, nickels;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    
    public int getQuarters() {
		return quarters;
	}

	public int getDimes() {
		return dimes;
	}

	public int getNickels() {
		return nickels;
	}

	public void moneyConverter(double money) {
	    if (money >= 0.25) {
	    	quarters = (int) (money / 0.25);
	        money %= 0.25;
	        String moneyString = decimalFormat.format(money);
	        money = Double.parseDouble(moneyString);
	    }
	    if (money >= 0.10) {
	        dimes = (int) (money / 0.10);
	        money %= 0.10;
	        String moneyString = decimalFormat.format(money);
	        money = Double.parseDouble(moneyString);
	    } 
	    if (money >= 0.05) {
	    	nickels = (int) (money / 0.05);
	        money %= 0.05;
	        String moneyString = decimalFormat.format(money);
	        money = Double.parseDouble(moneyString);
	    }
	    if (money > 0) {
	    	money = 0.00;
	    }
    }

}