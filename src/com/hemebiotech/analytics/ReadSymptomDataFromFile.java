package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	 * Override method because the class implements the ISymptomReader interface.
	 *
	 * @return The symptoms.
	 */
	@Override
	public TreeMap<String, Integer> getSymptoms() {
		// The buffer reader used to read a file
		BufferedReader reader;
		try {
			reader = new BufferedReader (new FileReader(filepath));
			// Declares a variable symptoms of type TreeMap and then instancializes it
			// We use a tree map to sort it alphabetically
			TreeMap <String,Integer> symptoms = new TreeMap <String,Integer>();
			// Fills the tree map.
			while (reader.readLine() != null) {
				String symptom = reader.readLine();
				if (symptoms.containsKey(symptom)) {
					symptoms.put(symptom, symptoms.get(symptom) + 1); 
				} else {
					symptoms.put(symptom, 1);
				}
			}
			reader.close();
			return symptoms;	
		} catch (FileNotFoundException e) {
			System.out.println("No file found.");
			System.exit(0);
		} catch (IOException e2) {
			System.out.println("IO exceptions found when reading the file.");
		}

		return getSymptoms();
	} 
}
