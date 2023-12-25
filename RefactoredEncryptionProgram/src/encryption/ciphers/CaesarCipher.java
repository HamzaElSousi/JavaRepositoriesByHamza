/**
 * Student Name: Hamza El Sousi
 * Student Number: 040982818
 * Course: CST8132 Object-Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * 
 * Description: The CaesarCipher class is an implementation of the EncryptionType interface,
 *              providing a blueprint for the Caesar cipher encryption and decryption.
 *              It shifts characters in the input string by a given key value to encrypt
 *              or decrypt the text.
 * 
 * The CaesarCipher class uses the shift value (key) to determine the amount of shifting
 * to be applied to each character. The class handles both uppercase and lowercase letters,
 * and non-letter characters (e.g., spaces, punctuation) remain unchanged during the process.
 * 
 * The class also contains a method, 'shiftChar', which is used internally to perform the
 * character shifting for both encryption and decryption processes.
 * 
 * Reference: The ASCII table used while making this program is listed below.
 *            https://www.rapidtables.com/code/text/ascii-table.html
 * 
 * @version 3.0
 */
package encryption.ciphers;

import encryption.EncryptionType;

/**
 * The CaesarCipher class is an implementation of the EncryptionType interface,
 * providing a blueprint for the Caesar cipher encryption and decryption.
 * It shifts characters in the input string by a given key value to encrypt
 * or decrypt the text.
 * 
 * Reference: The ASCII table used while making this program is listed below.
 *            https://www.rapidtables.com/code/text/ascii-table.html
 * 
 * @author Hamza
 * @version 3.0
 */
public class CaesarCipher extends EncryptionType {

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

	/**
     * Encrypts the given input string using the Caesar cipher.
     * 
     * @param input The string to be encrypted.
     * @return The encrypted version of the input string.
     */
    @Override
	public String encrypt(final String input) {
		StringBuilder encrypted = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char originalChar = input.charAt(i);

			char encryptedChar;
			if (Character.isLetter(originalChar)) { // Check if the character is a letter
				encryptedChar = (char) (originalChar + key); // Encrypt the character by adding the key value

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
						// If the encrypted character goes above 'z', wrap around to the beginning of
						// the
						// range
						encryptedChar = (char) ('a' + (encryptedChar - END_CHAR - 1));
					} else if (encryptedChar < 'a') {
						// If the encrypted character goes below 'a', wrap around to the end of the
						// range
						encryptedChar = (char) (END_CHAR - ('a' - encryptedChar - 1));
					}
				}
			} else {
				// For non-letter characters (e.g., spaces, punctuation), apply the same shift
				// as the key
				encryptedChar = (char) (originalChar + key);
			}

			encrypted.append(encryptedChar); // Append the encrypted character to the result
		}

		return encrypted.toString(); // Return the encrypted string
	}

	/**
     * Decrypts the given input string using the Caesar cipher.
     * 
     * @param input The string to be decrypted.
     * @return The decrypted version of the input string.
     */
    @Override
	public String decrypt(final String input) {
	    StringBuilder decrypted = new StringBuilder();

	    for (int i = 0; i < input.length(); i++) {
	        char encryptedChar = input.charAt(i);

	        char decryptedChar;
	        if (Character.isLetter(encryptedChar)) { // Check if the character is a letter
	            decryptedChar = (char) (encryptedChar - key); // Decrypt the character by subtracting the key value

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
	                    // If the decrypted character is above 'z', wrap around to the beginning of the
	                    // range
	                    decryptedChar = (char) ('a' + (decryptedChar - END_CHAR - 1));
	                }
	            }
	        } else {
	            // For non-letter characters (e.g., spaces, punctuation), apply the same shift
	            // as the key
	            decryptedChar = (char) (encryptedChar - key);
	        }

	        decrypted.append(decryptedChar); // Append the decrypted character to the result
	    }

	    return decrypted.toString(); // Return the decrypted string
	}
    
    /**
     * @return null
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