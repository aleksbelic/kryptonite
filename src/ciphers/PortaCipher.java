package ciphers;

import common.Constants;

/**
 * Porta Cipher class.
 * The Porta Cipher is a polyalphabetic substitution cipher invented by Giambattista della Porta.
 * It uses only 13 alphabets so that the first half (A-M) is reciprocal with the second half.
 *
 * Keys  A B C D E F G H I J K L M
 * -------------------------------
 * A,B 	 N O P Q R S T U V W X Y Z
 * C,D 	 O P Q R S T U V W X Y Z N
 * E,F 	 P Q R S T U V W X Y Z N O
 * G,H 	 Q R S T U V W X Y Z N O P
 * I,J 	 R S T U V W X Y Z N O P Q
 * K,L 	 S T U V W X Y Z N O P Q R
 * M,N 	 T U V W X Y Z N O P Q R S
 * O,P 	 U V W X Y Z N O P Q R S T
 * Q,R 	 V W X Y Z N O P Q R S T U
 * S,T 	 W X Y Z N O P Q R S T U V
 * U,V 	 X Y Z N O P Q R S T U V W
 * W,X 	 Y Z N O P Q R S T U V W X
 * Y,Z 	 Z N O P Q R S T U V W X Y
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

		if (keyword.isEmpty())
			throw new IllegalArgumentException("ERROR: keyword cannot be an empty string.");

		// removing whitespace
		plaintext = plaintext.replaceAll("\\s+", "");

		String alphabet = Constants.ALPHABET_EN;
		StringBuilder plaintextStringBuilder = new StringBuilder();

		for (int i = 0; i < plaintext.length(); i++) {
			char currentChar = plaintext.toUpperCase().charAt(i);
			char currentKeywordChar = keyword.toUpperCase().charAt(i % keyword.length());

			int currentKeywordCharIndexInAlphabet = alphabet.indexOf(currentKeywordChar);
			if (currentKeywordCharIndexInAlphabet == -1) {
				throw new IllegalArgumentException("ERROR: keyword can contain only English alphabet letters, no whitespace, numbers or special characters.");
			} else {
				int keywordLetterGroup = currentKeywordCharIndexInAlphabet / 2;
				String keywordLetterGroupAlphabet = alphabet.substring(0, 13) + alphabet.substring(13).substring(keywordLetterGroup) + alphabet.substring(13).substring(0, keywordLetterGroup);

				int currentCharPositionInKeywordLetterGroupAlphabet = keywordLetterGroupAlphabet.indexOf(currentChar);
				if (currentCharPositionInKeywordLetterGroupAlphabet == -1) {
					throw new IllegalArgumentException("ERROR: Plaintext & ciphertext can contain only English alphabet letters, no numbers or special characters allowed.");
				} else {
					int substitutionCharIndex = (currentCharPositionInKeywordLetterGroupAlphabet + 13) % keywordLetterGroupAlphabet.length();
					plaintextStringBuilder.append(keywordLetterGroupAlphabet.charAt(substitutionCharIndex));
				}
			}
		}
		return plaintextStringBuilder.toString();

	}

	/**
	 * Decrypts given string using specified keyword.
	 *
	 * @param ciphertext string to decrypt
	 * @param keyword    phrase to use in decryption process
	 * @return plaintext
	 */
	public String decrypt(String ciphertext, String keyword) {
		return this.encrypt(ciphertext, keyword);
	}

}
