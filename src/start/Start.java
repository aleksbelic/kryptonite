package start;

import cyphers.CaesarCipher;
import common.Constants;

public class Start {

	public static void main(String[] args) {
		
		CaesarCipher c = new CaesarCipher(Constants.ALPHABET_EN);
		System.out.println(c.encryptTwoKeys("First Legion!", 23, 17));
		System.out.println(c.decryptTwoKeys("Czojq Ivdzle!", 23, 17));
	}

}
