package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

import com.hemebiotech.analytics.exception.InputFileException;

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
	public TreeMap<String, Integer> getSymptoms() throws InputFileException {
		// The buffer reader used to read a file
		BufferedReader reader;
		// Declares a variable symptoms of type TreeMap and then instancializes it
		// We use a tree map to sort it alphabetically
		TreeMap <String,Integer> symptoms = new TreeMap <String,Integer>();
		try {
			reader = new BufferedReader (new FileReader(filepath));
			// Fills the tree map.
			String symptom;
			while ((symptom = reader.readLine()) != null) {
				if (symptoms.containsKey(symptom)) {
					symptoms.put(symptom, symptoms.get(symptom) + 1); 
				} else {
					symptoms.put(symptom, 1);
				}
			}
			reader.close();
				
		} catch (FileNotFoundException e) {
			throw new InputFileException("No file found.");
		} catch (IOException e2) {
			throw new InputFileException("Error while reading file.");
		}
			return symptoms;
	
	} 
}
