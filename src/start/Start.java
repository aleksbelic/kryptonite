package start;

import cyphers.*;

/**
 * Start class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Start {

	public static void main(String[] args) {
		
		ScytaleCipher sc = new ScytaleCipher(5);
		System.out.println(sc.encrypt("IamhurtverybadlyHELP"));

	}

}
