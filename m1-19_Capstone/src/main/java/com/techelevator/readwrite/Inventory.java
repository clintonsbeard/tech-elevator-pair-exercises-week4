package com.techelevator.readwrite;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.techelevator.items.Candy;
import com.techelevator.items.Chips;
import com.techelevator.items.Drink;
import com.techelevator.items.Gum;
import com.techelevator.items.Item;

public class Inventory {
	
	private List<String> lines;
	
	public Inventory(List<String> lines) {
		this.lines = lines;
	}
	
	public Map<String, Item> getInventory() {
		
		Map<String, Item> inventory = new TreeMap<String, Item>(); 
		for (String key : lines) {
			String[] parts = key.split("\\|"); 
			if (parts[3].contains("Chip")) {
				Chips chip = new Chips(parts[1], Double.parseDouble(parts[2]), 5);
				inventory.put(parts[0], chip);
			}
			if (parts[3].contains("Candy")) {
				Candy candy = new Candy(parts[1], Double.parseDouble(parts[2]), 5);
				inventory.put(parts[0], candy);
			}
			if (parts[3].contains("Drink")) {
				Drink drink = new Drink(parts[1], Double.parseDouble(parts[2]), 5);
				inventory.put(parts[0], drink);
			}
			if (parts[3].contains("Gum")) {
				Gum gum = new Gum(parts[1], Double.parseDouble(parts[2]), 5);
				inventory.put(parts[0], gum);
			}

		}
		return inventory;
	} 
	
}