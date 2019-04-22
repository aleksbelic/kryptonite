package tests;

import ciphers.PortaCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PortaCipherTest {

	private PortaCipher pc = new PortaCipher();

	@Test
	void testEncryption() {
		assertEquals(pc.encrypt("", "key"), "");
		assertEquals(pc.encrypt("Meetmeatthebridgeatfive", "key"), "RTQBOQSEHZTNMXPYTZBUUDT");
		assertEquals(pc.encrypt("Meet me at the bridge at five", "key"), "RTQBOQSEHZTNMXPYTZBUUDT");
		assertEquals(pc.encrypt("The Porta Cipher is a polyalphabetic substitution cipher invented by Giambattista della Porta", "someStrongKeyword"), "KOXAFILUVYKWQGPKOGHRJWUHOTRWEUNLMPJMOELKQHHSNATPKQMMYHENZWEZYSONYMLWJMTSNUTUJLMEZ");

		// plaintext exceptions
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some_plaintext_with_special_character!", "KEY"); // plaintext contains special char
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some plaintext with numbers 123", "KEY"); // plaintext contains number
		});

		// keyword exceptions
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some plaintext", ""); // keyword is empty string
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some plaintext", "keyword with whitespace"); // keyword contains whitespace
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some plaintext", "keyword_with_special_char!"); // keyword contains special char
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some plaintext", "abc123"); // keyword contains number
		});
	}

	@Test
	void testDecryption() {
		assertEquals(pc.decrypt("", "key"), "");
		assertEquals(pc.decrypt("RTQBOQSEHZTNMXPYTZBUUDT", "key"), "MEETMEATTHEBRIDGEATFIVE");
		assertEquals(pc.decrypt("KOXAFILUVYKWQGPKOGHRJWUHOTRWEUNLMPJMOELKQHHSNATPKQMMYHENZWEZYSONYMLWJMTSNUTUJLMEZ", "someStrongKeyword"), "THEPORTACIPHERISAPOLYALPHABETICSUBSTITUTIONCIPHERINVENTEDBYGIAMBATTISTADELLAPORTA");

		// ciphertext exceptions
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some_ciphertext_with_special_character!", "KEY"); // ciphertext contains special char
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some ciphertext with numbers 123", "KEY"); // cipher contains number
		});

		// keyword exceptions
		assertThrows(IllegalArgumentException.class, () -> {
			pc.decrypt("Some ciphertext", ""); // keyword is empty string
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pc.decrypt("Some ciphertext", "keyword with whitespace"); // keyword contains whitespace
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pc.decrypt("Some ciphertext", "keyword_with_special_char!"); // keyword contains special char
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pc.decrypt("Some ciphertext", "abc123"); // keyword contains number
		});
	}

}
