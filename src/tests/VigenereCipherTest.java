package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ciphers.VigenereCipher;
import common.Constants;

/**
 * VigenereCipherTest class.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class VigenereCipherTest {

	private VigenereCipher vc = new VigenereCipher();
	private VigenereCipher vcGermanAlphabet = new VigenereCipher(Constants.ALPHABET_DE); // TODO

	@Test
	void testEncryption() {
		assertEquals(vc.encrypt("ATTACKATDAWN", "LEMON"), "LXFOPVEFRNHR");
		assertEquals(vc.encrypt("ATTACK AT DAWN", "LEMON"), "LXFOPV EF RNHR");
		assertEquals(vc.encrypt("attack at dawn", "lemon"), "LXFOPV EF RNHR");
	}
	
	@Test
	void testDecryption() {
		assertEquals(vc.decrypt("LXFOPVEFRNHR", "LEMON"), "ATTACKATDAWN");
		assertEquals(vc.decrypt("LXFOPV EF RNHR", "LEMON"), "ATTACK AT DAWN");
		assertEquals(vc.decrypt("lxfopv ef rnhr", "lemon"), "ATTACK AT DAWN");
	}

}
