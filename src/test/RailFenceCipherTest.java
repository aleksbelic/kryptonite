package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ciphers.RailFenceCipher;

/**
 * VigenereCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class RailFenceCipherTest {

	RailFenceCipher rfc1 = new RailFenceCipher(1);
	RailFenceCipher rfc2 = new RailFenceCipher(2);
	RailFenceCipher rfc3 = new RailFenceCipher(3);

	@Test
	void testEncryption() {
		assertEquals(rfc1.encrypt("WE ARE DISCOVERED FLEE AT ONCE", false), "WEAREDISCOVEREDFLEEATONCE");
		assertEquals(rfc2.encrypt("WE ARE DISCOVERED FLEE AT ONCE", false), "WAEICVRDLETNEERDSOEEFEAOC");
		assertEquals(rfc3.encrypt("WE ARE DISCOVERED FLEE AT ONCE", false), "WRIORFEOEEESVELANADCEDETC");
		assertEquals(rfc1.encrypt("WE ARE DISCOVERED FLEE AT ONCE", true), "WE ARE DISCOVERED FLEE AT ONCE");
		assertEquals(rfc2.encrypt("WE ARE DISCOVERED FLEE AT ONCE", true), "W R ICVRDFE TOCEAEDSOEE LEA NE");
		assertEquals(rfc3.encrypt("WE ARE DISCOVERED FLEE AT ONCE", true), "WA SVEFETNERDCEDL  C EIOR EAOE");
	}
	
	@Test
	void testDecryption() {
		
	}

}
