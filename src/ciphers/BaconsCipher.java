package ciphers;

import java.util.HashMap;

/**
 * Bacon's Cipher class, both versions.
 * 
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class BaconsCipher {

	// substitution map, has different values for verion 1 and 2
	private HashMap<Character, String> alphabetMap = new HashMap<>();

	public BaconsCipher(String version) {
		alphabetMap.put('a', "aaaaa");
		alphabetMap.put('b', "aaaab");
		alphabetMap.put('c', "aaaba");
		alphabetMap.put('d', "aaabb");
		alphabetMap.put('e', "aabaa");
		alphabetMap.put('f', "aabab");
		alphabetMap.put('g', "aabba");
		alphabetMap.put('h', "aabbb");
		alphabetMap.put('i', "abaaa");
		switch (version) {
            case "1":
                alphabetMap.put('j', "abaaa");
                alphabetMap.put('k', "abaab");
                alphabetMap.put('l', "ababa");
                alphabetMap.put('m', "ababb");
                alphabetMap.put('n', "abbaa");
                alphabetMap.put('o', "abbab");
                alphabetMap.put('p', "abbba");
                alphabetMap.put('q', "abbbb");
                alphabetMap.put('r', "baaaa");
                alphabetMap.put('s', "baaab");
                alphabetMap.put('t', "baaba");
                alphabetMap.put('u', "baabb");
                alphabetMap.put('v', "baabb");
                alphabetMap.put('w', "babaa");
                alphabetMap.put('x', "babab");
                alphabetMap.put('y', "babba");
                alphabetMap.put('z', "babbb");
                break;
            case "2":
                alphabetMap.put('j', "abaab");
                alphabetMap.put('k', "ababa");
                alphabetMap.put('l', "ababb");
                alphabetMap.put('m', "abbaa");
                alphabetMap.put('n', "abbab");
                alphabetMap.put('o', "abbba");
                alphabetMap.put('p', "abbbb");
                alphabetMap.put('q', "baaaa");
                alphabetMap.put('r', "baaab");
                alphabetMap.put('s', "baaba");
                alphabetMap.put('t', "baabb");
                alphabetMap.put('u', "babaa");
                alphabetMap.put('v', "babab");
                alphabetMap.put('w', "babba");
                alphabetMap.put('x', "babbb");
                alphabetMap.put('y', "bbaaa");
                alphabetMap.put('z', "bbaab");
                break;
		    default:
			    throw new IllegalArgumentException("ERROR: false cipher version given. Try passing \"1\" or \"2\".");
		}
	}

	/**
	 * Encrypts given string.
	 * 
	 * @param plaintext      string to encrypt
	 * @param misleadingText visible text in which we are going to hide our real
	 *                       message. It should be 5 times longer than the original
	 *                       message.
	 * @return encrypted string
	 */
	public String encrypt(String plaintext, String misleadingText) {

		// checking misleading text value
		if (misleadingText.length() == 0) {
			throw new IllegalArgumentException("ERROR: misleading text cannot be an empty string.");
		} else {
			int letterCounter = 0;
			for (char ch : misleadingText.toCharArray()) {
				if (Character.isLetter(ch)) {
					letterCounter++;
				}
			}
			if (letterCounter == 0) {
				throw new IllegalArgumentException("ERROR: misleading text needs at least one letter.");
			}
		}

		// original Bacon's cipher uses bold & regular letters, we'll be using upper case & lower case letters respectively
		plaintext = plaintext.toLowerCase();
		misleadingText = misleadingText.toLowerCase();

		String substituteString = this.encryptToAB(plaintext);
		StringBuilder encryptedStringBuilder = new StringBuilder();

		for (int i = 0, j = 0; i < substituteString.length(); i++, j++) {
			if (!Character.isLetter(misleadingText.charAt(j % misleadingText.length()))) {
				while (!Character.isLetter(misleadingText.charAt(j % misleadingText.length()))) {
					encryptedStringBuilder.append(misleadingText.charAt(j % misleadingText.length()));
					j++;
				}
			}
			if (substituteString.charAt(i) == 'a') {
				encryptedStringBuilder.append(misleadingText.charAt(j % misleadingText.length()));
			} else if (substituteString.charAt(i) == 'b') {
				encryptedStringBuilder.append(Character.toUpperCase(misleadingText.charAt(j % misleadingText.length())));
			}
		}

		return encryptedStringBuilder.toString();
	}

	/**
	 * Encrypts plaintext with corresponding As and Bs.
	 * 
	 * @param plaintext string to encrypt
	 * @return plaintext encrypted with corresponding As and Bs
	 */
	public String encryptToAB(String plaintext) {
		plaintext = plaintext.toLowerCase();
		String substituteForChar;
		StringBuilder plaintextToABStringBuilder = new StringBuilder();

		for (int i = 0; i < plaintext.length(); i++) {
			substituteForChar = alphabetMap.get(plaintext.charAt(i));
			if (substituteForChar != null) {
				plaintextToABStringBuilder.append(substituteForChar);
			}
		}
		return plaintextToABStringBuilder.toString();
	}

	/**
	 * Decrypts message encrypted with As and Bs.
	 * 
	 * @param messageEncryptedToAB string to decrypt
	 * @return decrypted message
	 */
	public String decryptAB(String messageEncryptedToAB) {

		// validating encrypted AB message
		if (messageEncryptedToAB.length() % 5 != 0) {
			throw new IllegalArgumentException("ERROR: encrypted message is corrupted, length not divisible by 5.");
		}

		String substringAB;
		StringBuilder decryptedMessageStringBuilder = new StringBuilder();

		for (int i = 0; i < messageEncryptedToAB.length(); i += 5) {
			substringAB = messageEncryptedToAB.substring(i, i + 5);
			for (Object alphabetMapKey : alphabetMap.keySet()) {
				if (alphabetMap.get(alphabetMapKey).equals(substringAB)) {
					decryptedMessageStringBuilder.append(alphabetMapKey);
					break;
				}
			}
		}
		return decryptedMessageStringBuilder.toString();
	}

	/**
	 * Decrypts given string.
	 * 
	 * @param encryptedMessage string to decrypt
	 * @return encrypted string
	 */
	public String decrypt(String encryptedMessage) {
		StringBuilder messageEncryptedToABStringBuilder = new StringBuilder();
		for (int i = 0; i < encryptedMessage.length(); i++) {
			if (Character.isLetter(encryptedMessage.charAt(i))) {
				messageEncryptedToABStringBuilder.append((Character.isLowerCase(encryptedMessage.charAt(i))) ? 'a' : 'b');
			}
		}
		return decryptAB(messageEncryptedToABStringBuilder.toString());
	}

}
