package ciphers;

import java.util.ArrayList;

/**
 * ScytaleCipher class.
 * 
 * @author Aleksandar.Belic <aleks.belic@gmail.com>
 *
 */
public class ScytaleCipher {

	private int diameter; // how many letters fit in a circle around rod

	public ScytaleCipher(int diameter) {
		this.diameter = diameter;
	}

	/**
	 * Encrypts given string for specific rod diameter.
	 * 
	 * @param s string to encrypt
	 * @return encrypted string
	 */
	public String encrypt(String s) {
		String encryptedString = "";
		ArrayList<Character> charArrayList = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			charArrayList.add(s.charAt(i));
		}
		int i = 0;
		while (encryptedString.length() != s.length()) {
			if (charArrayList.get(i) != null) {
				encryptedString += charArrayList.get(i);
				charArrayList.set(i, null);
				i = (i + (int)(s.length() / diameter)) % s.length();
			} else {
				i++;
			}
		}
		return encryptedString;
	}
	
	/**
	 * Decrypts given string for specific rod diameter.
	 * 
	 * @param s string to decrypt
	 * @return decrypted string
	 */
	public String decrypt(String s) {
		String decryptedString = "";
		ArrayList<Character> charArrayList = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			charArrayList.add(s.charAt(i));
		}
		int i = 0;
		while (decryptedString.length() != s.length()) {
			if (charArrayList.get(i) != null) {
				decryptedString += charArrayList.get(i);
				charArrayList.set(i, null);
				i = (i + diameter) % s.length();
			} else {
				i++;
			}
		}
		return decryptedString;
	}

}
