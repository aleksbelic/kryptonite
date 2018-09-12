package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ciphers.AtbashCipher;
import common.Constants;

/**
 * AtbashCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class AtbashCipherTest {

	AtbashCipher atb = new AtbashCipher(Constants.ALPHABET_EN);
	
	@Test
	void testEncryption() {
		assertEquals(atb.encode("This is some hidden message."), "Gsrh rh hlnv srwwvm nvhhztv.");
	}

	@Test
	void testDecryption() {
		assertEquals(atb.encode("Gsrh rh hlnv srwwvm nvhhztv."), "This is some hidden message.");
	}

}
