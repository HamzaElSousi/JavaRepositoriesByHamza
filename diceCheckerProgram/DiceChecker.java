/*
 * Student Name: Hamza El Sousi	
 * Lab Professor: David Houtman 
 * Due Date: April 9th
 * Description: Lab 05 
 */

/*
 * DiceChecker class is used to prompt the user for dice values between 1 and 
 * the number of sides of the dice. The user is asked if they want to enter 
 * more values and the program continues accepting values until the user 
 * declines to enter more values. After all the data is entered the class 
 * generates a report that shows the number of times each value was entered. 
 * The class also provides a method to reset the data.
 * Options menu should be displayed in the console
 */
public class DiceChecker {
	private final int DICE_SIZE; // Initialization deferred to constructor
	private int[] values = null;
	
	/*
	 * No-argument constructor, sets the size of the dice to 8-sides
	 * as a default value.
	 */
	public DiceChecker() {
		this(8); // default to 8 sided dice
	}
	
	/*
	 * Overloaded constructor accepts the dice face count to make
	 * the program more flexible for dice with different number of sides.
	 * e.g. 4-sided, 6-sided and so on. If the dice size is less than 4
	 * then it will be set to 4 by default.
	 */
	public DiceChecker(int faceCount) {
		if(faceCount < 4) {
			faceCount = 4;
		}
		// (non-static constant can have initialization
		// deferred to a constructor).
		DICE_SIZE = faceCount;
		values = new int[DICE_SIZE];
	}
	
	/*
	 * This method prompts the user to enter integer values between 1, i.e. min,
	 * to the max value which is based on the DICE_SIZE constant value. After each 
	 * value the user is asked if they would like to enter more values (y/n).
	 * Each value is used as an index, offset by -1, in the array and for
	 * each entry the count stored in the associated element is increased by 1.
	 */
	public void enterData() {
		int input = 0;
		int min = 1;
		int max = DICE_SIZE;
		String continueDataEntry = null;
		do {
			input = User.inputInteger("Enter dice value: ", min, max);
			// numbers will be from 1 to DICE_SIZE, so offset by -1 as index
			// and add 1 to the value in the indexed element.
			// i.e. face value 1 is stored at index 0 and so on.
			values[input - 1]++;
			continueDataEntry = User.inputString("Enter another? (y/n): ");
		}while(continueDataEntry.equalsIgnoreCase("y") );
	}
	
	/*
	 * Add programmer comments here.
	 */
	public void printReport() {
		for (int index = 0; index < values.length; index++) {
			String report = "";
			for (int input = 0; input < values[index]; input++) {
				report = report + "+";
			}
			System.out.println((index + 1)+ "" + report);
		}
		// use a for-loop, inside a for-loop.
		// for loop to traverse the array
		//     write out the dice face number, padded to 3 letters wide
		//     for loop to print '*' based on the number in the array element
		//     after inner-for loop output a new-line
	}
	
	/*
	 * This method iterates over the values array and
	 * places zero into each element.
	 */
	public void resetData() {
		for(int index = 0; index < values.length; index++) {
			values[index] = 0; // zero out each element
		}
	}
}
