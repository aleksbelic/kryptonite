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
	 * @param sort should be sorting applied ('asc-key', 'desc-key', 'asc-value', 'desc-value', 'none')
	 */
	public static void printMapAsTable(HashMap<?, ?> map, String sort) {
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}

}
