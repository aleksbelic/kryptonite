package common;

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

}
