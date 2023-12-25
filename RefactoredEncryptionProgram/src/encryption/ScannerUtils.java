/**
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Lab Professor: Fedor Ilitchev
 * Description: This class has the main method, selection structures, and loops for encryption program
  */
package encryption;

import java.util.Scanner;

/**
 * @author Hamza El Sousi
 * @version 3.0
 * 
 */
public abstract class ScannerUtils {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Displays the menu options and gets the user's selected menu item.
     *
     * @param options The menu options. Varargs allows for arbitrary number arguments/parameters
     * @return The selected menu item. represented as choice
     */
    public static int getMenuItem(String... options) {
        int choice = -1;

        while (choice < 1 || choice > options.length) {
            System.out.println("\nEncryption Menu: \n");
            for (int i = 0; i < options.length; i++) {
                System.out.println("     " + (i + 1) + " - " + options[i]);
            }
            System.out.print("\nSelected action: \n");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (choice < 1 || choice > options.length) {
                    System.out.println("\nPlease select a number in the range\n");
                }
            } else {
                scanner.nextLine(); // Clear invalid input
                System.out.println("\nPlease enter an integer\n");
            }
        }

        return choice;
    }

    /**
     * Gets an integer input from the user after displaying the provided message.
     *
     * @param message The message to be displayed to the user.
     * @return The integer input provided by the user.
     */
    public static int getIntInput(String message) {
        int input;
        while (true) {
            try {
                System.out.print(message);
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer");
            }
        }
        return input;
    }


    /**
     * Gets a string input from the user after displaying the provided message.
     *
     * @param message The message to be displayed to the user.
     * @return The string input provided by the user.
     */
    public static String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    /**
     * Closes the scanner to prevent resource leaks.
     */
    public static void closeScanner() {
        scanner.close();
    }
}
