package start;

import cyphers.*;

/**
 * Start class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Start {

	public static void main(String[] args) {
		
		BaconsCipher bc = new BaconsCipher("2");
		System.out.println(bc.encrypt("Testing", "the quick brown fox jumps over the lazy dog"));
	}

}
