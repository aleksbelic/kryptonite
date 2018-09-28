package ciphers;

import java.util.HashMap;
import common.Constants;

/**
 * VigenereCipher class.
 * 
 * @author Aleksandar.Belic <aleks.belic@gmail.com>
 */
public class VigenereCipher {

	private String alphabet = Constants.ALPHABET_EN;
	private HashMap<Character, String> tabulaRecta = new HashMap<>();

	/**
	 * Constructor generates tabula recta with default english alphabet.
	 */
	public VigenereCipher() {
		String shiftedAlphabet;
		for (int i = 0; i < alphabet.length(); i++) {
			shiftedAlphabet = alphabet.substring(i) + alphabet.substring(0, i);
			tabulaRecta.put(alphabet.charAt(i), shiftedAlphabet);
		}
	}

	/**
	 * Constructor generates tabula recta with user defined alphabet.
	 */
	public VigenereCipher(String userAlphabet) {
		alphabet = userAlphabet;
		String shiftedAlphabet;
		for (int i = 0; i < alphabet.length(); i++) {
			shiftedAlphabet = alphabet.substring(i) + alphabet.substring(0, i);
			tabulaRecta.put(alphabet.charAt(i), shiftedAlphabet);
		}
	}

	/**
	 * Encrypts given string using specified keyword.
	 * 
	 * @param plaintext string to encrypt
	 * @param keyword phrase to use in encryption process
	 * @return ciphertext
	 */
	public String encrypt(String plaintext, String keyword) {
		keyword = keyword.toUpperCase();
		StringBuilder ciphertextStringBuilder = new StringBuilder();
		String shiftedAlphabet;
		char currentChar;
		int currentCharPositionInAlphabet;
		int keywordCounter;
		for (int i = 0, j = 0; i < plaintext.length(); i++, j++) {
			keywordCounter = j % keyword.length();
			currentChar = Character.toUpperCase(plaintext.charAt(i));
			if (alphabet.indexOf(currentChar) == -1) {
				ciphertextStringBuilder.append(currentChar);
				j--;
			} else {
				shiftedAlphabet = tabulaRecta.get(keyword.charAt(keywordCounter));
				currentCharPositionInAlphabet = alphabet.indexOf(currentChar);
				ciphertextStringBuilder.append(shiftedAlphabet.charAt(currentCharPositionInAlphabet));
			}
		}
		return ciphertextStringBuilder.toString();
	}

	/**
	 * Decrypts given string using specified keyword.
	 * 
	 * @param ciphertext string to decrypt
	 * @param keyword phrase to use in decryption process
	 * @return plaintext
	 */
	public String decrypt(String ciphertext, String keyword) {
		keyword = keyword.toUpperCase();
		StringBuilder plaintextStringBuilder = new StringBuilder();
		String shiftedAlphabet;
		char currentChar;
		int currentCharPositionInAlphabet;
		int keywordCounter;
		for (int i = 0, j = 0; i < ciphertext.length(); i++, j++) {
			keywordCounter = j % keyword.length();
			currentChar = Character.toUpperCase(ciphertext.charAt(i));
			if (alphabet.indexOf(currentChar) == -1) {
				plaintextStringBuilder.append(currentChar);
				j--;
			} else {
				shiftedAlphabet = tabulaRecta.get(keyword.charAt(keywordCounter));
				currentCharPositionInAlphabet = shiftedAlphabet.indexOf(currentChar);
				plaintextStringBuilder.append(alphabet.charAt(currentCharPositionInAlphabet));
			}
		}
		return plaintextStringBuilder.toString();
	}
}
