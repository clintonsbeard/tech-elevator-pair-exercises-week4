package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Map;

import com.techelevator.items.Item;
import com.techelevator.readwrite.Inventory;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													   MAIN_MENU_OPTION_PURCHASE };
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() throws FileNotFoundException {
		while(true) {
			
			Inventory inventory = new Inventory();
			Map<String, Item> inventoryMap = inventory.getInventory(); 
			for (String item : inventoryMap.keySet()) {
			System.out.println(item + " " + inventoryMap.get(item).getName() + " " + inventoryMap.get(item).getPrice());
			}
			
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		
	}
		
}
