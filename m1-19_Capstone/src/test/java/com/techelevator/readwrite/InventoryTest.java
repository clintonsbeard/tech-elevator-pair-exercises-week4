package com.techelevator.readwrite;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


import com.techelevator.items.Chips;
import com.techelevator.items.Item;



public class InventoryTest {
	
	private Inventory target;
	
	@Before
	public void setup() {
		target = new Inventory();
	}
	
	@Test
	public void correct_value_in_map() throws FileNotFoundException {
		Item expected = new Chips("Potato Crisps", 3.05);
		Map<String, Item> testMap = target.getInventory();
		Item testItem = testMap.get(testMap.keySet().toArray()[0]);
		Assert.assertEquals(expected, testItem);
	}
}
