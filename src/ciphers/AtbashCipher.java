package ciphers;

/**
 * Atbash Cipher class.<br>
 * Atbash is monoalphabetic substitution cipher formed by taking the alphabet and mapping it to its reverse,
 * so that the first letter becomes the last letter, the second letter becomes the second to last letter, and so on.<br>
 * Example for English alphabet:<br>
 * <ul>
 * <li>plaintext: ABC</li>
 * <li>ciphertext: ZYX</li>
 * </ul>
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class AtbashCipher {
	
	private String alphabet;
	
	public AtbashCipher(String alphabet) {
		this.alphabet = alphabet;
	}
	
	/**
	 * Encodes plaintext.
	 * 
	 * @param plaintext string to encode
	 * @return ciphertext
	 */
	public String encode(String plaintext) {
	    StringBuilder ciphertextStringBuilder = new StringBuilder();
		for (int i = 0; i < plaintext.length(); i++) {
			char currentChar = plaintext.charAt(i);
			if (alphabet.indexOf(Character.toLowerCase(currentChar)) != -1 || alphabet.indexOf(Character.toUpperCase(currentChar)) != -1) {
				int currentCharAlphabetIndex = alphabet.indexOf(Character.toLowerCase(currentChar)) != -1 ? alphabet.indexOf(Character.toLowerCase(currentChar)) : alphabet.indexOf(Character.toUpperCase(currentChar));
				char substitutionChar = alphabet.charAt(alphabet.length() - currentCharAlphabetIndex - 1);
                ciphertextStringBuilder.append(Character.isLowerCase(currentChar) ? Character.toLowerCase(substitutionChar) : Character.toUpperCase(substitutionChar));
			} else {
                ciphertextStringBuilder.append(currentChar);
			}
		}
		return ciphertextStringBuilder.toString();
	}
	
	/**
	 * Decodes ciphertext.
	 * 
	 * @param ciphertext string to decipher
	 * @return plaintext
	 */
	public String decode(String ciphertext) {
		return encode(ciphertext);
	}
	
}
