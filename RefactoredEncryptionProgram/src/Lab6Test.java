
/**
 * Student Name: Hamza El Sousi
 * Student Number: 040982818
 * Course: CST8132 Object-Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Lab Professor: Fedor Ilitchev
 * 
 * Description: This class contains the main method for the Encryption Lab program.
 *              It allows the user to encrypt and decrypt text using different ciphers
 *              (Caesar and Vigenere) and displays the list of encrypted texts.
 * 
 * Reference: The ASCII table used while making this program is listed below.
 *            https://www.rapidtables.com/code/text/ascii-table.html
 * 
 * @version 3.0
 */
import encryption.EncryptionType;
import encryption.ScannerUtils;
import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class for the Encryption Lab program. It allows the user to encrypt
 * and decrypt text using different ciphers (Caesar and Vigenere) and displays
 * the list of encrypted texts.
 * 
 * The user can select various options from the menu, including encryption,
 * decryption, and displaying the list of encrypted texts. The user can exit the
 * program at any time.
 * 
 * The program uses the ScannerUtils class to handle user input and encryption
 * ciphers (CaesarCipher and VigenereCipher) to perform the encryption and
 * decryption operations.
 * 
 * Reference: The ASCII table used while making this program is listed below.
 * https://www.rapidtables.com/code/text/ascii-table.html
 * 
 * @author Hamza
 * @version 3.0
 */
public class Lab6Test {
	@SuppressWarnings("unused")
	private Scanner input;
	private ArrayList<String> encryptedText;

	/**
     * Gets the list of encrypted texts.
     *
     * @return The list of encrypted texts.
     */
	public ArrayList<String> getEncryptedText() {
		return encryptedText;
	}

	/**
     * Sets the list of encrypted texts.
     *
     * @param encryptedText The list of encrypted texts.
     */
	public void setEncryptedText(ArrayList<String> encryptedText) {
		this.encryptedText = encryptedText;
	}

	/**
	 * Constructs a Lab6Test object. Initializes the Scanner for user input and the
	 * ArrayList to store encrypted texts.
	 */
	public Lab6Test() {
		input = new Scanner(System.in);
		setEncryptedText(new ArrayList<>());
	}

	/**
     * The main method of the program. Executes the encryption lab functionality.
     *
     * @param args The command-line arguments.
     */
	public static void main(String[] args) {

		System.out.println("Welcome to the Encryption Lab");

		ArrayList<String> encryptedText = new ArrayList<>();
		new Lab6Test();

		int choice;
		do {
			choice = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

			switch (choice) {
			case 1:

				String textToEncrypt = ScannerUtils.getStringInput("Please enter text to be encrypted: ");
				System.out.println("Encryption Method:");
				int encryptionMethodChoice = ScannerUtils.getMenuItem("Caesar", "Vigenere");
				EncryptionType encryptionMethod = null;

				if (encryptionMethodChoice == 1) {
					int shift = ScannerUtils.getIntInput("Shift value: ");
					encryptionMethod = (EncryptionType) new CaesarCipher(shift);
				} else if (encryptionMethodChoice == 2) {
					String password = ScannerUtils.getStringInput("Password: ");
					encryptionMethod = (EncryptionType) new VigenereCipher(password);
				}

				if (encryptionMethod != null) {
					String encrypted = encryptionMethod.encrypt(textToEncrypt);
					encryptedText.add(encrypted);
					System.out.println("Encrypted value #" + encryptedText.size() + " is: " + encrypted);
				}
				break;
			// will print "Nothing to decrypt" if index of encrypted items is empty
			// Otherwise will prompt the user to select encrypted text by entering an int
			// type
			case 2:
				if (encryptedText.isEmpty()) {
					System.out.println("\n------------");
					System.out.println("Nothing to decrypt");
					System.out.println("------------");
				} else {

					int messageNumber = ScannerUtils.getIntInput("Message number you want to decrypt");
					System.out.println("Encryption Method:");
					if (messageNumber >= 1 && messageNumber <= encryptedText.size()) {
						encryptionMethodChoice = ScannerUtils.getMenuItem("Caesar", "Vigenere");
						EncryptionType decryptionMethod = null;

						if (encryptionMethodChoice == 1) {
							int shift = ScannerUtils.getIntInput("Shift value: ");
							decryptionMethod = new CaesarCipher(shift);
						} else if (encryptionMethodChoice == 2) {
							String password = ScannerUtils.getStringInput("Password: ");
							decryptionMethod = (EncryptionType) new VigenereCipher(password);
						}

						if (decryptionMethod != null) {
							String encryptedMessage = encryptedText.get(messageNumber - 1);
							String decrypted = decryptionMethod.decrypt(encryptedMessage);
							System.out.println("Decrypted value #" + messageNumber + " is: " + decrypted);
						}
					} else {
						System.out.println("\nPlease select a number in the range\n");
					}
				}
				break;
			// Case 3 will check if index is empty and will print "Nothing to display"
			// Otherwise it will count the params in the index and print them as list format
			case 3:
				System.out.println("------------");
				if (encryptedText.isEmpty()) {
					System.out.println("Nothing to display");
				} else {
					for (int i = 0; i < encryptedText.size(); i++) {
						System.out.println("#" + (i + 1) + ": " + encryptedText.get(i));
					}
				}
				System.out.println("------------");
				break;

			// This case exits the program
			case 4:
				System.out.println("Good bye");
				System.out.println("Program by Hamza El Sousi");
				break;
			default:
				System.out.println("\nPlease select a number in the range\n");
				break;
			}

		} while (choice != 4);

	}
}
/*
 * REFERENCE : The ASCII table I referred to while making this program is listed
 * below.
 * 
 * https://www.rapidtables.com/code/text/ascii-table.html
 */
