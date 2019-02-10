package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinsTest {

	private Coins target;
	
	@Before
	public void setup() {
		target = new Coins();
	}
	
	@Test
	public void no_dollars_returned() {
		String result;
		Assert.assertEquals(" in 120 quarters, 0 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(30.00));
		Assert.assertEquals(" in 67 quarters, 0 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(16.75));
		Assert.assertEquals(" in 40 quarters, 0 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(10.00));
		Assert.assertEquals(" in 25 quarters, 0 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(6.25));
	}
	
	@Test
	public void correct_quarters_returned() {
		String result;
		Assert.assertEquals(" in 80 quarters, 0 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(20.00));
		Assert.assertEquals(" in 60 quarters, 0 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(15.00));
		Assert.assertEquals(" in 40 quarters, 0 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(10.00));
		Assert.assertEquals(" in 20 quarters, 0 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(5.00));
	}
	
	@Test
	public void correct_dimes_returned() {
		String result;
		Assert.assertEquals(" in 92 quarters, 1 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(23.10));
		Assert.assertEquals(" in 66 quarters, 1 dimes, and 1 nickels.  Thank you!\n", result = target.moneyConverter(16.70));
		Assert.assertEquals(" in 40 quarters, 1 dimes, and 1 nickels.  Thank you!\n", result = target.moneyConverter(10.20));
		Assert.assertEquals(" in 22 quarters, 0 dimes, and 1 nickels.  Thank you!\n", result = target.moneyConverter(5.60));
	}
	
	@Test
	public void correct_nickels_returned() {
		String result;
		Assert.assertEquals(" in 88 quarters, 0 dimes, and 1 nickels.  Thank you!\n", result = target.moneyConverter(22.05));
		Assert.assertEquals(" in 64 quarters, 1 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(16.15));
		Assert.assertEquals(" in 45 quarters, 0 dimes, and 1 nickels.  Thank you!\n", result = target.moneyConverter(11.35));
		Assert.assertEquals(" in 18 quarters, 1 dimes, and 1 nickels.  Thank you!\n", result = target.moneyConverter(4.65));
	}
	
	@Test
	public void no_pennies_returned() {
		String result;
		Assert.assertEquals(" in 98 quarters, 1 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(24.63));
		Assert.assertEquals(" in 72 quarters, 1 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(18.12));
		Assert.assertEquals(" in 55 quarters, 1 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(13.89));
		Assert.assertEquals(" in 29 quarters, 0 dimes, and 0 nickels.  Thank you!\n", result = target.moneyConverter(7.28));
	}
	
}