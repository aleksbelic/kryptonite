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
	 * @param plaintext string to encrypt
	 * @return ciphertext
	 */
	public String encrypt(String plaintext) {
		StringBuilder encryptedStringStringBuilder = new StringBuilder();
		ArrayList<Character> charArrayList = new ArrayList<>();
		for (int i = 0; i < plaintext.length(); i++) {
			charArrayList.add(plaintext.charAt(i));
		}
		int i = 0;
		while (encryptedStringStringBuilder.length() != plaintext.length()) {
			if (charArrayList.get(i) != null) {
				encryptedStringStringBuilder.append(charArrayList.get(i));
				charArrayList.set(i, null);
				i = (i + (plaintext.length() / diameter)) % plaintext.length();
			} else i++;
		}
		return encryptedStringStringBuilder.toString();
	}
	
	/**
	 * Decrypts given string for specific rod diameter.
	 * 
	 * @param ciphertext string to decrypt
	 * @return plaintext
	 */
	public String decrypt(String ciphertext) {
		StringBuilder decryptedStringStringBuilder = new StringBuilder();
		ArrayList<Character> charArrayList = new ArrayList<>();
		for (int i = 0; i < ciphertext.length(); i++)
			charArrayList.add(ciphertext.charAt(i));
		int i = 0;
		while (decryptedStringStringBuilder.length() != ciphertext.length()) {
			if (charArrayList.get(i) != null) {
				decryptedStringStringBuilder.append(charArrayList.get(i));
				charArrayList.set(i, null);
				i = (i + diameter) % ciphertext.length();
			} else i++;
		}
		return decryptedStringStringBuilder.toString();
	}

}
