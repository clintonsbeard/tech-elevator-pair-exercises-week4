package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) throws Exception {
		
		while (true) {
			
			File inputFile = getFileFromUser();	
			Scanner in = new Scanner(System.in);
			
			System.out.println("What is the search word you are looking for?");
			String searchFor = in.nextLine();
			
			System.out.println("What is the word you would like the searched word to be replaced with?");
			String replaceWord = in.nextLine();
			
			System.out.println("Enter the path of the new directory for the new text file.");
			String dirPath = in.nextLine();
			File newDirectory = new File(dirPath);
			
			if(newDirectory.exists()) {
				System.out.println("Sorry, "+newDirectory.getAbsolutePath()+" already exists.");
				System.exit(1);
			} else {
				if(newDirectory.mkdir()) {
					System.out.println("New directory created at "+newDirectory.getAbsolutePath());
				} else {
					System.out.println("Could not create directory.");
					System.exit(1);
				}
			}
			
			System.out.println("Enter a name for the new text file.");
			String fileName = in.nextLine();
			File newFile = new File(newDirectory, fileName);
			
			newFile.createNewFile();
		
				try (Scanner fileIn = new Scanner(inputFile)) {
					try(PrintWriter printWriter = new PrintWriter(newFile);
						BufferedWriter buffered = new BufferedWriter(printWriter)) {
						while (fileIn.hasNextLine()) {
							String line = fileIn.nextLine();
							if (line.contains(searchFor)) {
								line = line.replace(searchFor, replaceWord);
								buffered.write(line + "\n");
							}
							else {
								buffered.write(line + "\n");
							}
						}
					}
				}
			}
		}
	
	private static File getFileFromUser() {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the file that should be searched?");
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