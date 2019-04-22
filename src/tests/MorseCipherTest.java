package tests;

import ciphers.MorseCipher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Morse code test class.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class MorseCipherTest {

	private MorseCipher mc = new MorseCipher();

	@Test
	void encodeTest() {
		assertEquals(mc.encode(""), ""); // empty string
		assertEquals(mc.encode(" "), ""); // trim
		assertEquals(mc.encode(" a"), ".-"); // trim left
		assertEquals(mc.encode("a "), ".-"); // trim right
		assertEquals(mc.encode("a b"), ".-/-...");
		assertEquals(mc.encode("a  b"), ".-/-..."); // regex
		assertEquals(mc.encode("a   b"), ".-/-..."); // regex
		assertEquals(mc.encode("abcdefghigklmnopqrstuvwxyz1234567890.,?'!/()&:;=+-_\"$@"), ".- -... -.-. -.. . ..-. --. .... .. --. -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. .---- ..--- ...-- ....- ..... -.... --... ---.. ----. ----- .-.-.- --..-- ..--.. .----. -.-.-- -..-. -.--. -.--.- .-... ---... -.-.-. -...- .-.-. -....- ..--.- .-..-. ...-..- .--.-.");
		assertEquals(mc.encode("ATTACK AT DAWN!"), ".- - - .- -.-. -.-/.- -/-.. .- .-- -. -.-.--");

		// plaintext exceptions
		assertThrows(IllegalArgumentException.class, () -> {
			mc.encode("aöc"); // plaintext contains unknown char
		});
	}

	@Test
	void decodeTest() { // TODO

	}

}
