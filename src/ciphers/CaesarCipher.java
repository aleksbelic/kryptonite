package ciphers;

/**
 * CeaserCipher class.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class CaesarCipher {

    private String alphabet;

    public CaesarCipher(String alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * Encrypts given string with a given key.
     *
     * @param plaintext string to encrypt
     * @param key       key used for creating shifted alphabet
     * @return ciphertext
     */
    public String encrypt(String plaintext, int key) {
        key %= this.alphabet.length();
        String shiftedAlphabet = this.alphabet.substring(key) + this.alphabet.substring(0, key);
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            int charPositionInAlphabet = this.alphabet.indexOf(Character.toUpperCase(plaintext.charAt(i)));
            if (charPositionInAlphabet != -1)
                if (Character.isUpperCase(plaintext.charAt(i)))
                    ciphertextStringBuilder.append(shiftedAlphabet.charAt(charPositionInAlphabet));
                else
                    ciphertextStringBuilder.append(Character.toLowerCase(shiftedAlphabet.charAt(charPositionInAlphabet)));
            else
                ciphertextStringBuilder.append(plaintext.charAt(i));
        }
        return ciphertextStringBuilder.toString();
    }

    /**
     * Decrypts given string with a given key.
     *
     * @param ciphertext string to decrypt
     * @param key        key for creating shifted alphabet
     * @return plaintext
     */
    public String decrypt(String ciphertext, int key) {
        key %= this.alphabet.length();
        String shiftedAlphabet = this.alphabet.substring(key) + this.alphabet.substring(0, key);
        StringBuilder plaintextStringBuilder = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            int charPositionInShiftedAlphabet = shiftedAlphabet.indexOf(Character.toUpperCase(ciphertext.charAt(i)));
            if (charPositionInShiftedAlphabet != -1)
                if (Character.isUpperCase(ciphertext.charAt(i)))
                    plaintextStringBuilder.append(this.alphabet.charAt(charPositionInShiftedAlphabet));
                else
                    plaintextStringBuilder.append(Character.toLowerCase(this.alphabet.charAt(charPositionInShiftedAlphabet)));
            else
                plaintextStringBuilder.append(ciphertext.charAt(i));
        }
        return plaintextStringBuilder.toString();
    }

    /**
     * Encrypts given string with two given key, 1st for every even and 2nd for every odd char position.
     *
     * @param plaintext string to encrypt
     * @param key1      key for creating shifted alphabet for every even char
     * @param key2      key for creating shifted alphabet for every odd char
     * @return ciphertext
     */
    public String encryptTwoKeys(String plaintext, int key1, int key2) {
        key1 %= this.alphabet.length();
        key2 %= this.alphabet.length();
        String shiftedAlphabet;
        String shiftedAlphabet1 = this.alphabet.substring(key1) + this.alphabet.substring(0, key1);
        String shiftedAlphabet2 = this.alphabet.substring(key2) + this.alphabet.substring(0, key2);
        StringBuilder ciphertextStringBuilder = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            if (i % 2 == 0)
                shiftedAlphabet = shiftedAlphabet1;
            else
                shiftedAlphabet = shiftedAlphabet2;
            int charPositionInAlphabet = this.alphabet.indexOf(Character.toUpperCase(plaintext.charAt(i)));
            if (charPositionInAlphabet != -1)
                if (Character.isUpperCase(plaintext.charAt(i)))
                    ciphertextStringBuilder.append(shiftedAlphabet.charAt(charPositionInAlphabet));
                else
                    ciphertextStringBuilder.append(Character.toLowerCase(shiftedAlphabet.charAt(charPositionInAlphabet)));
            else
                ciphertextStringBuilder.append(plaintext.charAt(i));
        }
        return ciphertextStringBuilder.toString();
    }

    /**
     * Decrypts given string with two given key, 1st for every even and 2nd for
     * every odd char position.
     *
     * @param ciphertext string to decrypt
     * @param key1       key for creating shifted alphabet for every even char
     * @param key2       key for creating shifted alphabet for every odd char
     * @return plaintext
     */
    public String decryptTwoKeys(String ciphertext, int key1, int key2) {
        key1 %= this.alphabet.length();
        key2 %= this.alphabet.length();
        String shiftedAlphabet;
        String shiftedAlphabet1 = this.alphabet.substring(key1) + this.alphabet.substring(0, key1);
        String shiftedAlphabet2 = this.alphabet.substring(key2) + this.alphabet.substring(0, key2);
        StringBuilder plaintextStringBuilder = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            if (i % 2 == 0)
                shiftedAlphabet = shiftedAlphabet1;
            else
                shiftedAlphabet = shiftedAlphabet2;
            int charPositionInShiftedAlphabet = shiftedAlphabet.indexOf(Character.toUpperCase(ciphertext.charAt(i)));
            if (charPositionInShiftedAlphabet != -1)
                if (Character.isUpperCase(ciphertext.charAt(i)))
                    plaintextStringBuilder.append(this.alphabet.charAt(charPositionInShiftedAlphabet));
                else
                    plaintextStringBuilder.append(Character.toLowerCase(this.alphabet.charAt(charPositionInShiftedAlphabet)));
            else
                plaintextStringBuilder.append(ciphertext.charAt(i));
        }
        return plaintextStringBuilder.toString();
    }

    /**
     * Prints out ciphertext for every key in alphabet.
     *
     * @param ciphertext string to decrypt
     */
    public void eyeball(String ciphertext) {
        for (int i = 1; i <= this.alphabet.length(); i++)
            System.out.println(this.decrypt(ciphertext, i));
    }

    /**
     * Prints decrypted string with every two-key combination in the alphabet.
     *
     * @param ciphertext string to decrypt
     */
    public void eyeballTwoKeys(String ciphertext) {
        for (int i = 1; i <= this.alphabet.length(); i++)
            for (int j = 1; j <= this.alphabet.length(); j++)
                System.out.println(this.decryptTwoKeys(ciphertext, i, j));
    }

}
