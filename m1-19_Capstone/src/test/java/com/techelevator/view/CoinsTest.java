package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class CoinsTest {

	private Coins target;
	
	@Test
	public void no_coins_returned_if_negative() {
		target = new Coins();
		target.moneyConverter(-50.00);
		Assert.assertEquals(0, target.getQuarters());
		target.moneyConverter(-38.73);
		Assert.assertEquals(0, target.getQuarters());
		target.moneyConverter(-31.25);
		Assert.assertEquals(0, target.getDimes());
		target.moneyConverter(-22.68);
		Assert.assertEquals(0, target.getDimes());
		target.moneyConverter(-13.35);
		Assert.assertEquals(0, target.getNickels());
		target.moneyConverter(-3.00);
		Assert.assertEquals(0, target.getNickels());
	}
	
	@Test
	public void no_coins_returned_if_no_money_entered() {
		target = new Coins();
		target.moneyConverter(0.00);
		Assert.assertEquals(0, target.getQuarters());
		Assert.assertEquals(0, target.getDimes());
		Assert.assertEquals(0, target.getNickels());
	}
	
	@Test
	public void correct_number_of_quarters_returned() {
		target = new Coins();
		target.moneyConverter(30.00);
		Assert.assertEquals(120, target.getQuarters());
		target.moneyConverter(16.75);
		Assert.assertEquals(67, target.getQuarters());
		target.moneyConverter(12.00);
		Assert.assertEquals(48, target.getQuarters());
		target.moneyConverter(8.73);
		Assert.assertEquals(34, target.getQuarters());
	}
	
	@Test
	public void correct_number_of_dimes_returned() {
		target = new Coins();
		target.moneyConverter(36.10);
		Assert.assertEquals(1, target.getDimes());
		target.moneyConverter(24.20);
		Assert.assertEquals(2, target.getDimes());
		target.moneyConverter(13.45);
		Assert.assertEquals(2, target.getDimes());
		target.moneyConverter(7.85);
		Assert.assertEquals(1, target.getDimes());
	}
	
	@Test
	public void correct_number_of_nickels_returned() {
		target = new Coins();
		target.moneyConverter(28.05);
		Assert.assertEquals(1, target.getNickels());
		target.moneyConverter(17.15);
		Assert.assertEquals(1, target.getNickels());
		target.moneyConverter(10.55);
		Assert.assertEquals(1, target.getNickels());
		target.moneyConverter(4.65);
		Assert.assertEquals(1, target.getNickels());
	}
}