package start;

import cyphers.Caesar;
import common.Constants;

public class Start {

	public static void main(String[] args) {
		
		Caesar c = new Caesar(Constants.ALPHABET_EN, 1);
		System.out.println(c.encrypt("ABBA"));
		System.out.println(c.decrypt("BCCB"));
	}

}
