package cyphers;

public class CaesarCipher {

	private String alphabet;

	public CaesarCipher(String alphabet) {
		this.alphabet = alphabet;
	}

	/**
	 * Encrypts given string for given key.
	 * @param s, string to encrypt
	 * @param key, key for creating shifted alphabet
	 * @return encrypted string
	 */
	public String encrypt(String s, int key) {
		key %= this.alphabet.length();
		String shiftedAlphabet = this.alphabet.substring(key) + this.alphabet.substring(0, key);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int charPositionInAlphabet = this.alphabet.indexOf(s.charAt(i));
			if (charPositionInAlphabet != -1) { // if char found
				sb.append(shiftedAlphabet.charAt(charPositionInAlphabet));
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * Decrypts given string for given key.
	 * @param s, string to decrypt
	 * @param key, key for creating shifted alphabet
	 * @return decrypted string
	 */
	public String decrypt(String s, int key) {
		key %= this.alphabet.length();
		String shiftedAlphabet = this.alphabet.substring(key) + this.alphabet.substring(0, key);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int charPositionInShiftedAlphabet = shiftedAlphabet.indexOf(s.charAt(i));
			if (charPositionInShiftedAlphabet != -1) { // if char found
				sb.append(this.alphabet.charAt(charPositionInShiftedAlphabet));
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

}
