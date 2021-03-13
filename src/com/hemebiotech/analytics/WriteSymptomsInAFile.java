package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * It is the class which create display and create a file from a TreeMap.
 * 
 * @author Corentin Dixmier
 */

public class WriteSymptomsInAFile {

	/**
	 * The Treemap and the name of the file.
	 */
	public TreeMap<String, Integer> symptoms;
	public String outputfile;
	
	
	/**
	 * Constructor of the class
	 * 
	 * @param symptoms The Treemap.
	 * @param outputfile The file were the map is written.
	 */
	public WriteSymptomsInAFile (TreeMap <String, Integer> symptoms, String outputfile) {
		this.symptoms = symptoms;
		this.outputfile = outputfile ;
	}
	
	/**
	 * This method converts the TreeMap in a String and then write the result in a map.
	 */
	public void write() {
		String result = symptoms.toString().replace(
				"{", "").replace("}", "").replace(", ", "\n").replace("=", ": ");
		System.out.println(result);
		FileWriter writer;
		try {
			writer = new FileWriter (outputfile);
			writer.write(result);
			writer.close();	
		} catch (IOException e) {
			System.out.println("IO exceptions found when writting in the file.");
		}
	}
}
