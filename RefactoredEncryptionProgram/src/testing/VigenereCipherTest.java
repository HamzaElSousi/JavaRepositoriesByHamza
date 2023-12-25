/**
 * Student Name: Hamza El Sousi
 * Student Number: 040982818
 * Course: CST8132 Object-Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Lab Professor: Fedor Ilitchev
 * 
 * Description: This class contains test cases for the VigenereCipher class, testing both encryption and decryption functionality.
 * 
 * @version 3.0
 */


package testing;

import static org.junit.Assert.*;
import encryption.ciphers.VigenereCipher;
import org.junit.Test;

/**
 * @author Hamza El Sousi
 * @version 3.0
 *
 */


public class VigenereCipherTest {
     private VigenereCipher cipher = new VigenereCipher("test");

    /**
     * This is a bulk test is to test strings for vigenere encrypt method, it has 4 test cases with password 'test'
     */
    @Test
    public void testEncrypt1_bulkTest_passwordTest() {
        assertEquals("bXsZtVYg]e^Zke^ZkeYpZc", cipher.encrypt("in a land far far away"));
        assertEquals("FCsG:7=tB=sA:7R:", cipher.encrypt("MY NAME IS HAMZA"));
        assertEquals("MRaltSktZemgb[m^t^]lme^hke@ZfdY", cipher.encrypt("This is a unique test for Hamza"));
        assertEquals("MRaltSktZel^l^s_h\\seZL.tZ^s:eQggj_agt-geeO_^", cipher.encrypt("This is a test for lab6 at Algonquin College"));
       
    }
    
    /**
     * This is the second test method for vigenere encryption with alphanumeric password 'Lab6' 
     */
    @Test
    public void testEncryptStringPasswordLab6() {
        VigenereCipher vigenereCipher = new VigenereCipher("Lab6");
        String encryptedText = vigenereCipher.encrypt("in a land far far away");
        assertEquals("ZTbwlRH)UaMwcaMwcaH2R_", encryptedText);
    }
    
    /**
     * This test case is for vigenere encryption with password cheese. 
     */
   
    @Test 
    public void testEncryptPasswordCheese() {
        VigenereCipher vigenereCipher = new VigenereCipher("cheese");
        String encryptedText = vigenereCipher.encrypt("Stay Awesome");
        assertEquals(";aKcs+_R]YeO", encryptedText);
    }
    
    /**
     * This test case is for vigenere encryption with password 'Smile' and is 
     */
    @Test 
    public void testingVigenereEncryptPasswordSmile() {
        VigenereCipher vigenereCipher = new VigenereCipher("Smile");
        String encryptedText = vigenereCipher.encrypt("Stay Awesome");
        assertEquals("KfOje9iSdYeW", encryptedText);
    }
    
    
    /**
     * This is a bulk test is to test strings for vigenere decrypt method, it has 4 test cases with password 'test'
     */
    @Test
    public void testDecrypt_bulkTest() {
        assertEquals("in a land far far away", cipher.decrypt("bXsZtVYg]e^Zke^ZkeYpZc"));
        assertEquals("MY NAME IS HAMZA", cipher.decrypt("FCsG:7=tB=sA:7R:"));
        assertEquals("This is a unique test for Hamza", cipher.decrypt("MRaltSktZemgb[m^t^]lme^hke@ZfdY"));
        assertEquals("This is a test for lab6 at Algonquin College", cipher.decrypt("MRaltSktZel^l^s_h\\seZL.tZ^s:eQggj_agt-geeO_^"));
    }
    
    /**
     * This test case is for vigenere decryption with CAPTIAL CASE password 'DJAVB'. 
     */  
    @Test
    public void testDecryptPasswordDjavb() {
        VigenereCipher vigenereCipher = new VigenereCipher("DJAVB");
        String decryptedText = vigenereCipher.decrypt("-Ya<YVXTv=J]a=\\^aKi");
        assertEquals("Dj Armin Van Buuren", decryptedText);
    }

    /**
     * This test is derived from the example on brightspace's instruction and is to make sure my code functions correctly
     */
    @Test
    public void testDecryptPasswordUknown() {
        VigenereCipher vigenereCipher = new VigenereCipher("unknown");
        String decryptedText = vigenereCipher.decrypt("bXsZtVYg]e^Zke^ZkeYpZc");
        assertEquals("he(g%Zfmjukfordg retgi", decryptedText);
    }
    
    /**
     * This test case is for vigenere decryption with Alphanumeric password 'Lab6'. 
     */  
    @Test
    public void testDecryptAlphanumericPasswordLab6() {
        VigenereCipher vigenereCipher = new VigenereCipher("Lab6");
        String decryptedText = vigenereCipher.decrypt("E+:j:4.Y:6/[C");
        assertEquals("TESTINGCIPHER", decryptedText);
    }
}

