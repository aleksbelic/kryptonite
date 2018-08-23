package start;

import cyphers.*;

/**
 * Start class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Start {

	public static void main(String[] args) {
		
		RailFenceCipher rfc = new RailFenceCipher(3);
		System.out.println(rfc.encrypt("WE ARE DISCOVERED FLEE AT ONCE", false));

	}

}
