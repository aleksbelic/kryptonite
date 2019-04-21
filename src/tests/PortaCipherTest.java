package tests;

import ciphers.PortaCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PortaCipherTest {

	private PortaCipher pc = new PortaCipher();

	@Test
	void testEncryption() {
		assertEquals(pc.encrypt("Meetmeatthebridgeatfive", "key"), "RTQBOQSEHZTNMXPYTZBUUDT");
		assertEquals(pc.encrypt("Meet me at the bridge at five", "key"), "RTQBOQSEHZTNMXPYTZBUUDT");
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some plaintext", "keyword with whitespace"); // whitespace in keyword
		});
		assertThrows(IllegalArgumentException.class, () -> {
			pc.encrypt("Some plaintext", "k3yw0rd_w1th_non-english_char"); // non-english char
		});
	}

	@Test
	void testDecryption() {
		//assertEquals(pc.decrypt("RTQB OQ SE HZT NMXPYT ZB UUDT", ""), "MEET ME AT THE BRIDGE AT FIVE");
	}

}
