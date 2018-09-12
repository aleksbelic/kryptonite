package start;

import java.util.HashMap;
import common.*;

/**
 * Start class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Start {

	public static void main(String[] args) {
		
		String ciphertext = "lrvmnir bpr sumvbwvr jx bpr lmiwv yjeryrkbi jx qmbm wi\r\n" + 
				"bpr xjvni mkd ymibrut jx irhx wi bpr riirkvr jx\r\n" + 
				"ymbinlmtmipw utn qmumbr dj w ipmhh but bj rhnvwdmbr bpr\r\n" + 
				"yjeryrkbi jx bpr qmbm mvvjudwko bj yt wkbrusurbmbwjk\r\n" + 
				"lmird jk xjubt trmui jx ibndt\r\n" + 
				"\r\n" + 
				"	wb wi kjb mk rmit bmiq bj rashmwk rmvp yjeryrkb mkd wbi\r\n" + 
				"iwokwxwvmkvr mkd ijyr ynib urymwk nkrashmwkrd bj ower m\r\n" + 
				"vjyshrbr rashmkmbwjk jkr cjnhd pmer bj lr fnmhwxwrd mkd\r\n" + 
				"wkiswurd bj invp mk rabrkb bpmb pr vjnhd urmvp bpr ibmbr\r\n" + 
				"jx rkhwopbrkrd ywkd vmsmlhr jx urvjokwgwko ijnkdhrii\r\n" + 
				"ijnkd mkd ipmsrhrii ipmsr w dj kjb drry ytirhx bpr xwkmh\r\n" + 
				"mnbpjuwbt lnb yt rasruwrkvr cwbp qmbm pmi hrxb kj djnlb\r\n" + 
				"bpmb bpr xjhhjcwko wi bpr sujsru msshwvmbwjk mkd\r\n" + 
				"wkbrusurbmbwjk w jxxru yt bprjuwri wk bpr pjsr bpmb bpr\r\n" + 
				"riirkvr jx jqwkmcmk qmumbr cwhh urymwk wkbmvb";
		
		HashMap<Character, Double> hm = Stats.charFrequency(ciphertext, false);
		Helper.printMapAsTable(hm, "aaa");
		
		HashMap<Character, Character> substitutionMap = new HashMap<Character, Character>();
		substitutionMap.put('w', 'a');
		//substitutionMap.put('t', 'f');
		substitutionMap.put('r', 'e');
		//substitutionMap.put('b', 't');
		//substitutionMap.put('p', 'h');
		substitutionMap.put('i', 's');
		substitutionMap.put('y', 'n');
		substitutionMap.put('d', 'b');
		substitutionMap.put('h', 'l');
		substitutionMap.put('x', 'f');
		System.out.println(Helper.substituteCharsInStringUsingMap(ciphertext, substitutionMap, false));
		
	}

}
