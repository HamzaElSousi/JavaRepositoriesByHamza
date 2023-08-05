/*
 * Student Name: Hamza El Sousi	
 * Lab Professor: David Houtman 
 * Due Date: April 9th
 * Description: Lab Exercise 05 (23W) Sample Solution.
 * 		        Original Concept by Professor Stanley Pieda
 */

import java.util.Scanner;

/*
 * This class provides utility for getting user input from the console using
 * an instance of Scanner set to new Scanner(System.in) and has methods that 
 * prevent program crashes from text inputs when numbers are expected.
 *
 * To call the public static methods, use the class name, followed by the method name
 * i.e.  double myDouble = User.inputDouble("Enter a Double: ");
 */
public class User {
	
	private static Scanner keyboard = new Scanner(System.in);
	
	/*
	 * This is a utility class with only static members, prevent
	 * Instantiation.
	 */
	private User() {}
	
	// Public Methods

	/*
	 * This method prompts the user using the argument sent to message
	 *  and then calls to method inputCharacter() to get the actual input value.
	 */
	public static char inputCharacter(String message) {
		System.out.printf("%s", message);
		char value = inputCharacter(); 
		return value;
	}
	
	/*
	 * This method prompts the user using the argument sent to message
	 *  and then calls to method inputDouble() to get the actual input value.
	 */
	public static double inputDouble(String message) {
		System.out.printf("%s", message);
		double value = inputDouble();
		return value;
	}

	/*
	 * This method checks that an int input is within a range,
	 * it depends on method inputInteger(String).
	 * If min is larger than max when passed, the method will swap the min
	 * and max so that min is always less than max.
	 */
	public static int inputInteger(String prompt, int min, int max) {
		if(min > max) { // swap if needed
			int temp = min;
			min = max;
			max = temp;
		}
		boolean isInputBad = true;
		int value = 0;
		while(isInputBad) {
		    value = inputInteger(prompt);
		    if(value >= min && value <= max) {
		    	isInputBad = false;
		    }
		    else {
		    	System.out.printf(
		    			"Enter integer number between %d and %d (inclusive): ",
		    			min, max);
		    }
		}
		return value;
	}

	/*
	 * This method prompts the user using the argument sent to message, 
	 * then calls to method inputString() which reads in the actual text.
	 */
	public static String inputString(String message) {
		System.out.printf("%s", message);
		String value = inputString();
		return value;
	}	
	
	// Private Methods

	/*
	 * This method is used to get a single character from the console. Note that
	 * if a String is entered e.g. more than one character, only the first character
	 * is retained.
	 */
	private static char inputCharacter() {
		char value = keyboard.next().charAt(0);
		return value;
	}	

	/*
	 * Does not prompt the user, reads in a double value when there is one. If
	 * the user does not provide input that can be converted into a double an
	 * error message is printed requesting a correct input and a loop is used
	 * to trap the user until they get this right. A future version of 
	 * the program might have a sanity check to break the loop after several 
	 * failed attempts and then shut down the program, rather than looping
	 * (in theory) forever.
	 */
	private static double inputDouble() {
		boolean isInputBad = true;
		boolean hasNextDouble;
		double value = 0.0;
		while(isInputBad) {
			hasNextDouble = keyboard.hasNextDouble();
			if(hasNextDouble) {
				value = keyboard.nextDouble();
				isInputBad = false; // break out of loop
			}
			else {
				System.out.print("Invalid input. Enter a number: ");
			}
			keyboard.nextLine(); // clean up input stream
		}
		return value;	
	}
	
	/*
	 * This method prompts the user using the argument sent to message
	 *  and then calls to method inputInteger() to get the actual input value.
	 */
	private static int inputInteger(String message) {
		// This method calls inputInteger(), so no changes are needed here.
		System.out.printf("%s", message);
		int value = inputInteger(); 
		return value;
	}
		
	/*
	 * Does not prompt the user, reads in an int value when there is one. If
	 * the user does not provide input that can be converted into an int an
	 * error message is printed requesting a correct input and a loop is used
	 * to trap the user until they get this right. A future version of 
	 * the program might have a sanity check to break the loop after several 
	 * failed attempts and then shut down the program, rather than looping
	 * (in theory) forever.
	 */
	private static int inputInteger() {
		boolean isInputBad = true;
		boolean hasNextInt;
		int value = 0;
		while(isInputBad) {
			hasNextInt = keyboard.hasNextInt();
			if(hasNextInt) {
				value = keyboard.nextInt();
				isInputBad = false; // break out of loop
			}
			else {
				System.out.print("Invalid input. Enter an integer number: ");
			}
			keyboard.nextLine(); // clean up input stream
		}
		return value;
	}
	
	/*
	 * this method is used to get a line of text from the console, it reads
	 * until it encounters a line terminator character.
	 */
	private static String inputString() {
		String value = keyboard.nextLine();
		return value;
	}
}