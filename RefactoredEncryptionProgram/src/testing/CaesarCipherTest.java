/**
 * Student Name: Hamza El Sousi
 * Student Number: 040982818
 * Course: CST8132 Object-Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Lab Professor: Fedor Ilitchev
 * 
 * Description: This class contains test cases for the CaesarCipher class, testing both encryption and decryption functionality.
 * 
 * @version 3.0
 */
package testing;

import static org.junit.Assert.*;
import encryption.ciphers.CaesarCipher;
import org.junit.Test;

/**
 * The CaesarCipherTest class contains test cases for the CaesarCipher class,
 * testing both encryption and decryption functionality.
 * 
 * @author Student Name: Hamza El Sousi 
 * 	       Student Number: 040982818
 * 
 * Course: CST8132 Object-Oriented Programming Program: CET-CS-Level 2
 * Professor: James Mwangi PhD. Lab Professor: Fedor Ilitchev
 * 
 * @Owner Hamza El Sousi
 * @author Hamza
 * @version 3.0
 */
public class CaesarCipherTest {

	/**
	 * This tests the an all capital alphanumeric value and wraparround features
	 * combined using shift input '2023'.
	 */
	@Test
	public void caesarEncryptionWraparroundTest2023() {
		CaesarCipher caesarCipher = new CaesarCipher(2023);
		String encryptedText = caesarCipher.encrypt("CST8132OOP23S");
		assertEquals("XNOMFHGJJKGHN", encryptedText);
	}

	/**
	 * This is an spaced chars and wraparround test for Caesar cipher encryption
	 * method using a shift of 294.
	 */
	@Test
	public void caesarEncryptionSpacedCharsWraparroundTest() {
		CaesarCipher caesarCipher = new CaesarCipher(294);
		String encryptedText = caesarCipher.encrypt("S P A C E D C H A R S");
		assertEquals("N5K5V5X5Z5Y5X5C5V5M5N", encryptedText);
	}

	/**
	 * This is an Alphanumeric value test for Caesar cipher using a shift of 10.
	 */
	@Test
	public void caesarEncryptionTest10() {
		CaesarCipher caesarCipher = new CaesarCipher(10);
		String encryptedText = caesarCipher.encrypt("CST8132");
		assertEquals("MCDB;=<", encryptedText);
	}

	/**
	 * This tests the encrypt method for Numbuers via Caesar cipher using a value
	 * shift of 5.
	 */
	@Test
	public void caesarEncryptionNumbersShift5Test() {
		CaesarCipher caesarCipher = new CaesarCipher(5);
		String encryptedText = caesarCipher.encrypt("567890");
		assertEquals(":;<=>5", encryptedText);
	}

	/**
	 * This tests encryption method with all capital case charachters in Caesar
	 * cipher with a shift of 25.
	 */
	@Test
	public void caesarEncryptionTest25() {
		CaesarCipher caesarCipher = new CaesarCipher(25);
		String encryptedText = caesarCipher.encrypt("TESTINGCIPHER");
		assertEquals("SDRSHMFBHOGDQ", encryptedText);
	}

	/**
	 * This tests decryption method with all capital case charachters in Caesar
	 * cipher with a shift of 3.
	 */
	@Test
	public void caesarDecryptionTest3() {
		CaesarCipher caesarCipher = new CaesarCipher(3);
		String decryptedText = caesarCipher.decrypt("KHOOR");
		assertEquals("HELLO", decryptedText);
	}

	/**
	 * This tests decryption method with 'space' in Caesar cipher with a shift of 5.
	 */
	@Test
	public void caesarDecryptionTest5() {
		CaesarCipher caesarCipher = new CaesarCipher(5);
		String decryptedText = caesarCipher.decrypt("mjqqt%btwqi");
		assertEquals("hello world", decryptedText);
	}

	/**
	 * This tests decryption method with lowercase charachters in Caesar cipher with
	 * a shift of 21.
	 */
	@Test
	public void caesarDecryptionTest21() {
		CaesarCipher caesarCipher = new CaesarCipher(21); //
		String decryptedText = caesarCipher.decrypt("orziot5jiz");
		assertEquals("twenty one", decryptedText);
	}

	/**
	 * This tests wraparround feature for decryption method in Caesar cipher with a
	 * shift of 555.
	 */
	@Test
	public void caesarDecryptionTest555() {
		CaesarCipher caesarCipher = new CaesarCipher(555);
		String decryptedText = caesarCipher.decrypt("JupxwzdrwLxuunpn");
		assertEquals("AlgonquinCollege", decryptedText);
	}

	/**
	 * This is an spaced chars and wraparround test for Caesar cipher decryption
	 * method using a shift of 294.
	 */
	@Test
	public void caesarDecryptionSpacedCharsWraparroundTest() {
		CaesarCipher caesarCipher = new CaesarCipher(294);
		String decryptedText = caesarCipher.decrypt("N5K5V5X5Z5Y5X5C5V5M5N");
		assertEquals("S P A C E D C H A R S", decryptedText);
	}
}
