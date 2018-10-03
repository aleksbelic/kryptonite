package start;

import ciphers.*;

/**
 * Start class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Start {

	public static void main(String[] args) {

		M94 m94 = new M94();
		m94.encrypt("THEXFILES");

	}

}
