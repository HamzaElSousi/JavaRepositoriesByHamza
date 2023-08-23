/**
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Description: Class VigenereCipher implements the interface Encryptable and is a blue print for Vigenere encyption. 
  */
package encryption.ciphers;

import encryption.Encryptable;

/**
 * @author Hamza El Sousi
 * @version 2.2 The VigenereCipher class is an Encryptable class that uses a
 *          Vigenere cipher to encrypt/decrypt strings.
 */
public class VigenereCipher implements Encryptable {

	private String key;
	private int keyLength;

	/**
	 * Constructs a VigenereCipher object with the given password.
	 *
	 * @param password The password used to encrypt and decrypt the text.
	 */
	public VigenereCipher(String password) {
		key = password.toLowerCase(); // Convert the key to lowercase for case-insensitive encryption/decryption
		keyLength = key.length();
	}

	@SuppressWarnings("javadoc")
	@Override // Method encrypt in class overrides interface method.
	public String encrypt(String plainText) {
		StringBuilder cipherText = new StringBuilder();
		int textLength = plainText.length();

		for (int i = 0; i < textLength; i++) {
			char plainChar = plainText.charAt(i);
			char keyChar = key.charAt(i % keyLength);

			int plainValue = (int) plainChar - START_CHAR; // Convert the plain character to its corresponding integer
															// value
			int keyValue = (int) keyChar - START_CHAR; // Convert the key character to its corresponding integer value

			int encryptedValue = (plainValue + keyValue) % RANGE;
			char encryptedChar = (char) (encryptedValue + START_CHAR);

			cipherText.append(encryptedChar);
		}

		return cipherText.toString();
	}

	@SuppressWarnings("javadoc")
	@Override
	public String decrypt(String cipherText) {
		StringBuilder plainText = new StringBuilder();
		int textLength = cipherText.length();

		for (int i = 0; i < textLength; i++) {
			char cipherChar = cipherText.charAt(i);
			char keyChar = key.charAt(i % keyLength);

			int cipherValue = (int) cipherChar - START_CHAR; // Convert the cipher character to its corresponding
																// integer value
			int keyValue = (int) keyChar - START_CHAR; // Convert the key character to its corresponding integer value

			int decryptedValue = (cipherValue - keyValue + RANGE) % RANGE; // Perform modular subtraction of cipher and
																			// key values
			char decryptedChar = (char) (decryptedValue + START_CHAR); // Convert the decrypted value back to a
																		// character

			plainText.append(decryptedChar); // Append the decrypted character to the plainText StringBuilder
		}

		return plainText.toString(); // Return the decrypted text as a string
	}
}
/*
 * REFERENCE : The ASCII table I referred to while making this program is listed
 * below.
 * 
 * https://www.rapidtables.com/code/text/ascii-table.html
 */