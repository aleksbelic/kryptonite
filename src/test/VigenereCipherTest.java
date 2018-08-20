package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import cyphers.VigenereCipher;

/**
 * VigenereCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class VigenereCipherTest {

	VigenereCipher vc = new VigenereCipher();

	@Test
	void testEncryption() {
		assertEquals(vc.encrypt("ATTACKATDAWN", "LEMON"), "LXFOPVEFRNHR");
		assertEquals(vc.encrypt("ATTACK AT DAWN", "LEMON"), "LXFOPV EF RNHR");
	}

}
