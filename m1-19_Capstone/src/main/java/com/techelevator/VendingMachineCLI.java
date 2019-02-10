package com.techelevator;

import java.io.FileNotFoundException;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION };
	
	private Menu menu;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	public void run() throws FileNotFoundException {
		menu.bannerArt();
		while(true) {
		
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				menu.getDisplayItems();
			} 
			else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				
				while (true) { 
					menu.displayCurrentMoney();
					
					String purchaseChoice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
	
					if(purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
						menu.displayFeedMoneyMenu();
					}
					else if(purchaseChoice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						menu.displaySelectProductMenu();
					}
					else if(purchaseChoice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						menu.displayFinishTransactionMenu();
						break;
					}
				} 
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
		
}