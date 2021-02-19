package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

/**
 * It is the class which contains the main program.
 * 
 * @author Corentin Dixmier
 */
public class AnalyticsCounter {
	
	/**
	 * Program entry point.
	 * 
	 * @param args The arguments of the main method.
	 * @throws Exception The exception which can be thrown.
	 */
	public static void main(String args[]) throws Exception {
		Map <String, Integer> symptoms = new ReadSymptomDataFromFile("symptoms.txt").GetSymptoms();
		// Allows the map to be shown as a string
		String result = symptoms.toString().replace(
				"{", "").replace("}", "").replace(", ", "\n").replace("=", ": ");
		System.out.println(result);
		// Generate a new text file "result.out"
		FileWriter writer = new FileWriter ("result.out");
		writer.write(result);
		writer.close();	}
}
