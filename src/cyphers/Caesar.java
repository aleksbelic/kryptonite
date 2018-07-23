package cyphers;

public class Caesar {

	private String alphabet;
	private int key;
	private String shiftedAlphabet;

	public Caesar(String alphabet, int key) {
		this.alphabet = alphabet;
		this.key = key % this.alphabet.length();
		this.shiftedAlphabet = alphabet.substring(this.key) + alphabet.substring(0, this.key);
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String encrypt(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int charPositionInAlphabet = this.alphabet.indexOf(s.charAt(i));
			if (charPositionInAlphabet != -1) { // if char found
				sb.append(this.shiftedAlphabet.charAt(charPositionInAlphabet));
			} else {
				sb.append('_');
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String decrypt(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int charPositionInShiftedAlphabet = this.shiftedAlphabet.indexOf(s.charAt(i));
			if (charPositionInShiftedAlphabet != -1) { // if char found
				sb.append(this.alphabet.charAt(charPositionInShiftedAlphabet));
			} else {
				sb.append('_');
			}
		}
		return sb.toString();
	}

}
