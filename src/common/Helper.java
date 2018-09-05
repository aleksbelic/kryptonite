package common;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Helper {

	/**
	 * Returns reversed string.
	 * 
	 * @param s String that needs to be reversed
	 * @return reversed string
	 */
	public static String getReversedString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	// TODO: sorting
	/**
	 * Prints out map object key-value pairs as table.
	 * 
	 * @param map  HashMap to print out
	 * @param sort should sorting be applied ('asc-key', 'desc-key', 'asc-value', 'desc-value', 'none')
	 */
	public static void printMapAsTable(HashMap<?, ?> map, String sort) {
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}
	
	/**
	 * Substitutes chars in a string using substitution map.
	 * 
	 * @param ciphertext string to alter with new chars
	 * @param substitutionMap chars used as substitution
	 * @param caseSensitive should mapping be case sensitive
	 * @return plaintext with substituted chars 
	 */
	public static String substituteCharsInStringUsingMap(String ciphertext, Map<Character, Character> substitutionMap, boolean caseSensitive) {
		String plaintext = "";
		for (int i = 0; i < ciphertext.length(); i++) {
			char currentChar = ciphertext.charAt(i);
			if (caseSensitive) {
				if (substitutionMap.containsKey(currentChar))
					plaintext += substitutionMap.get(currentChar);
				else
					plaintext += currentChar;
			} else {
				if (substitutionMap.containsKey(Character.toLowerCase(currentChar)))
					plaintext += substitutionMap.get(Character.toLowerCase(currentChar));
				else if (substitutionMap.containsKey(Character.toUpperCase(currentChar)))
					plaintext += substitutionMap.get(Character.toUpperCase(currentChar));
				else
					plaintext += currentChar;
			}
		}
		
		return plaintext;
	}

}
