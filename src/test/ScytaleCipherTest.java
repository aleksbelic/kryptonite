package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ciphers.ScytaleCipher;

/**
 * ScytaleCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class ScytaleCipherTest {

	ScytaleCipher sc = new ScytaleCipher(1);
	ScytaleCipher sc2 = new ScytaleCipher(2);
	ScytaleCipher sc3 = new ScytaleCipher(4);

	@Test
	void testEncryption() {
		assertEquals(sc.encrypt("ABCD"), "ABCD");
		assertEquals(sc2.encrypt("ABCD"), "ACBD");
		assertEquals(sc3.encrypt("IamhurtverybadlyHELP"), "IryyatbHmvaEhedLurlP");
	}
	
	@Test
	void testDecryption() {
		assertEquals(sc.decrypt("ABCD"), "ABCD");
		assertEquals(sc2.decrypt("ACBD"), "ABCD");
		assertEquals(sc3.decrypt("IryyatbHmvaEhedLurlP"), "IamhurtverybadlyHELP");
	}

}
