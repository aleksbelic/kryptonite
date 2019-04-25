package ciphers;

import common.Constants;

import java.util.HashMap;

/**
 * Morse code/cipher class.<br>
 * Morse code is a character encoding scheme used in telecommunication that encodes text characters as standardized
 * sequences of two different signal durations called dots (dits) and dashes (dahs).
 * Morse code is named for Samuel F. B. Morse, an inventor of the telegraph.
 * <br><br>
 * Example:
 * <ul>
 * <li>plaintext: Hello world</li>
 * <li>ciphertext: .... . .-.. .-.. ---/.-- --- .-. .-.. -..</li>
 * </ul>
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class MorseCipher {

	private HashMap<Character, String> subsitutionMap = Constants.MORSE_CODE;

	/**
	 * Encodes plaintext.
	 *
	 * @param plaintext string to encode.
	 * @return ciphertext
	 */
	public String encode(String plaintext) {

		// trim, remove excess whitespace, to upper case
		plaintext = plaintext.trim().replaceAll("\\s\\s+", " ").toUpperCase();
		StringBuilder ciphertextStringBuilder = new StringBuilder();

		String[] words =  plaintext.split(" ");
		for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
			for (int letterIndex = 0; letterIndex < words[wordIndex].length(); letterIndex++) {
				char currentChar = words[wordIndex].charAt(letterIndex);
				if (subsitutionMap.get(currentChar) == null)
					throw new IllegalArgumentException("ERROR: plaintext contains unsupported character: " + currentChar);
				else {
					ciphertextStringBuilder.append(subsitutionMap.get(currentChar));
					if (letterIndex != words[wordIndex].length() - 1)
						ciphertextStringBuilder.append(" ");
				}
			}
			if (wordIndex != words.length - 1)
				ciphertextStringBuilder.append("/");
		}

		return ciphertextStringBuilder.toString();
	}

	/**
	 * Decodes ciphertext.
	 *
	 * @param ciphertext string to decode.
	 * @return plaintext
	 */
	public String decode(String ciphertext) {

		// trim, excess whitespace
		ciphertext = ciphertext.trim().replaceAll("\\s\\s+", " ");
		StringBuilder plaintextStringBuilder = new StringBuilder();

		String[] words = ciphertext.split("/");
		for (int i = 0; i < words.length; i++) {

			String currentWord = words[i];
			if (currentWord.isEmpty()) continue; // ignore empty string
			String[] lettersInCurrentWord = currentWord.split(" ");

			for (String letterInCurrentWord : lettersInCurrentWord) {
				boolean letterFound = false;
				for (Object subsitutionMapKey : subsitutionMap.keySet()) {
					if (subsitutionMap.get(subsitutionMapKey).equals(letterInCurrentWord)) {
						plaintextStringBuilder.append(subsitutionMapKey);
						letterFound = true;
						break;
					}
				}
				if (!letterFound)
					throw new IllegalArgumentException("ERROR: letter not found, make sure ciphertext contains only dots, dashes, slashes and whitespace.");
			}
			if (i != words.length - 1)
				plaintextStringBuilder.append(" "); // split words
		}

		return plaintextStringBuilder.toString();
	}

}
