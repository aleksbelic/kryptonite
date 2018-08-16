package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import common.Stats;

/**
 * StatsTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class StatsTest {
	
	@Test
	void testEncryption() {
		assertEquals(Stats.charCount("lollapalooza").toString(), "{p=1, a=3, z=1, l=4, o=3}");
		assertEquals(Stats.charFrequency("lollapalooza").toString(), "{p=8.333333333333334, a=25.0, z=8.333333333333334, l=33.333333333333336, o=25.0}");
	}

}
