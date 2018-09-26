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
		StringBuilder encryptedStringStringBuilder = new StringBuilder();
		ArrayList<Character> charArrayList = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			charArrayList.add(s.charAt(i));
		}
		int i = 0;
		while (encryptedStringStringBuilder.length() != s.length()) {
			if (charArrayList.get(i) != null) {
				encryptedStringStringBuilder.append(charArrayList.get(i));
				charArrayList.set(i, null);
				i = (i + (s.length() / diameter)) % s.length();
			} else {
				i++;
			}
		}
		return encryptedStringStringBuilder.toString();
	}
	
	/**
	 * Decrypts given string for specific rod diameter.
	 * 
	 * @param s string to decrypt
	 * @return decrypted string
	 */
	public String decrypt(String s) {
		StringBuilder decryptedStringStringBuilder = new StringBuilder();
		ArrayList<Character> charArrayList = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			charArrayList.add(s.charAt(i));
		}
		int i = 0;
		while (decryptedStringStringBuilder.length() != s.length()) {
			if (charArrayList.get(i) != null) {
				decryptedStringStringBuilder.append(charArrayList.get(i));
				charArrayList.set(i, null);
				i = (i + diameter) % s.length();
			} else {
				i++;
			}
		}
		return decryptedStringStringBuilder.toString();
	}

}
