package tests;

import ciphers.M94;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * M-94 cipher test class.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class M94Test {

    private M94 m94 = new M94();
    private String[] ciphertextCandidates = new String[]{
            "TVTUSJZZIQJNVZEHKSGGLTLCO",
            "QYVOLSBLVSAFOCNDLDWFZYSHE",
            "KGWQWQNQTVLLRTTENMHCWAINX",
            "ZZLVEFIEZZTHPXCOVCVKTWQZT",
            "ONAPMKKREUMQFBXKANCAIVNFK",
            "LPDTZVPYFXSGELOFREMUPSJRI",
            "RQKNVMVNHYXCAEWPMQITAFCIA",
            "XXOWXERSGWVUNGFYYBRRVDPDZ",
            "SRMYGTOUYIQJCNQAOOBZNLGAD",
            "PWJXAAGMUCPTJYDQFZSXKIBYN",
            "WSUZFGSGNANBIRRJTPEQHEZJB",
            "NBBSNPYTLKOYLSLNHLKLRBAPU",
            "AAGAQODDPEHPDMJUEGUYGHXXH",
            "BCEEUCUXMLUZHFZBUVPIOKKMY",
            "CDPDKILABBWKBAMTSJDOXNWVF",
            "EEHCDXCIXDDXMOAGZRZVERRKW",
            "IHSBOLFHWFIIKDPIJKQBYJEBJ",
            "GFCIPUMPCJZSGWBMXYAPBQVQL",
            "DIZFIRQJRGYRXPVWDTTEFZDWV",
            "JJIGTNTOAHCDUKHZPFOSSGTUG",
            "FKNJJDWBJOGVZJIRCUJNJMUGR",
            "VTXHBYAWDNKETVYVWIYHMXFLC",
            "ULFLRZHKSMRWSIKLGWLJUPOOQ",
            "YMYKHHXCKTFOWUSXQXFWDUYSM",
            "NBBSNPYTLKOYLSLNHLKLRBAPU"
    };

    @Test
    void encrypt() {
        assertThrows(IllegalArgumentException.class, () -> { // unsupported character
            m94.encrypt(".+_");
        });
        assertThrows(IllegalArgumentException.class, () -> { // plaintext too long (>25)
            m94.encrypt("abcdefghijklmnopqrstuvwxyz");
        });
        assertTrue(Arrays.asList(ciphertextCandidates).contains(m94.encrypt("Hurry before my husband comes")));
    }

}
