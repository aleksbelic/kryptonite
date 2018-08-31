package tests;

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
		assertEquals(Stats.charCount("lollapalooza", false).toString(), "{p=1, a=3, z=1, l=4, o=3}");
		assertEquals(Stats.charCount("lollapalooza", true).toString(), "{p=1, a=3, z=1, l=4, o=3}");
		
		assertEquals(Stats.charCount("lollapalooza is cool", false).toString(), "{p=1, a=3, c=1, s=1, i=1, z=1, l=5, o=5}");
		assertEquals(Stats.charCount("lollapalooza is cool", true).toString(), "{ =2, p=1, a=3, c=1, s=1, i=1, z=1, l=5, o=5}");
		
		assertEquals(Stats.charFrequency("lollapalooza", false).toString(), "{p=8.333333333333334, a=25.0, z=8.333333333333334, l=33.333333333333336, o=25.0}");
		assertEquals(Stats.charFrequency("lollapalooza", true).toString(), "{p=8.333333333333334, a=25.0, z=8.333333333333334, l=33.333333333333336, o=25.0}");
	
		assertEquals(Stats.charFrequency("lollapalooza is cool", false).toString(), "{p=5.555555555555555, a=16.666666666666668, c=5.555555555555555, s=5.555555555555555, i=5.555555555555555, z=5.555555555555555, l=27.77777777777778, o=27.77777777777778}");
		assertEquals(Stats.charFrequency("lollapalooza is cool", true).toString(), "{ =10.0, p=5.0, a=15.0, c=5.0, s=5.0, i=5.0, z=5.0, l=25.0, o=25.0}");
	}

}
