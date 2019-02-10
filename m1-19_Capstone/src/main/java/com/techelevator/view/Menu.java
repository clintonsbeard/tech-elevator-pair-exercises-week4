package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import com.techelevator.items.Item;
import com.techelevator.money.UserMoney;
import com.techelevator.readwrite.FileReader;
import com.techelevator.readwrite.Inventory;
import com.techelevator.readwrite.Write;

public class Menu {

	private PrintWriter out;
	private Scanner in;
	private UserMoney userMoney = new UserMoney();
	private FileReader reader = new FileReader();
	private Inventory inventory = new Inventory(reader.readFile());
	private DisplayItems display = new DisplayItems(inventory.getInventory());
	private Map<String, Item> itemInventory = inventory.getInventory();
	private List<String> messageStrings = new ArrayList<>();
	private Coins coinsReturned = new Coins();
	private Write write = new Write();
	private SimpleDateFormat dateAndTimeFormat = new SimpleDateFormat("MM-DD-YYYY HH-MM-SS a");

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
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
		System.out.println("Please enter the two digit code associated with the desired item: ");
		try {
			String userInput = in.next();
			in.nextLine();
			
			if (userMoney.getMoney() < itemInventory.get(userInput).getPrice()) {
				System.out.println("Error: You have not inserted enough money to purchase this item.  Please feed more money into the machine or make a new selection.");
			}
			else if (itemInventory.get(userInput).getQuantity() < 1) {
				System.out.println("Error: Product has sold out.  Please choose another item.");
			} else {
				double price = itemInventory.get(userInput).getPrice();
				userMoney.subtractMoney(price);
				itemInventory.get(userInput).subtractQuantity();
				messageStrings.add(itemInventory.get(userInput).getMessage());
			}
		} catch (NullPointerException e) {
			System.out.println("Error: Invalid product code.");
		}
	}

	public void displayFinishTransactionMenu() {
		for (String item : messageStrings) {
			System.out.println(item);
		}
		
		messageStrings.removeAll(messageStrings);
		
		if (userMoney.getMoney() > 0) {
			System.out.printf("\nYour total change returned is $%1.2f" + coinsReturned.moneyConverter(userMoney.getMoney()), userMoney.getMoney());
			userMoney.subtractMoney(userMoney.getMoney());
		} else {
			System.out.println("\nNo change returned.  Thank you!");
		}
	}
	
	public void displayCurrentMoney() {
		System.out.printf("\nCurrent Money Provided: $%1.2f", userMoney.getMoney());
	}
	
	public void displayFeedMoneyMenu() {
		System.out.println("Please insert whole dollar amount ($1, $2, $5, or $10): ");
		try {
			int userInput = in.nextInt();
			in.nextLine();
			if (userInput == 1 || userInput == 2 || userInput == 5 || userInput == 10) {
				userMoney.addMoney(userInput);
				write.write(dateAndTimeFormat + "FEED MONEY: " + userInput + "   " + userMoney.getMoney());
			}
			else {
				System.out.println("Error: Money inserted is not a $1, $2, $5 or a $10.  Please insert correct bill.");
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Error: Amount inserted is not whole dollar amount.");
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
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	
}