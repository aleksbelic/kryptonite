package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import common.Constants;
import cyphers.CaesarCipher;

class CeaserCipherTest {

	CaesarCipher cc = new CaesarCipher(Constants.ALPHABET_EN);

	@Test
	void testEncryption() {
		assertEquals(cc.encrypt("ABBA", 1), "BCCB");
		assertEquals(cc.encrypt("aBBA", 1), "bCCB");
		assertEquals(cc.encrypt("aBB!", 1), "bCC!");
	}

}
