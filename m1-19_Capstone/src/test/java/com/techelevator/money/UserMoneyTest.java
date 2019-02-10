package com.techelevator.money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserMoneyTest {

	private UserMoney target;
	
	@Before
	public void setup() {
		target = new UserMoney();
		target.addMoney(20.00);
	}
	
	@Test
	public void add_money() {
		double result;
		Assert.assertEquals(20.00, target.getMoney(), 0.02);	
		target.addMoney(20.00);
		Assert.assertEquals(40.00, target.getMoney(), 0.02);
		target.addMoney(5.00);
		Assert.assertEquals(45.00, target.getMoney(), 0.02);
	}
	
	@Test
	public void negative_money_cant_be_added() {
		target.addMoney(-15.00);
		Assert.assertEquals(20.00, target.getMoney(), 0.02);	
		target.addMoney(-3.00);
		Assert.assertEquals(20.00, target.getMoney(), 0.02);
		target.addMoney(-7.00);
		Assert.assertEquals(20.00, target.getMoney(), 0.02);
		target.addMoney(-10.00);
		Assert.assertEquals(20.00, target.getMoney(), 0.02);
	}
	
	@Test
	public void subtract_without_enough_money() {
		target.subtractMoney(30.00);
		Assert.assertEquals(20.00, target.getMoney(), 0.02);	
		target.subtractMoney(32.00);
		Assert.assertEquals(20.00, target.getMoney(), 0.02);
		target.subtractMoney(45.00);
		Assert.assertEquals(20.00, target.getMoney(), 0.02);
		target.subtractMoney(500.00);
		Assert.assertEquals(20.00, target.getMoney(), 0.02);
	}
	
	@Test
	public void subtract_money() {
		target.subtractMoney(1.25);
		Assert.assertEquals(18.75, target.getMoney(), 0.02);
		target.subtractMoney(2.00);
		Assert.assertEquals(16.75, target.getMoney(), 0.02);	
		target.subtractMoney(3.75);
		Assert.assertEquals(13.00, target.getMoney(), 0.02);	
		target.subtractMoney(0.00);
		Assert.assertEquals(13.00, target.getMoney(), 0.02);	
	}

}