package common;

import java.util.HashMap;

/**
 * Stats class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Stats {

	/**
	 * Returns count of every char in a given string.
	 * 
	 * @param s string to process.
	 * @return count of every char in the string
	 */
	public static HashMap<Character, Integer> charCount(String s) {
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			charCountMap.merge(s.charAt(i), 1, Integer::sum);
		}
		return charCountMap;
	}

	/**
	 * Returns frequency of every char in a given string.
	 * 
	 * @param s string to process.
	 * @return frequency of every char in the string
	 */
	public static HashMap<Character, Double> charFrequency(String s) {
		HashMap<Character, Integer> charCountMap = charCount(s);
		HashMap<Character, Double> charFrequencyMap = new HashMap<Character, Double>();
		charCountMap.forEach((k, v) -> charFrequencyMap.put(k, v * 100.0 / s.length()));
		return charFrequencyMap;
	}

}
