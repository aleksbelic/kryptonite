package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import ciphers.RailFenceCipher;

/**
 * VigenereCipherTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class RailFenceCipherTest {

	RailFenceCipher rfc0 = new RailFenceCipher();
	RailFenceCipher rfc1 = new RailFenceCipher(1);
	RailFenceCipher rfc2 = new RailFenceCipher(2);
	RailFenceCipher rfc3 = new RailFenceCipher(3);

	@Test
	void testEncryption() {
		assertEquals(rfc0.encrypt("WE ARE DISCOVERED FLEE AT ONCE", false), "WAEICVRDLETNEERDSOEEFEAOC");
		assertEquals(rfc1.encrypt("WE ARE DISCOVERED FLEE AT ONCE", false), "WEAREDISCOVEREDFLEEATONCE");
		assertEquals(rfc2.encrypt("WE ARE DISCOVERED FLEE AT ONCE", false), "WAEICVRDLETNEERDSOEEFEAOC");
		assertEquals(rfc3.encrypt("WE ARE DISCOVERED FLEE AT ONCE", false), "WRIORFEOEEESVELANADCEDETC");
		
		assertEquals(rfc0.encrypt("WE ARE DISCOVERED FLEE AT ONCE", true), "W R ICVRDFE TOCEAEDSOEE LEA NE");
		assertEquals(rfc1.encrypt("WE ARE DISCOVERED FLEE AT ONCE", true), "WE ARE DISCOVERED FLEE AT ONCE");
		assertEquals(rfc2.encrypt("WE ARE DISCOVERED FLEE AT ONCE", true), "W R ICVRDFE TOCEAEDSOEE LEA NE");
		assertEquals(rfc3.encrypt("WE ARE DISCOVERED FLEE AT ONCE", true), "WA SVEFETNERDCEDL  C EIOR EAOE");
	}
	
	@Test
	void testDecryption() {
		assertEquals(rfc0.decrypt("WAEICVRDLETNEERDSOEEFEAOC"), "WEAREDISCOVEREDFLEEATONCE");
		assertEquals(rfc1.decrypt("WEAREDISCOVEREDFLEEATONCE"), "WEAREDISCOVEREDFLEEATONCE");
		assertEquals(rfc2.decrypt("WAEICVRDLETNEERDSOEEFEAOC"), "WEAREDISCOVEREDFLEEATONCE");
		assertEquals(rfc3.decrypt("WRIORFEOEEESVELANADCEDETC"), "WEAREDISCOVEREDFLEEATONCE");

		assertEquals(rfc0.decrypt("W R ICVRDFE TOCEAEDSOEE LEA NE"), "WE ARE DISCOVERED FLEE AT ONCE");
		assertEquals(rfc1.decrypt("WE ARE DISCOVERED FLEE AT ONCE"), "WE ARE DISCOVERED FLEE AT ONCE");
		assertEquals(rfc2.decrypt("W R ICVRDFE TOCEAEDSOEE LEA NE"), "WE ARE DISCOVERED FLEE AT ONCE");
		assertEquals(rfc3.decrypt("WA SVEFETNERDCEDL  C EIOR EAOE"), "WE ARE DISCOVERED FLEE AT ONCE");
	}

}
