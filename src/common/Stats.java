package common;

import java.util.HashMap;
import java.util.Map;

/**
 * Stats class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Stats {

	/**
	 * Returns count of every char in a given string.
	 * 
	 * @param s               string to process
	 * @param countWhiteSpace should whitespace also be counted
	 * @return count of every char in the string
	 */
	public static HashMap<Character, Integer> charCount(String s, boolean countWhiteSpace) {
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!countWhiteSpace && Character.isWhitespace(s.charAt(i))) {
				continue;
			}
			charCountMap.merge(s.charAt(i), 1, Integer::sum);
		}
		return charCountMap;
	}

	/**
	 * Returns frequency of every char in a given string.
	 * 
	 * @param s               string to process
	 * @param countWhiteSpace should whitespace also be included in the calculation
	 * @return frequency of every char in the string
	 */
	public static HashMap<Character, Double> charFrequency(String s, boolean countWhiteSpace) {
		if (!countWhiteSpace) {
			s = s.replaceAll("\\s+", ""); // removing whitespace
		}
		HashMap<Character, Integer> charCountMap = charCount(s, countWhiteSpace);
		HashMap<Character, Double> charFrequencyMap = new HashMap<Character, Double>();

		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			charFrequencyMap.put(entry.getKey(), entry.getValue() * 100.0 / s.length());
		}
		return charFrequencyMap;
	}

	/**
	 * Returns count of every word in a given string.
	 * 
	 * @param s         string to process
	 * @param delimiter string used for splitting the string
	 * @return count of every word in the string
	 */
	public static HashMap<String, Integer> wordCount(String s, String delimiter) {
		// TODO: implement trimming regex
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		String[] sArray = s.split(delimiter);
		for (int i = 0; i < sArray.length; i++) {
			if (sArray[i] != "") {
				wordCountMap.merge(sArray[i], 1, Integer::sum);
			}
		}
		return wordCountMap;
	}

}
