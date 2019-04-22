package common;

import java.util.HashMap;

/**
 * Constants class.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class Constants {

	public static final String NUMBERS = "1234567890";
	public static final String ALPHABET_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALPHABET_DE = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß";

	// international Morse code
	public static HashMap<Character, String> MORSE_CODE = new HashMap<Character, String>() {
		{
			// letters
			put('A', ".-"); put('B', "-..."); put('C', "-.-.");
			put('D', "-.."); put('E', "."); put('F', "..-.");
			put('G', "--."); put('H', "....");	put('I', "..");
			put('J', ".---"); put('K', "-.-");	put('L', ".-..");
			put('M', "--"); put('N', "-."); put('O', "---");
			put('P', ".--."); put('Q', "--.-");	put('R', ".-.");
			put('S', "..."); put('T', "-");	put('U', "..-");
			put('V', "...-"); put('W', ".--"); put('X', "-..-");
			put('Y', "-.--");	put('Z', "--..");
			// numbers
			put('1', ".----"); put('2', "..---"); put('3', "...--");
			put('4', "....-"); put('5', "....."); put('6', "-....");
			put('7', "--..."); put('8', "---.."); put('9', "----.");
			put('0', "-----");
			// punctuation
			put('.', ".-.-.-"); put(',', "--..--"); put('?', "..--..");
			put('\'', ".----."); put('!', "-.-.--"); put('/', "-..-.");
			put('(', "-.--."); put(')', "-.--.-"); put('&', ".-...");
			put(':', "---..."); put(';', "-.-.-."); put('=', "-...-");
			put('+', ".-.-."); put('-', "-....-"); put('_', "..--.-");
			put('"', ".-..-."); put('$', "...-..-"); put('@', ".--.-.");
		}
	};


}
