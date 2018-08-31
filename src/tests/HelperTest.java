package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import common.Helper;

/**
 * StatsTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class HelperTest {
	
	@Test
	void testGetReversedString() {
		assertEquals(Helper.getReversedString(""), "");
		assertEquals(Helper.getReversedString("lollapalooza"), "azoolapallol");
		assertEquals(Helper.getReversedString("Life is short!"), "!trohs si efiL");
	}
	
	@Test
	void testPrintMapAsTable() {
		// TODO
	}

}
