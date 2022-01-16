package com.hemebiotech.analytics;

import java.util.TreeMap;

import com.hemebiotech.analytics.exception.InputFileException;

/**
 * It is an interface providing a method to get symptoms in a tree map.
 * 
 * @author Corentin Dixmier
 */
public interface ISymptomReader {
	/**
	 * Method to get symptoms in a tree map.
	 * 
	 * @return The tree map of symptoms.
	 * @throws InputFileException 
	 */
	public TreeMap<String,Integer> getSymptoms() throws InputFileException;
}
