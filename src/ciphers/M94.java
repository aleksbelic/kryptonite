package ciphers;

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

    public M94() {

    }

    /**
     * Sets up the discs in a proper position so that one line reads the plaintext.
     *
     * @param plaintext string to encrypt
     * @return randomly picked ciphertext
     */
    public String encrypt(String plaintext) {
        if (plaintext.length() > this.discs.length)
            throw new IllegalArgumentException("ERROR: plaintext should not be longer than " + this.discs.length + " characters.");
        else if (plaintext.equals("")) {
            // TODO
        }

        // remove whitespace TODO
        plaintext = plaintext.toUpperCase();
        String[] ciphertextCandidates = new String[25]; // all possible ciphertexts
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

        for (String disc : this.discs) {
            System.out.println(disc);
        }

        return "";
    }

}
