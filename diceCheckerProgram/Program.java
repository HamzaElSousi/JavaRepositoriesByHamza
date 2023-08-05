/*
 * Student Name: Hamza El Sousi	
 * Lab Professor: David Houtman 
 * Due Date: April 9th
 * Description: Lab 05 
 */
public class Program {

	/*
	 * Add programmer comments here.
	 */
		public static void main(String[] args) {
		// Each character corresponds to the first letter of the menu option
		// For example, 'E' corresponds to (E)nter, but you must accept
		// lower case characters as well - 'e', 'd', 'r', and 'q'
		final char ENTER_VALUES = 'E';
		final char DISPLAY_REPORT = 'D';
		final char RESET_VALUES = 'R';
		final char QUIT_PROGRAM = 'Q';
		char option = 'Q';
		DiceChecker diceChecker = new DiceChecker(); 
		do {
			System.out.println("(E)nter Dice Roll Values");
			System.out.println("(D)isplay Report");
			System.out.println("(R)eset Dice Roll Data");
			System.out.println("(Q)uit Program");
			System.out.println("\nSelect option:");
			option = Character.toUpperCase(User.inputCharacter(""));
		
			switch(option) {
			case 'E': ENTER_VALUES:
				diceChecker.enterData();
			break;
			
			case 'D': DISPLAY_REPORT:
				diceChecker.printReport();
			break;
			
			case 'R': RESET_VALUES:
				diceChecker.resetData();
			break;
			
			case 'Q': QUIT_PROGRAM: 
			break;
			
			default: System.out.println("Invalid Menu Option Entered");
			
			}
//			System.out.println("\nSelect option:");
//			option = Character.toUpperCase(User.inputCharacter(""));
			
		}while(option != QUIT_PROGRAM);
		
		
		System.out.println("Program by Hamza El Sousi");
		System.out.println("Thanks for using my Dice Checker software");
		// do while loop
		//     output menu options
		//     get user option, 
		//     use switch, delegate actions to diceChecker as needed
		// output your name at end of program

	}

}