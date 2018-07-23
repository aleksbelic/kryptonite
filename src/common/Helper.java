package common;

public class Helper {

	/**
	 * Returns reversed string.
	 * 
	 * @param s String that needs to be reversed
	 * @return reversed string
	 */
	public static String getReversedString(String s) {
		String reversed = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reversed += s.charAt(i);
		}
		return reversed;
	}

}
