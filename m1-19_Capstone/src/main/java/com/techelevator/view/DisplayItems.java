package com.techelevator.view;

import java.util.Map;

import com.techelevator.items.Item;

public class DisplayItems {
	
	private Map<String, Item> items;
	
	public DisplayItems(Map<String, Item> items) {
		this.items = items;	
	}
	
	//Method: 
	public void getDisplayItems() {
		for (String item : items.keySet()) {
			if (items.get(item).getQuantity() < 1) {
				System.out.printf("%-4s %-20s $%-6.2f %-1s \n", item, items.get(item).getName(), items.get(item).getPrice(), "SOLD OUT");
			}
			else {
				System.out.printf("%-4s %-20s $%-6.2f %-1d %-9s \n", item, items.get(item).getName(), items.get(item).getPrice(), items.get(item).getQuantity(), "Remaining");
			}
		}
	}

}
