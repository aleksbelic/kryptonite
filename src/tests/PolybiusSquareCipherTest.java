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
		assertEquals(psc.decode(""), "");
		assertEquals(psc.decode(" 111213"), "ABC"); // trim
		assertEquals(psc.decode("111213 "), "ABC"); // trim
		assertEquals(psc.decode("1112       13"), "AB C"); // regex
		assertEquals(psc.decode("2315313134 5234423114"), "HELLO WORLD");
		assertEquals(psc.decode("44232443 2443 11 431513421544 32154343112215"), "THIS IS A SECRET MESSAGE");

		// ciphertext exceptions
		assertThrows(IllegalArgumentException.class, () -> {
			psc.decode("111"); // odd count of numbers
		});
		assertThrows(IllegalArgumentException.class, () -> {
			psc.decode("1112 123 12"); // odd count of numbers
		});
		assertThrows(IllegalArgumentException.class, () -> {
			psc.decode("99"); // substitution letter not found, array index out of bounds
		});
		assertThrows(IllegalArgumentException.class, () -> {
			psc.decode("AA"); // NaN
		});
		assertThrows(IllegalArgumentException.class, () -> {
			psc.decode("11AA"); // NaN
		});
	}

}
