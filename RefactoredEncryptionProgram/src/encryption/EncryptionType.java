/**
 * Student Name: Hamza El Sousi
 * Student Number: 040982818
 * Course: CST8132 Object-Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Lab Professor: Fedor Ilitchev
 * 
 * Description: This abstract class serves as the base class for different encryption algorithms.
 *              It defines common behaviors for encrypting and decrypting text based on the
 *              specified algorithm. The class also provides a method for shifting characters
 *              by a given offset.
 * 
 * The class contains constants representing the 'space' character and the last alphabet 'z' 
 * in the ASCII table, as well as the number of valid values within this range.
 * 
 * @version 3.0
 */
package encryption;

/**
 * @author Hamza El Sousi
 * @version 3.0
 * 
 */
public abstract class EncryptionType {
	// Constants representing 'space' and last alphabet on ASCII
	/**
	 * Constant representing 'space' on ASCII
	 */
	protected static final int START_CHAR = 32;
	/**
	 * Constant representing last alphabet on ASCII 'z'
	 */
	protected static final int END_CHAR = 122;
	/**
	 * The number of valid values
	 */
	protected static final int RANGE = END_CHAR - START_CHAR + 1;
	
	
	/**
	 * Encrypts the given input string.
	 * 
	 * @param input The string to be encrypted.
	 * @return The encrypted version of the input string depending on the prompt by user.
	 */
	public abstract String encrypt(String input);
	
	/**
	 * Encrypts the given input string.
	 * 
	 * @param input The string to be decrypted.
	 * @return The encrypted version of the input string depending on the prompt by user.
	 */
	public abstract String decrypt(String input);

	/**
	 * @param ch represents a character 
	 * @param shift represents integer value of the the offset 
	 * @return returns a character that is the result of shifting the character by the offset.
	 */	
	protected char shiftChar(char ch, int shift) {
        int charValue = ch + shift;
        charValue = ((charValue - START_CHAR) % RANGE + RANGE) % RANGE + START_CHAR;
        return (char) charValue;
		
	}
}
