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
	 * Encrypts plaintext using Reil Fence Cipher.
	 * 
	 * @param plaintext text to encrypt
	 * @param encryptWhitespace should whitespace also be included in cipertext
	 * @return encrypted ciphertext
	 */
	public String encrypt(String plaintext, boolean encryptWhitespace) {
		if (!encryptWhitespace) {
			plaintext = plaintext.replaceAll("\\s+","");
		}
		String[] ciphertextRails = new String[this.railCount];
		Arrays.fill(ciphertextRails, "");
		for (int i = 0; i < plaintext.length(); i++) {
			ciphertextRails[i % this.railCount] += plaintext.charAt(i);
		}
		return String.join("", ciphertextRails);
	}
	
	/**
	 * Decrypts Reil Fence ciphertext.
	 * 
	 * @param ciphertext text to be deciphered
	 * @return plaintext
	 */
	public String decrypt(String ciphertext) {

		String plaintext = "";
		/*
		String[] ciphertextRails = new String[this.railCount];
		Arrays.fill(ciphertextRails, "");
		for (int i = 0; i < ciphertext.length(); i++) {
			ciphertextRails[i % this.railCount] += ciphertext.charAt(i);
		}
		System.out.println(ciphertextRails[0]);
		System.out.println(ciphertextRails[1]);
		*/
		
		return plaintext;
	}

}
