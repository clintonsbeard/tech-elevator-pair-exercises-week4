package com.techelevator.readwrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Write {
	
	File log = new File("log.txt");
	
	
	public void write(String message) {
		try{
		    PrintWriter out = new PrintWriter(new FileWriter(log, false));
		    out.append("\n");
		    out.append(message);
		    out.close();
		    }catch(IOException e){
		        System.out.println("COULD NOT LOG!!");
		    }
	}
}
	
	
	
	
//	try(PrintWriter printWriter = new PrintWriter(newFile)) {
//	
//	printWriter.print("\n");
//	
//}
//catch (IOException e) {
//	System.out.println("Congratulations!  I didn't even think it was possible to break the program in this manner, but you did it!");
//	e.printStackTrace();
//}
//}