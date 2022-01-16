package com.hemebiotech.analytics;

import java.util.TreeMap;

import com.hemebiotech.analytics.exception.InputFileException;
import com.hemebiotech.analytics.exception.OutputFileException;

/**
 * It is the class which contains the main program.
 * 
 * @author Corentin Dixmier
 */
public class AnalyticsCounter {

	public static final String INPUT_FILE = "symptoms.txt";
	public static final String OUTPUT_FILE = "result.out";
	/**
	 * Program entry point.
	 * 
	 * @param args The arguments of the main method.
	 */
	public static void main(String args[]) {
		try {
			TreeMap <String, Integer> symptoms = new ReadSymptomDataFromFile(INPUT_FILE).getSymptoms();
			WriteSymptomsInAFile writeSymptoms = new WriteSymptomsInAFile(symptoms, OUTPUT_FILE);
			writeSymptoms.write();	
		} catch (InputFileException e) {
			System.err.println("Input file error : " + e.getMessage());
		} catch (OutputFileException e) {
			System.err.println("Output file error : " + e.getMessage());
		}
	}	
}
