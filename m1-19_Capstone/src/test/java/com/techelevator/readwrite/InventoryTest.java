package com.techelevator.readwrite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	
	private Inventory target;
	
	@Before
	public void setup() {
		FileReader reader = new FileReader();
		target = new Inventory(reader.readFile());	
	}
	
	@Test
	public void name_is_correct() {
		Assert.assertEquals("Potato Crisps", target.getInventory().get("A1").getName());
		Assert.assertEquals("Cowtales", target.getInventory().get("B2").getName());
		Assert.assertEquals("Mountain Melter", target.getInventory().get("C3").getName());
		Assert.assertEquals("Triplemint", target.getInventory().get("D4").getName());
	}
	
	@Test
	public void price_is_correct() {
		Assert.assertEquals(1.45, target.getInventory().get("A2").getPrice(), 0.02);
		Assert.assertEquals(1.50, target.getInventory().get("B3").getPrice(), 0.02);
		Assert.assertEquals(1.50, target.getInventory().get("C4").getPrice(), 0.02);
		Assert.assertEquals(0.85, target.getInventory().get("D1").getPrice(), 0.02);
	}
	
	@Test
	public void message_is_correct() {
		Assert.assertEquals("Crunch Crunch, Yum!", target.getInventory().get("A3").getMessage());
		Assert.assertEquals("Munch Munch, Yum!", target.getInventory().get("B4").getMessage());
		Assert.assertEquals("Glug Glug, Yum!", target.getInventory().get("C1").getMessage());
		Assert.assertEquals("Chew Chew, Yum!", target.getInventory().get("D2").getMessage());
	}
	
}