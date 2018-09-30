package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ciphers.CaesarCipher;
import common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * CeaserCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class CeaserCipherTest {

	private CaesarCipher cc = new CaesarCipher(Constants.ALPHABET_EN);
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream originalOut = System.out;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	void testEncryption() {
		assertEquals(cc.encrypt("ABBA", 1), "BCCB");
		assertEquals(cc.encrypt("aBBA", 1), "bCCB");
		assertEquals(cc.encrypt("aB B!", 1), "bC C!");
	}

	@Test
	void testDecryption() {
		assertEquals(cc.decrypt("BCCB", 1), "ABBA");
		assertEquals(cc.decrypt("bCCB", 1), "aBBA");
		assertEquals(cc.decrypt("bC C!", 1), "aB B!");
	}

	@Test
	void testEncryptTwoKeys() {
		assertEquals(cc.encryptTwoKeys("Just some silly Message.", 3, 4), "Myvx wrqh vmopb Pivwdkh.");
	}

	@Test
	void testDecryptTwoKeys() {
		assertEquals(cc.decryptTwoKeys("Myvx wrqh vmopb Pivwdkh.", 3, 4), "Just some silly Message.");
	}

	@Test
	void testEyeball() {
		cc.eyeball("Lujyfwa tl.");
		// Win (\r\n)
		assertEquals(outContent.toString(),"Ktixevz sk.\r\nJshwduy rj.\r\nIrgvctx qi.\r\nHqfubsw ph.\r\nGpetarv og.\r\nFodszqu nf.\r\nEncrypt me.\r\nDmbqxos ld.\r\nClapwnr kc.\r\nBkzovmq jb.\r\nAjynulp ia.\r\nZixmtko hz.\r\nYhwlsjn gy.\r\nXgvkrim fx.\r\nWfujqhl ew.\r\nVetipgk dv.\r\nUdshofj cu.\r\nTcrgnei bt.\r\nSbqfmdh as.\r\nRapelcg zr.\r\nQzodkbf yq.\r\nPyncjae xp.\r\nOxmbizd wo.\r\nNwlahyc vn.\r\nMvkzgxb um.\r\nLujyfwa tl.\r\n");
	}

	// TODO eyeballTwoKeys

}
