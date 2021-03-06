package ciphers;

import java.util.Arrays;

/**
 * Rail Fence Cipher class.<br>
 * Example for 3 rails and no whitespace in ciphertext:<br>
 * <ul>
 * <li>plaintext: WE ARE DISCOVERED FLEE AT ONCE</li>
 * <li>ciphertext: WECRLTEERDSOEEFEAOCAIVDEN</li>
 * </ul>
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class RailFenceCipher {

	private int railCount;
	public RailFenceCipher() {
		this.railCount = 2;
	}
	public RailFenceCipher(int railCount) {
		this.railCount = railCount;
	}
	
	/**
	 * Encrypts plaintext using Rail Fence Cipher.
	 * 
	 * @param plaintext text to encrypt
	 * @param encryptWhitespace should whitespace also be included in ciphertext
	 * @return ciphertext
	 */
	public String encrypt(String plaintext, boolean encryptWhitespace) {
		if (!encryptWhitespace)
			plaintext = plaintext.replaceAll("\\s+","");
		String[] ciphertextRails = new String[this.railCount];
		Arrays.fill(ciphertextRails, "");
		for (int i = 0; i < plaintext.length(); i++)
			ciphertextRails[i % this.railCount] += plaintext.charAt(i);
		return String.join("", ciphertextRails);
	}
	
	/**
	 * Decrypts Rail Fence ciphertext.
	 * 
	 * @param ciphertext string to decrypt
	 * @return plaintext
	 */
	public String decrypt(String ciphertext) {

		StringBuilder plaintextStringBuilder = new StringBuilder();
		
		String[] ciphertextRails = new String[this.railCount];
		String ciphertextTemp = ciphertext;
		int railCountTemp = this.railCount;
		
		Arrays.fill(ciphertextRails, "");
		for (int i = 0; i < this.railCount; i++) {
			int ciphertextRailsLength = (ciphertextTemp.length() % railCountTemp == 0) ? ciphertextTemp.length() / railCountTemp : (ciphertextTemp.length() / railCountTemp) + 1;
			ciphertextRails[i] = ciphertextTemp.substring(0, ciphertextRailsLength);
			ciphertextTemp = ciphertextTemp.substring(ciphertextRailsLength);
			railCountTemp--;
		}
		
		for (int i = 0; i < ciphertextRails[0].length(); i++) { // ciphertextRails[0] is always the longest
			for (int j = 0; j < ciphertextRails.length; j++) {
				if (plaintextStringBuilder.length() == ciphertext.length())
					return plaintextStringBuilder.toString();
				plaintextStringBuilder.append(ciphertextRails[j].charAt(i));
			}
		}
		return plaintextStringBuilder.toString();
	}

}
