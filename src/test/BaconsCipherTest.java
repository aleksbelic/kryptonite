package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cyphers.BaconsCipher;

/**
 * BaconsCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class BaconsCipherTest {

	BaconsCipher bc1 = new BaconsCipher("1");
	BaconsCipher bc2 = new BaconsCipher("2");

	@Test
	void testEncryption() {
		//assertEquals(bc1.encrypt("Just testing version 1", "the quick brown fox jumps over the lazy dog"), "---");
		//assertEquals(bc2.encrypt("Just testing version 2", "the quick brown fox jumps over the lazy dog"), "---");
	}

	@Test
	void testDecryption() {

	}

}
