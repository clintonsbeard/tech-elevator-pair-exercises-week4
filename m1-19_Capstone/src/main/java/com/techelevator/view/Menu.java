package com.techelevator.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.items.Item;
import com.techelevator.money.UserMoney;
import com.techelevator.readwrite.FileReader;
import com.techelevator.readwrite.Inventory;
import com.techelevator.readwrite.SalesWriter;
import com.techelevator.readwrite.Write;

public class Menu {

	private Scanner in;
	private PrintWriter out;
	private Write write = new Write();
	private Coins coinsReturned = new Coins();
	private FileReader reader = new FileReader();
	private UserMoney userMoney = new UserMoney();
	private List<String> messageStrings = new ArrayList<>();
	private Inventory inventory = new Inventory(reader.readFile());
	private Map<String, Item> itemInventory = inventory.getInventory();
	
	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}
	
	public void bannerArt() {
		System.out.println("|############################################|\n" + 
						   "|#|                           |##############|\n" + 
						   "|#|  =====  ..--''`  |~~``|   |##|````````|##|\n" + 
						   "|#|  |   |  \\     |  :    |   |##| Whole  |##|\n" + 
						   "|#|  |___|   /___ |  | ___|   |##| Dollar |##|\n" + 
						   "|#|  /=__\\  ./.__\\   |/,__\\   |##| Only   |##|\n" + 
						   "|#|  \\__//   \\__//    \\__//   |##|________|##|\n" + 
						   "|#|===========================|##############|\n" + 
						   "|#|```````````````````````````|##############|\n" + 
						   "|#| =.._      +++     //////  |##############|\n" + 
						   "|#| \\/  \\     | |     \\    \\  |#|`````````|##|\n" + 
						   "|#|  \\___\\    |_|     /___ /  |#| _______ |##|\n" + 
						   "|#|  / __\\\\  /|_|\\   // __\\   |#| |1|2|3| |##|\n" + 
						   "|#|  \\__//-  \\|_//   -\\__//   |#| |4|A|B| |##|\n" + 
						   "|#|===========================|#| |C|D|$| |##|\n" + 
						   "|#|```````````````````````````|#| ``````` |##|\n" + 
						   "|#| ..--    ______   .--._.   |#|[=======]|##|\n" + 
						   "|#| \\   \\   |    |   |    |   |#|  _   _  |##|\n" + 
						   "|#|  \\___\\  : ___:   | ___|   |#| ||| ( ) |##|\n" + 
						   "|#|  / __\\  |/ __\\   // __\\   |#| |||  `  |##|\n" + 
						   "|#|  \\__//   \\__//  /_\\__//   |#|  ~      |##|\n" + 
						   "|#|===========================|#|_________|##|\n" + 
						   "|#|```````````````````````````|##############|\n" + 
						   "|############################################|\n" + 
						   "|#|||||||||||||||||||||||||||||####```````###|\n" + 
						   "|#||||||||||||PUSH|||||||||||||####`     `###|\n" + 
						   "|#|||||||||||||||||||||||||||||####\\|||||/###|\n" + 
						   "|############################################|\n" + 
						   " \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\//////////////////////\n");
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}
	
	public void getDisplayItems() {
		System.out.println();
		for (String item : itemInventory.keySet()) {
			if (itemInventory.get(item).getQuantity() < 1) {
				System.out.printf("%-4s %-20s $%-6.2f %-1s \n", item, itemInventory.get(item).getName(), itemInventory.get(item).getPrice(), "SOLD OUT");
			}
			else {
				System.out.printf("%-4s %-20s $%-6.2f %-1d %-9s \n", item, itemInventory.get(item).getName(), itemInventory.get(item).getPrice(), itemInventory.get(item).getQuantity(), "Remaining");
			}
		}
	}
	
	public void displaySelectProductMenu() {
		System.out.print("\nPlease enter the two digit code associated with the desired item: ");
		try {
			String userInput = in.next().toUpperCase();
			in.nextLine();
			
			if (userMoney.getMoney() < itemInventory.get(userInput).getPrice()) {
				System.out.println("Error: You have not inserted enough money to purchase this item.  Please feed more money into the machine or make a new selection.");
			}
			else if (itemInventory.get(userInput).getQuantity() < 1) {
				System.out.println("Error: Product has sold out.  Please choose another item.");
			} else {
				System.out.println("\n" + itemInventory.get(userInput).getName() + " dispensed.  Thank you!");
				double price = itemInventory.get(userInput).getPrice();
				userMoney.subtractMoney(price);
				itemInventory.get(userInput).subtractQuantity();
				messageStrings.add(itemInventory.get(userInput).getMessage());
				try {
					write.writeSelectProductInLog(itemInventory.get(userInput).getName().toUpperCase(), userInput, itemInventory.get(userInput).getPrice(), userMoney.getMoney());
				} catch (IOException e) {
					System.out.println("Error: Log was unable to be written to file.");
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Error: Invalid product code.");
		}
	}

	public void displayFinishTransactionMenu() {
		System.out.println();
		for (String item : messageStrings) {
			System.out.println(item);
		}
		
		messageStrings.removeAll(messageStrings);
		
		try {
			write.writeGiveChangeInLog("GIVE CHANGE", userMoney.getMoney(), 0);
		} catch (IOException e) {
			System.out.println("Error: Log was unable to be written to file.");
		}
		
		if (userMoney.getMoney() > 0) {
			coinsReturned.moneyConverter(userMoney.getMoney());
			System.out.printf("Your total change is $%1.2f in %s quarters, %s dimes, and %s nickels.  Thank you!\n", userMoney.getMoney(), coinsReturned.getQuarters(), coinsReturned.getDimes(), coinsReturned.getNickels());
			userMoney.subtractMoney(userMoney.getMoney());
		} else {
			System.out.println("\nNo change returned.  Thank you!");
		}
	}
	
	public void displayCurrentMoney() {
		System.out.printf("\nCurrent Money Provided: $%1.2f", userMoney.getMoney());
	}
	
	public void displayFeedMoneyMenu() {
		System.out.print("\nPlease insert whole dollar amount ($1, $2, $5, or $10): ");
		try {
			int userInput = in.nextInt();
			in.nextLine();
			if (userInput == 1 || userInput == 2 || userInput == 5 || userInput == 10) {
				userMoney.addMoney(userInput);
				write.writeFeedMoneyInLog("FEED MONEY", userInput, userMoney.getMoney());
			} 
			else {
				System.out.println("\nError: Money inserted is not a $1, $2, $5 or a $10.  Please insert correct bill.");
			}
		}
		catch (InputMismatchException e) {
			System.out.println("\nError: Amount inserted is not whole dollar amount.");
		}
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("Error: " + userInput + " is not a valid option.");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option: ");
		out.flush();
	}
	
}