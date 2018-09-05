package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import common.Helper;

/**
 * StatsTest class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class HelperTest {
	
	@Test
	void testGetReversedString() {
		assertEquals(Helper.getReversedString(""), "");
		assertEquals(Helper.getReversedString("lollapalooza"), "azoolapallol");
		assertEquals(Helper.getReversedString("Life is short!"), "!trohs si efiL");
	}
	
	@Test
	void testSubstituteCharsInStringUsingMap() {
		HashMap<Character, Character> substitutionMap = new HashMap<Character, Character>();
		assertEquals(Helper.substituteCharsInStringUsingMap("", substitutionMap, true), "");
		assertEquals(Helper.substituteCharsInStringUsingMap("", substitutionMap, false), "");
		substitutionMap.put('A', 'X');
		assertEquals(Helper.substituteCharsInStringUsingMap("ABBA", substitutionMap, true), "XBBX");
		assertEquals(Helper.substituteCharsInStringUsingMap("aBBA", substitutionMap, false), "XBBX");
		substitutionMap.put('B', 'Z');
		assertEquals(Helper.substituteCharsInStringUsingMap("ABBA", substitutionMap, true), "XZZX");
		assertEquals(Helper.substituteCharsInStringUsingMap("abBA", substitutionMap, false), "XZZX");
	}
	
	@Test
	void testPrintMapAsTable() {
		// TODO
	}

}
