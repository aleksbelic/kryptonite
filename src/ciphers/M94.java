package ciphers;

import common.Constants;
import java.util.Random;

/**
 * M-94 (a.k.a CSP-488) cipher class.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
public class M94 {

    private String[] discs = {
            "ABCEIGDJFVUYMHTQKZOLRXSPWN", // B1
            "ACDEHFIJKTLMOUVYGZNPQXRWSB", // C2
            "ADKOMJUBGEPHSCZINXFYQRTVWL", // D3
            "AEDCBIFGJHLKMRUOQVPTNWYXZS", // E4
            "AFNQUKDOPITJBRHCYSLWEMZVXG", // F5
            "AGPOCIXLURNDYZHWBJSQFKVMET", // G6
            "AHXJEZBNIKPVROGSYDULCFMQTW", // H7
            "AIHPJOBWKCVFZLQERYNSUMGTDX", // I8
            "AJDSKQOIVTZEFHGYUNLPMBXWCR", // J9
            "AKELBDFJGHONMTPRQSVZUXYWIC", // K10
            "ALTMSXVQPNOHUWDIZYCGKRFBEJ", // L11
            "AMNFLHQGCUJTBYPZKXISRDVEWO", // M12
            "ANCJILDHBMKGXUZTSWQYVORPFE", // N13
            "AODWPKJVIUQHZCTXBLEGNYRSMF", // O14
            "APBVHIYKSGUENTCXOWFQDRLJZM", // P15
            "AQJNUBTGIMWZRVLXCSHDEOKFPY", // Q16
            "ARMYOFTHEUSZJXDPCWGQIBKLNV", // R17 "ARMY OF THE US..."
            "ASDMCNEQBOZPLGVJRKYTFUIWXH", // S18
            "ATOJYLFXNGWHVCMIRBSEKUPDZQ", // T19
            "AUTRZXQLYIOVBPESNHJWMDGFCK", // U20
            "AVNKHRGOXEYBFSJMUDQCLZWTIP", // V21
            "AWVSFDLIEBHKNRJQZGMXPUCOTY", // W22
            "AXKWREVDTUFOYHMLSIQNJCPGBZ", // X23
            "AYJPXMVKBQWUGLOSTECHNZFRID", // Y24
            "AZDNBUHYFWJLVGRCQMPSOEXTKI" // Z25
    };

    /**
     * Sets up the discs in a proper position so that one of the lines reads the plaintext.
     *
     * @param plaintext string to encrypt
     * @return randomly chosen ciphertext candidate
     */
    public String encrypt(String plaintext) {
        plaintext = plaintext.replaceAll("\\s+", "");
        plaintext = plaintext.toUpperCase();

        for (int i = 0; i < plaintext.length(); i++)
            if (Constants.ALPHABET_EN.indexOf(plaintext.charAt(i)) == -1)
                throw new IllegalArgumentException("ERROR: plaintext can contain only English alphabet letters.");

        if (plaintext.length() > this.discs.length)
            throw new IllegalArgumentException("ERROR: plaintext should not be longer than " + this.discs.length + " characters.");

        for (int i = 0; i < this.discs.length; i++) {
            int charPositionOnDisc;
            try {
                charPositionOnDisc = this.discs[i].indexOf(plaintext.charAt(i));
            } catch (StringIndexOutOfBoundsException e) {
                Random rand = new Random();
                charPositionOnDisc = rand.nextInt(this.discs[i].length());
            }
            this.discs[i] = this.discs[i].substring(charPositionOnDisc) + this.discs[i].substring(0, charPositionOnDisc);
        }

        StringBuilder ciphertextStringBuilder = new StringBuilder();
        Random rand = new Random();
        int randomCiphertextIndex = rand.nextInt(Constants.ALPHABET_EN.length()) + 1; // [1 - 26]
        for (String disc : this.discs)
            ciphertextStringBuilder.append(disc.charAt(randomCiphertextIndex));

        return ciphertextStringBuilder.toString();
    }

    /**
     * Sets up the discs in a proper position so that one of the lines reads the ciphertext.
     *
     * @param ciphertext string to decrypt
     * @return all plaintext candidates
     */
    public String[] decrypt(String ciphertext) {
        ciphertext = ciphertext.toUpperCase();

        for (int i = 0; i < ciphertext.length(); i++)
            if (Constants.ALPHABET_EN.indexOf(ciphertext.charAt(i)) == -1)
                throw new IllegalArgumentException("ERROR: ciphertext can contain only English alphabet letters.");

        if (ciphertext.length() > this.discs.length)
            throw new IllegalArgumentException("ERROR: ciphertext should not be longer than " + this.discs.length + " characters.");

        // repositioning the discs
        for (int i = 0; i < this.discs.length; i++) {
            int charPositionOnDisc;
            try {
                charPositionOnDisc = this.discs[i].indexOf(ciphertext.charAt(i));
            } catch (StringIndexOutOfBoundsException e) {
                Random rand = new Random();
                charPositionOnDisc = rand.nextInt(this.discs[i].length());
            }
            this.discs[i] = this.discs[i].substring(charPositionOnDisc) + this.discs[i].substring(0, charPositionOnDisc);
        }

        String[] plaintextCandidates = new String[26];
        for (int i = 0; i < Constants.ALPHABET_EN.length(); i++) {
            StringBuilder plaintextCandidateStringBuilder = new StringBuilder();
            for (String disc : this.discs) {
                plaintextCandidateStringBuilder.append(disc.charAt(i));
            }
            plaintextCandidates[i] = plaintextCandidateStringBuilder.toString();
        }
        return plaintextCandidates;
    }

    /**
     * Sets up the discs in a proper position so that one of the lines reads the ciphertext and prints out all possible plaintext candidates.
     *
     * @param ciphertext string to decrypt
     */
    public void eyeball(String ciphertext) {
        String[] plaintextCandidates = this.decrypt(ciphertext);
        for (String plaintextCandidate : plaintextCandidates)
            System.out.println(plaintextCandidate);
    }

}
