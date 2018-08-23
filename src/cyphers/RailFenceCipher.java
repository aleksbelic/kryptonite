package cyphers;

import java.util.Arrays;

/**
 * Rail Fence Cipher class.<br>
 * Example for 3 rails and no whitespace in cipher text:<br>
 * <ul>
 * <li>plaint text: WE ARE DISCOVERED FLEE AT ONCE</li>
 * <li>cipher text: WECRLTEERDSOEEFEAOCAIVDEN</li>
 * </ul>
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class RailFenceCipher {

	private int railCount = 2;

	public RailFenceCipher(int railCount) {
		this.railCount = railCount;
	}

	public String encrypt(String plainText, boolean encryptWhitespace) {
		if (!encryptWhitespace) {
			plainText = plainText.replaceAll("\\s+","");
		}
		String[] cipherTextRails = new String[this.railCount];
		Arrays.fill(cipherTextRails, "");
		for (int i = 0; i < plainText.length(); i++) {
			cipherTextRails[i % this.railCount] += plainText.charAt(i);
		}
		return String.join("", cipherTextRails);
	}

}
