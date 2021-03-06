package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ciphers.BaconsCipher;

/**
 * BaconsCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class BaconsCipherTest {

	private BaconsCipher bc1 = new BaconsCipher("1");
	private BaconsCipher bc2 = new BaconsCipher("2");
	
	@Test
	void testEncryptionToAB() {
		assertEquals(bc1.encryptToAB("Just IV"), "abaaabaabbbaaabbaabaabaaabaabb");
		assertEquals(bc2.encryptToAB("Test It"), "baabbaabaabaababaabbabaaabaabb");
	}
	
	@Test
	void testDecryptionAB() {
		assertEquals(bc1.decryptAB("abaaabaabbbaaabbaabaabaaabaabb"), "iustiu");
		assertEquals(bc2.decryptAB("baabbaabaabaababaabbabaaabaabb"), "testit");
	}
	
	@Test
	void testEncryption() {
		assertEquals(bc1.encrypt("Just IV", "This is a test message with bold for B"), "tHis iS a tEST mesSAge WitH bolD foR B");
		assertEquals(bc2.encrypt("Test It", "This is a test message with bold for B"), "ThiS Is a TesT meSsAge WItH bolD foR B");
	}

	@Test
	void testDecryption() {
		assertEquals(bc1.decrypt("tHis iS a tEST mesSAge WitH bolD foR B"), "iustiu");
		assertEquals(bc2.decrypt("ThiS Is a TesT meSsAge WItH bolD foR B"), "testit");
	}

	@Test
	void testCipherExceptions() {
		assertThrows(IllegalArgumentException.class, ()->{ // empty string
			bc1.encrypt("Testing", "");
        });
		assertThrows(IllegalArgumentException.class, ()->{ // white space loop
			bc1.encrypt("Testing", " ");
        });
		assertThrows(IllegalArgumentException.class, ()->{ // no letters
			bc1.encrypt("Testing", "1");
        });
		assertThrows(IllegalArgumentException.class, ()->{ // encrypted AB message length not divisible by 5
			bc1.decryptAB("aaaaaa"); // e.g. length = 6
        });
	}

}
