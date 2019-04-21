package ciphers;

import common.Constants;

/**
 * Porta Cipher class.
 * The Porta Cipher is a polyalphabetic substitution cipher invented by Giambattista della Porta.
 * It uses only 13 alphabets so that the first half (A-M) is reciprocal with the second half.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class PortaCipher {

	/**
	 * Encrypts given string using specified keyword.
	 *
	 * @param plaintext string to encrypt
	 * @param keyword   phrase to use in encryption process
	 * @return ciphertext
	 */
	public String encrypt(String plaintext, String keyword) {

		plaintext = plaintext.replaceAll("\\s+","");

		String alphabet = Constants.ALPHABET_EN;
		StringBuilder plaintextStringBuilder = new StringBuilder();

		for (int i = 0; i < plaintext.length(); i++) {
			char currentChar = plaintext.toUpperCase().charAt(i);
			char currentKeywordChar = keyword.toUpperCase().charAt(i % keyword.length());

			int currentKeywordCharIndexInAlphabet = alphabet.indexOf(currentKeywordChar);
			if (currentKeywordCharIndexInAlphabet == -1) {
				throw new IllegalArgumentException("ERROR: keyword can contain only English alphabet letters, no whitespace.");
			}
			if (currentKeywordCharIndexInAlphabet != -1) {
				int keywordLetterGroup = currentKeywordCharIndexInAlphabet / 2;
				String keywordLetterGroupAlphabet = alphabet.substring(0, 13) + alphabet.substring(13).substring(keywordLetterGroup) + alphabet.substring(13).substring(0, keywordLetterGroup);

				int substitutionCharIndex = (keywordLetterGroupAlphabet.indexOf(currentChar) + 13) % alphabet.length();
				plaintextStringBuilder.append(keywordLetterGroupAlphabet.charAt(substitutionCharIndex));

			}
		}
		return plaintextStringBuilder.toString();

	}

	/**
	 * Decrypts given string using specified keyword.
	 *
	 * @param ciphertext string to decrypt
	 * @param keyword   phrase to use in decryption process
	 * @return plaintext
	 */
	public String decrypt(String ciphertext, String keyword) {
		return this.encrypt(ciphertext, keyword);
	}

}
