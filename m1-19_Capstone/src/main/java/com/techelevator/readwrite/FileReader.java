package com.techelevator.readwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	public class FileReader {
	
	String filePath = "vendingmachine.csv";
	
	public List<String> readFile() throws FileNotFoundException  {
		
		List<String> lines = new ArrayList<String>();
		
		File inputFile = new File(filePath);
		try (Scanner fileScanner = new Scanner(inputFile)) {
			while (fileScanner.hasNextLine()) {
				lines.add(fileScanner.nextLine());
			}
		}
		return lines;
	} 
	
}