package ciphers;

import common.Constants;

/**
 * ROT13 cipher class.<br>
 * ROT13 (rotate by 13 places) is a simple letter substitution cipher that replaces a letter with the 13th letter
 * after it, in the alphabet. ROT13 is a special case of the Caesar cipher which was developed in ancient Rome.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class ROT13Cipher {

	private CaesarCipher cc = new CaesarCipher(Constants.ALPHABET_EN);

	/**
	 * Encodes plaintext.
	 *
	 * @param plaintext string to encode.
	 * @return ciphertext
	 */
	public String encode(String plaintext) {
		return cc.encrypt(plaintext, 13);
	}

	/**
	 * Decodes ciphertext.
	 *
	 * @param ciphertext string to decode.
	 * @return plaitext
	 */
	public String decode(String ciphertext) {
		return encode(ciphertext);
	}

}
