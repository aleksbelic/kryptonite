package cyphers;

import java.util.HashMap;
import common.Constants;

/**
 * VigenereCipher class.
 * 
 * @author Aleksandar.Belic <aleks.belic@gmail.com>
 *
 */
public class VigenereCipher {
	
	private String alphabet = Constants.ALPHABET_EN;
	private HashMap<Character, String> tabulaRecta = new HashMap<Character, String>();
	
	/**
	 * Constructor generates tabula recta with default english alphabet.
	 */
	public VigenereCipher() {
		alphabet = Constants.ALPHABET_EN;
		String shiftedAlphabet = "";
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
		String shiftedAlphabet = "";
		for (int i = 0; i < alphabet.length(); i++) {
			shiftedAlphabet = alphabet.substring(i) + alphabet.substring(0, i);
			tabulaRecta.put(alphabet.charAt(i), shiftedAlphabet);
		}
	}
	
}
