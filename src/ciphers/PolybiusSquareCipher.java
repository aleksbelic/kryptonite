package ciphers;

/**
 * Polybius square cipher class.<br>
 * Each letter is represented by its coordinates in the grid.<br>
 * Example:
 * <ul>
 * <li>plaintext: BAT</li>
 * <li>ciphertext: 121144</li>
 * </ul>
 * &nbsp;&nbsp;&nbsp;&nbsp;1 2 3 4 5<br>
 * -------------<br>
 * 1| A B C D E<br>
 * 2| F G H I/J K<br>
 * 3| L M N O P<br>
 * 4| Q R S T U<br>
 * 5| V W X Y Z<br>
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class PolybiusSquareCipher {

	/* Because 26 characters do not fit in a 5 × 5 square, two letters must be combined (usually I and J).
	   Polybius had no such problem because the Greek alphabet has 24 letters. */
	private char[][][] substitutionSquare = {
			{
					{'A'}, {'B'}, {'C'}, {'D'}, {'E'}
			},
			{
					{'F'}, {'G'}, {'H'}, {'I', 'J'}, {'K'}
			},
			{
					{'L'}, {'M'}, {'N'}, {'O'}, {'P'}
			},
			{
					{'Q'}, {'R'}, {'S'}, {'T'}, {'U'}
			},
			{
					{'V'}, {'W'}, {'X'}, {'Y'}, {'Z'}
			}
	};

	/**
	 * Encodes plaintext
	 *
	 * @param plaintext string to encode
	 * @return ciphertext
	 */
	public String encode(String plaintext) {

		// trim, remove excess whitespace, to upper cae
		plaintext = plaintext.trim().replaceAll("\\s+", " ").toUpperCase();
		StringBuilder ciphertextStringBuilder = new StringBuilder();

		for (int i = 0; i < plaintext.length(); i++) {
			char currentChar = plaintext.charAt(i);
			if (currentChar == ' ') {
				ciphertextStringBuilder.append(" ");
				continue;
			}
			boolean letterFound = false;
			for (int row = 0; row < this.substitutionSquare.length; row++) {
				if (letterFound) break;
				for (int column = 0; column < this.substitutionSquare[row].length; column++) {
					if (letterFound) break;
					for (int letterIndex = 0; letterIndex < this.substitutionSquare[row][column].length; letterIndex++) {
						if (currentChar == this.substitutionSquare[row][column][letterIndex]) {
							ciphertextStringBuilder.append(Integer.toString(row + 1) + Integer.toString(column + 1));
							letterFound = true;
							break;
						}
					}
				}
			}
			if (!letterFound)
				throw new IllegalArgumentException("ERROR: substitution char not found, please use only English alphabet letters.");

		}

		return ciphertextStringBuilder.toString();
	}

	/**
	 * Decodes ciphertext.
	 *
	 * @param ciphertext string to decode.
	 * @return plaintext
	 */
	public String decode(String ciphertext) {
		return ""; // TODO
	}

	/**
	 * Prints out substitution square.
	 * Note: indexing starts with 1, and NOT with 0.
	 */
	public void printSubstitutionSquare() {
		for (int row = 0; row < this.substitutionSquare.length; row++)
			for (int column = 0; column < this.substitutionSquare[row].length; column++)
				for (int letterIndex = 0; letterIndex < this.substitutionSquare[row][column].length; letterIndex++)
					System.out.println("[" + (row + 1) + "][" + (column + 1) + "]:" + this.substitutionSquare[row][column][letterIndex]);
	}

}
