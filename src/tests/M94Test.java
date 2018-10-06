package tests;

import ciphers.M94;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * M-94 cipher test class.
 *
 * @author Aleksandar Belic <aleks.belic@gmail.com>
 */
class M94Test {

    private M94 m94 = new M94();
    private String[] ciphertextCandidates = new String[]{ // ciphertext candidates for string "Hurry before my husband comes"
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
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testEncrypt() {
        assertThrows(IllegalArgumentException.class, () -> { // unsupported character
            m94.encrypt(".+_");
        });
        assertThrows(IllegalArgumentException.class, () -> { // plaintext too long (>25)
            m94.encrypt("abcdefghijklmnopqrstuvwxyz");
        });
        assertTrue(Arrays.asList(ciphertextCandidates).contains(m94.encrypt("Hurry before my husband comes")));
    }

    @Test
    void testDecrypt() {
        assertThrows(IllegalArgumentException.class, () -> { // unsupported character
            m94.decrypt(".+_");
        });
        assertThrows(IllegalArgumentException.class, () -> { // ciphertext too long (>25)
            m94.decrypt("abcdefghijklmnopqrstuvwxyz");
        });
        assertTrue(Arrays.asList(m94.decrypt("TVTUSJZZIQJNVZEHKSGGLTLCO")).contains("HURRYBEFOREMYHUSBANDCOMES"));
    }

    @Test
    void testEyeball() {
        m94.eyeball("TVTUSJZZIQJNVZEHKSGGLTLCO");
        // Win (\r\n)
        assertEquals(outContent.toString(), "TVTUSJZZIQJNVZEHKSGGLTLCO\r\nQYVOLSBLVSAFOCNDLDWFZYSHE\r\nKGWQWQNQTVLLRTTENMHCWAINX\r\nZZLVEFIEZZTHPXCOVCVKTWQZT\r\nONAPMKKREUMQFBXKANCAIVNFK\r\nLPDTZVPYFXSGELOFREMUPSJRI\r\nRQKNVMVNHYXCAEWPMQITAFCIA\r\nXXOWXERSGWVUNGFYYBRRVDPDZ\r\nSRMYGTOUYIQJCNQAOOBZNLGAD\r\nPWJXAAGMUCPTJYDQFZSXKIBYN\r\nWSUZFGSGNANBIRRJTPEQHEZJB\r\nNBBSNPYTLKOYLSLNHLKLRBAPU\r\nAAGAQODDPEHPDMJUEGUYGHXXH\r\nBCEEUCUXMLUZHFZBUVPIOKKMY\r\nCDPDKILABBWKBAMTSJDOXNWVF\r\nEEHCDXCIXDDXMOAGZRZVERRKW\r\nIHSBOLFHWFIIKDPIJKQBYJEBJ\r\nGFCIPUMPCJZSGWBMXYAPBQVQL\r\nDIZFIRQJRGYRXPVWDTTEFZDWV\r\nJJIGTNTOAHCDUKHZPFOSSGTUG\r\nFKNJJDWBJOGVZJIRCUJNJMUGR\r\nVTXHBYAWDNKETVYVWIYHMXFLC\r\nULFLRZHKSMRWSIKLGWLJUPOOQ\r\nYMYKHHXCKTFOWUSXQXFWDUYSM\r\nMOQMCWJVQPBAQQGCIHXMQCHTP\r\nHURRYBEFOREMYHUSBANDCOMES\r\n");
    }

}
