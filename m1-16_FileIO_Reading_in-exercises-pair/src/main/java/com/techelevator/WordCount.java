package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) throws FileNotFoundException {
		
		int wordCount = 0;
		int sentenceCount = 0;
		
		File inputFile = getFileFromUser();
		
		try (Scanner fileIn = new Scanner(inputFile)) {
		
			while (fileIn.hasNextLine()) {
				String line = fileIn.next();
				if (line.endsWith(".")) {
					sentenceCount++;
				}
				if (line.endsWith("!")) {
					sentenceCount++;
				}
				if (line.endsWith("?")) {
					sentenceCount++;
				}
				wordCount++;
			}
			System.out.print("Word Count: " + wordCount + " ");
			System.out.print("Sentence Count: " + sentenceCount);
		}	
	}
	
	private static File getFileFromUser() {
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(inputFile.exists() == false) { 
			System.out.println(path+" does not exist");
			System.exit(1);
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1);
		}
		return inputFile;
	}

}