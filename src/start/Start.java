package start;

import cyphers.CaesarCipher;
import common.Constants;

public class Start {

	public static void main(String[] args) {
		
		CaesarCipher cc = new CaesarCipher(Constants.ALPHABET_EN);
		cc.eyeball("Knwxy Qjlnts!");
		
	}

}
