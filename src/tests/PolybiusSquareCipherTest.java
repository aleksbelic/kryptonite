package tests;

import ciphers.PolybiusSquareCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PolybiusSquareCipherTest {

	PolybiusSquareCipher psc = new PolybiusSquareCipher();

	@Test
	void testEncryption() {
		assertEquals(psc.encode(""), "");
		assertEquals(psc.encode(" abc"), "111213"); // trim
		assertEquals(psc.encode("abc "), "111213"); // trim
		assertEquals(psc.encode("ab         c"), "1112 13"); // regex
		assertEquals(psc.encode("Hello world"), "2315313134 5234423114");
		assertEquals(psc.encode("This is a secret message"), "44232443 2443 11 431513421544 32154343112215");

		// plaintext exceptions
		assertThrows(IllegalArgumentException.class, () -> {
			psc.encode("Some_plaintext_with_special_character!"); // plaintext contains special char
		});
	}

	@Test
	void testDecryption() {
		// TODO
	}

}
