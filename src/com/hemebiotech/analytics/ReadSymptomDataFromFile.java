package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

/**
 * This class fills a map with informations from a file.
 * 
 * @author Corentin Dixmier
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	/**
	 * The file path.
	 */
	private String filepath;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param filepath A full or partial path to file with symptom strings in it, one per line.
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Override method because it class implements the ISymptomReader interface.
	 *
	 * @return The symptoms.
	 */
	@Override
	public TreeMap<String, Integer> GetSymptoms() throws Exception  {
		// The buffer reader used to read a file
		BufferedReader reader = new BufferedReader (new FileReader(filepath));
		String symptom = reader.readLine();	// Reads the first line of the file
		// Declares a variable symptoms of type TreeMap and then instancializes it
		// We use a tree map to sort it alphabetically
		TreeMap <String,Integer> symptoms = new TreeMap <String,Integer>();
		try {
			// Fills the tree map.
			while (symptom != null) {
				if (symptoms.containsKey(symptom)) {
					symptoms.put(symptom, symptoms.get(symptom) + 1); 
				} else {
					symptoms.put(symptom, 1);
				}
				symptom = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return symptoms;
	}
}
