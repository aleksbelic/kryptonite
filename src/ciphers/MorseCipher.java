package ciphers;

import common.Constants;

import java.util.HashMap;

/**
 * Morse code/cipher class.
 * Morse code is a character encoding scheme used in telecommunication that encodes text characters as standardized
 * sequences of two different signal durations called dots (dits) and dashes (dahs).
 * Morse code is named for Samuel F. B. Morse, an inventor of the telegraph.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class MorseCipher {

	private HashMap<Character, String> subsitutionMap = Constants.MORSE_CODE;

	/**
	 * Encodes plaintext.
	 *
	 * @param plaintext plaintext to encode
	 * @return ciphertext
	 */
	public String encode(String plaintext) {

		// trim, remove excess whitespace, to uppercase
		plaintext = plaintext.trim().replaceAll("\\s\\s+", " ").toUpperCase();
		StringBuilder ciphertextStringBuilder = new StringBuilder();

		for (int i = 0; i < plaintext.length(); i++) {
			char currentChar = plaintext.charAt(i);
			if (currentChar == ' ') {
				ciphertextStringBuilder.append("/");
			} else if (subsitutionMap.get(currentChar) == null) {
				throw new IllegalArgumentException("ERROR: plaintext contains unsupported character: " + currentChar);
			} else {
				ciphertextStringBuilder.append(subsitutionMap.get(currentChar));
				if (i != (plaintext.length() - 1) && plaintext.charAt(i + 1) != ' ') {
					ciphertextStringBuilder.append(" ");
				}
			}
		}

		return ciphertextStringBuilder.toString();
	}

	/**
	 * Decodes ciphertext.
	 *
	 * @param ciphertext string to decode.
	 * @return plaintext
	 */
	public String decode(String ciphertext) { // TODO
		return "";
	}

}
