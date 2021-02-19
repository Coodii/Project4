package com.hemebiotech.analytics;

import java.util.TreeMap;

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
	 * @throws Exception The exceptions can be thrown.
	 */
	public TreeMap<String,Integer> GetSymptoms() throws Exception;
}
