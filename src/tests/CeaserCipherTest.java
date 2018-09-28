package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ciphers.CaesarCipher;
import common.Constants;

/**
 * CeaserCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class CeaserCipherTest {

	private CaesarCipher cc = new CaesarCipher(Constants.ALPHABET_EN);

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

	@Test
	void testEncryptTwoKeys() {
		assertEquals(cc.encryptTwoKeys("Just some silly Message.", 3, 4), "Myvx wrqh vmopb Pivwdkh.");
	}

	@Test
	void testDecryptTwoKeys() {
		assertEquals(cc.decryptTwoKeys("Myvx wrqh vmopb Pivwdkh.", 3, 4), "Just some silly Message.");
	}

	// TODO eyeball
	// TODO eyeballTwoKeys

}
