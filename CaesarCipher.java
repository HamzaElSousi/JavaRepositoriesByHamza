/**
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Description: Class CaeserCipher implements the interface Encryptable and is a blue print for Caeser encyption. 
  */

package encryption.ciphers;

import encryption.Encryptable;

/**
 * @author Hamza El Sousi
 * @version 2.2 The CaesarCipher class is an Encryptable class that uses a
 *          Caesar cipher to encrypt/decrypt strings.
 */
public class CaesarCipher implements Encryptable {

	private int key;

	/**
	 * Constructs CaeserCipher with shift to object.
	 * 
	 * @param shift is a int value for how many spaces letters will be shifted to
	 *              encrypt and/or decrypt.
	 */
	public CaesarCipher(int shift) {
		key = shift % RANGE; // Make sure the key is within the valid range
	}

	@SuppressWarnings("javadoc")
	@Override // method encrypt takes the input to encrypt
	public String encrypt(final String input) {
		StringBuilder encrypted = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char originalChar = input.charAt(i);

			if (originalChar == START_CHAR) {
				originalChar = '%';
			}
			if (Character.isLetter(originalChar)) { // Check if the character is a letter
				char encryptedChar = (char) (originalChar + key); // Encrypt the character by adding the key value

				if (Character.isUpperCase(originalChar)) { // Check if the character is uppercase
					if (encryptedChar > 'Z') {
						// If the encrypted character goes above 'Z', wrap around to the beginning of
						// the range
						encryptedChar = (char) ('A' + (encryptedChar - 'Z' - 1));
					} else if (encryptedChar < 'A') {
						// If the encrypted character goes below 'A', wrap around to the end of the
						// range
						encryptedChar = (char) ('Z' - ('A' - encryptedChar - 1));
					}
				} else { // Character is lowercase
					if (encryptedChar > END_CHAR) {
						// If the encrypted character goes above the specified END_CHAR, wrap around to
						// the beginning of the range
						encryptedChar = (char) ('a' + (encryptedChar - END_CHAR - 1));
					} else if (encryptedChar < 'a') {
						// If the encrypted character goes below 'a', wrap around to the end of the
						// range
						encryptedChar = (char) (END_CHAR - ('a' - encryptedChar - 1));
					}
				}

				encrypted.append(encryptedChar); // Append the encrypted character to the result
			} else {
				encrypted.append(originalChar); // If the character is not a letter, append it as it is
			}
		}

		return encrypted.toString(); // Return the encrypted string
	}

	@SuppressWarnings("javadoc")
	@Override // method decrypt takes the input to decrypt
	public String decrypt(final String input) {
		StringBuilder decrypted = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char encryptedChar = input.charAt(i);
			if (encryptedChar == '%') {
				encryptedChar = START_CHAR;
			}
			if (Character.isLetter(encryptedChar)) { // Check if the character is a letter
				char decryptedChar = (char) (encryptedChar - key); // Decrypt the character by subtracting the key value

				if (Character.isUpperCase(encryptedChar)) { // Check if the original character was uppercase
					if (decryptedChar < 'A') {
						// If the decrypted character is outside the range of uppercase letters,
						// wrap around to the end of the range
						decryptedChar = (char) ('Z' - ('A' - decryptedChar - 1));
					} else if (decryptedChar > 'Z') {
						// If the decrypted character is above 'Z', wrap around to the beginning of the
						// range
						decryptedChar = (char) ('A' + (decryptedChar - 'Z' - 1));
					}
				} else {
					if (decryptedChar < 'a') {
						// If the decrypted character is outside the range of lowercase letters,
						// wrap around to the end of the range
						decryptedChar = (char) (END_CHAR - ('a' - decryptedChar - 1));
					} else if (decryptedChar > END_CHAR) {
						// If the decrypted character is above the specified END_CHAR, wrap around to
						// the beginning of the range
						decryptedChar = (char) ('a' + (decryptedChar - END_CHAR - 1));
					}
				}

				decrypted.append(decryptedChar); // Append the decrypted character to the result
			} else {
				decrypted.append(encryptedChar); // If the character is not a letter, append it as it is
			}
		}

		return decrypted.toString(); // Return the decrypted string
	}
}
/*
 * REFERENCE : The ASCII table I referred to while making this program is listed
 * below.
 * 
 * https://www.rapidtables.com/code/text/ascii-table.html
 */