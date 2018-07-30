package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cyphers.ScytaleCipher;

/**
 * ScytaleCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class ScytaleCipherTest {

	ScytaleCipher sc = new ScytaleCipher(5);

	@Test
	void testEncryption() {
		assertEquals(sc.encrypt("IamhurtverybadlyHELP"), "IryyatbHmvaEhedLurlP");
	}

}
