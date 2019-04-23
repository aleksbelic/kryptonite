package tests;

import ciphers.ROT13Cipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ROT13 cipher test class.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class ROT13CipherTest {

	private ROT13Cipher rot13 = new ROT13Cipher();

	@Test
	void testEncryption() {
		assertEquals(rot13.encode("ABBA"), "NOON");
		assertEquals(rot13.encode("aBBA"), "nOON");
		assertEquals(rot13.encode("aB B!"), "nO O!");
	}

	@Test
	void testDecryption() {
		assertEquals(rot13.decode("NOON"), "ABBA");
		assertEquals(rot13.decode("nOON"), "aBBA");
		assertEquals(rot13.decode("nO O!"), "aB B!");
	}

}
