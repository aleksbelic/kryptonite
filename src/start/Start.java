package start;

import cyphers.*;

/**
 * Start class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Start {

	public static void main(String[] args) {
		
		VigenereCipher vc = new VigenereCipher();
		System.out.println(vc.encrypt("ATTACK AT DAWN", "LEMON"));
		System.out.println(vc.decrypt("LXFOPV EF RNHR", "LEMON"));

	}

}
