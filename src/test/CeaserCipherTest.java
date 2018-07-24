package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import common.Constants;
import cyphers.CaesarCipher;

/**
 * CeaserCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class CeaserCipherTest {

	CaesarCipher cc = new CaesarCipher(Constants.ALPHABET_EN);

	@Test
	void testEncryption() {
		assertEquals(cc.encrypt("ABBA", 1), "BCCB");
		assertEquals(cc.encrypt("aBBA", 1), "bCCB");
		assertEquals(cc.encrypt("aB B!", 1), "bC C!");
	}

	@Test
	void testDecryption() {
		assertEquals(cc.decrypt("BCCB", 1), "ABBA");
		assertEquals(cc.decrypt("bCCB", 1), "aBBA");
		assertEquals(cc.decrypt("bC C!", 1), "aB B!");
	}

}
