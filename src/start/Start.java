package start;

import cyphers.CaesarCipher;
import common.Constants;

public class Start {

	public static void main(String[] args) {
		
		CaesarCipher cc = new CaesarCipher(Constants.ALPHABET_EN);
		System.out.println(cc.decryptTwoKeys("Some text!", 15, 20));
		cc.eyeballTwoKeys("Duxk zpde!");
		
	}

}
