package cyphers;

/**
 * CeaserCipher class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class CaesarCipher {

	private String alphabet;

	public CaesarCipher(String alphabet) {
		this.alphabet = alphabet;
	}

	/**
	 * Encrypts given string with a given key.
	 * 
	 * @param s   string to encrypt
	 * @param key key for creating shifted alphabet
	 * @return encrypted string
	 */
	public String encrypt(String s, int key) {
		key %= this.alphabet.length();
		String shiftedAlphabet = this.alphabet.substring(key) + this.alphabet.substring(0, key);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int charPositionInAlphabet = this.alphabet.indexOf(Character.toUpperCase(s.charAt(i)));
			if (charPositionInAlphabet != -1) {
				if (Character.isUpperCase(s.charAt(i))) {
					sb.append(shiftedAlphabet.charAt(charPositionInAlphabet));
				} else {
					sb.append(Character.toLowerCase(shiftedAlphabet.charAt(charPositionInAlphabet)));
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * Decrypts given string with a given key.
	 * 
	 * @param s   string to decrypt
	 * @param key key for creating shifted alphabet
	 * @return decrypted string
	 */
	public String decrypt(String s, int key) {
		key %= this.alphabet.length();
		String shiftedAlphabet = this.alphabet.substring(key) + this.alphabet.substring(0, key);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int charPositionInShiftedAlphabet = shiftedAlphabet.indexOf(Character.toUpperCase(s.charAt(i)));
			if (charPositionInShiftedAlphabet != -1) {
				if (Character.isUpperCase(s.charAt(i))) {
					sb.append(this.alphabet.charAt(charPositionInShiftedAlphabet));
				} else {
					sb.append(Character.toLowerCase(this.alphabet.charAt(charPositionInShiftedAlphabet)));
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * Encrypts given string with two given key, 1st for every even and 2nd for
	 * every odd char position.
	 * 
	 * @param s    string to encrypt
	 * @param key1 key for creating shifted alphabet for every even char
	 * @param key2 key for creating shifted alphabet for every odd char
	 * @return encrypted string
	 */
	public String encryptTwoKeys(String s, int key1, int key2) {
		key1 %= this.alphabet.length();
		key2 %= this.alphabet.length();
		String shiftedAlphabet;
		String shiftedAlphabet1 = this.alphabet.substring(key1) + this.alphabet.substring(0, key1);
		String shiftedAlphabet2 = this.alphabet.substring(key2) + this.alphabet.substring(0, key2);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				shiftedAlphabet = shiftedAlphabet1;
			} else {
				shiftedAlphabet = shiftedAlphabet2;
			}
			int charPositionInAlphabet = this.alphabet.indexOf(Character.toUpperCase(s.charAt(i)));
			if (charPositionInAlphabet != -1) {
				if (Character.isUpperCase(s.charAt(i))) {
					sb.append(shiftedAlphabet.charAt(charPositionInAlphabet));
				} else {
					sb.append(Character.toLowerCase(shiftedAlphabet.charAt(charPositionInAlphabet)));
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * Decrypts given string with two given key, 1st for every even and 2nd for
	 * every odd char position.
	 * 
	 * @param s    string to decrypt
	 * @param key1 key for creating shifted alphabet for every even char
	 * @param key2 key for creating shifted alphabet for every odd char
	 * @return decrypted string
	 */
	public String decryptTwoKeys(String s, int key1, int key2) {
		key1 %= this.alphabet.length();
		key2 %= this.alphabet.length();
		String shiftedAlphabet;
		String shiftedAlphabet1 = this.alphabet.substring(key1) + this.alphabet.substring(0, key1);
		String shiftedAlphabet2 = this.alphabet.substring(key2) + this.alphabet.substring(0, key2);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				shiftedAlphabet = shiftedAlphabet1;
			} else {
				shiftedAlphabet = shiftedAlphabet2;
			}
			int charPositionInShiftedAlphabet = shiftedAlphabet.indexOf(Character.toUpperCase(s.charAt(i)));
			if (charPositionInShiftedAlphabet != -1) {
				if (Character.isUpperCase(s.charAt(i))) {
					sb.append(this.alphabet.charAt(charPositionInShiftedAlphabet));
				} else {
					sb.append(Character.toLowerCase(this.alphabet.charAt(charPositionInShiftedAlphabet)));
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * Prints decrypted string with every key in the alphabet.
	 * 
	 * @param s string to decrypt
	 */
	public void eyeball(String s) {
		for (int i = 1; i <= this.alphabet.length(); i++) {
			System.out.println(this.decrypt(s, i));
		}
	}

	/**
	 * Prints decrypted string with every two-key combination in the alphabet.
	 * 
	 * @param s string to decrypt
	 */
	public void eyeballTwoKeys(String s) {
		for (int i = 1; i <= this.alphabet.length(); i++) {
			for (int j = 1; j <= this.alphabet.length(); j++) {
				System.out.println(this.decryptTwoKeys(s, i, j));
			}
		}
	}

}
