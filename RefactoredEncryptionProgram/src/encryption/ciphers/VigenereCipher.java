/**
 * Student Name: Hamza El Sousi
 * Student Number: 040982818
 * Course: CST8132 Object-Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * 
 * Description: The VigenereCipher class is an implementation of the EncryptionType interface,
 *              providing a blueprint for the Vigenere cipher encryption and decryption.
 *              It encrypts and decrypts text using a Vigenere cipher, where each letter in
 *              the input is shifted according to a keyword (password).
 * 
 * The VigenereCipher class uses a keyword (password) for encryption and decryption. The keyword
 * is repeated to match the length of the input text, ensuring that each character in the input
 * text is shifted based on the corresponding character in the keyword.
 * 
 * Note: The Vigenere cipher handles only alphabetic characters (letters), and non-letter characters
 *       (e.g., spaces, punctuation) are left unchanged.
 * 
 * Reference: The ASCII table used while making this program is listed below.
 *            https://www.rapidtables.com/code/text/ascii-table.html
 * 
 * 
 */
package encryption.ciphers;

import encryption.EncryptionType;

/**
 * @Owner Hamza El Sousi
 * @author Hamza El Sousi
 * @version 3.0 The VigenereCipher class is an EncryptionType class that uses a
 *          Vigenere cipher to encrypt/decrypt strings.
 */
public class VigenereCipher extends EncryptionType {

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
	@Override
	 // Method encrypt in class overrides interface method.
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

	/**
	 * @return null for getEncyptedText
	 */
	public String getEncryptedText() {
		return null;
	}
}
/*
 * REFERENCE : The ASCII table I referred to while making this program is listed
 * below.
 * 
 * https://www.rapidtables.com/code/text/ascii-table.html
 */