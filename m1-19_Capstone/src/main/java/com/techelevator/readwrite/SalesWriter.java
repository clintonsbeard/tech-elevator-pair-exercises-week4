package com.techelevator.readwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.items.Item;

public class SalesWriter {  
	
	private FileReader reader = new FileReader();
	private Inventory inventory = new Inventory(reader.readFile());
	private Map<String, Item> itemInventory = inventory.getInventory();
	
	public void writeToSalesReport (Item productName, int quantity) throws IOException {
		
		try (FileWriter auditLog = new FileWriter("Sales.txt", true); PrintWriter printWriter = new PrintWriter(auditLog)) {
 
	        List<String> lines = readFile("Sales.txt");
	        
			// Loops though List to Calculate Sales: 
	        Map<String, Integer> mapOfSales = new LinkedHashMap<>();
	        
			for (String items : lines) {  
				
				if (items.contains(productName.getName())) {
					
					int newValue = Math.abs(productName.getQuantity() - 5);
					mapOfSales.put(productName.getName(), newValue);
					
				} else {
					mapOfSales.put(productName.getName(), 1);
				}
			}
	    }
	    catch (Exception e) { 
	    	return;
	    }
	}
		 
		private List<String> readFile(String path) {
			
			List<String> lines = new ArrayList<String>();
			
			File inputFile = new File(path);
			try (Scanner fileScanner = new Scanner(inputFile)) {
				while (fileScanner.hasNextLine()) { 
					lines.add(fileScanner.nextLine());
				}
			}
			catch (FileNotFoundException e) {
				System.out.println("Congratulations!  I didn't even think it was possible to break the program in this manner, but you did it!");
			}
			return lines;
		}
}
