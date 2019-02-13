package com.techelevator.readwrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Write {
	
	private boolean file = new File("Log.txt").delete();
	
	public void writeFeedMoneyInLog (String transactionDescription, double moneyFed, double totalMoneyProvided) {
	    try (FileWriter auditLog = new FileWriter("Log.txt", true); PrintWriter printWriter = new PrintWriter(auditLog)) {
	        Date date = new Date();
	        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
	        String dateString = dateFormat.format(date);
	        printWriter.write(dateString);
	        printWriter.format(" %-21s +$%-7.2f $%-7.2f", transactionDescription, moneyFed, totalMoneyProvided);
	        printWriter.println();
	    } 
	    catch (IOException e) {
	    	System.out.println("Error: Log was unable to be written to file.");
		}
	}
	
	public void writeSelectProductInLog (String productName, String productKey, double moneySpent, double totalMoneyProvided) throws IOException {
	    try (FileWriter auditLog = new FileWriter("Log.txt", true); PrintWriter printWriter = new PrintWriter(auditLog)) {
	        Date date = new Date();
	        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
	        String dateString = dateFormat.format(date);
	        printWriter.write(dateString);
	        printWriter.format(" %-18s %-2s -$%-7.2f $%-7.2f", productName, productKey, moneySpent, totalMoneyProvided);
	        printWriter.println();
	    }
	    catch (IOException e) {
	    	System.out.println("Error: Log was unable to be written to file.");
		}
	}
	
	public void writeGiveChangeInLog (String transactionDescription, double moneyFed, double totalMoneyProvided) throws IOException {
	    try (FileWriter auditLog = new FileWriter("Log.txt", true); PrintWriter printWriter = new PrintWriter(auditLog)) {
	        Date date = new Date();
	        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
	        String dateString = dateFormat.format(date);
	        printWriter.write(dateString);
	        printWriter.format(" %-21s -$%-7.2f $%-7.2f", transactionDescription, moneyFed, totalMoneyProvided);
	        printWriter.println();
	    }
	    catch (IOException e) {
			System.out.println("Error: Log was unable to be written to file.");
		}
	}
	
}