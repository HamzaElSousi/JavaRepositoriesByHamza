/*Assessment: Lab 2
 *Student Name:Hamza El Sousi
 *Lab Professor Name: Leanne Seaward
 *Lab Section Number: CST_8116_302
 *Due Date: June 2th, 2023
 */

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        // Create a Scanner object to read user input

        System.out.print("Please enter vehicle identification number: ");
        String textInput = scanner.nextLine(); 
        // Read the user input for vehicle identification number and store it in a String variable

        System.out.print("Please enter engine size (cc): ");
        int numberInput = scanner.nextInt(); 
        // Read the user input for engine size and store it in an int variable

        System.out.print("Please enter invoice price: ");
        double invoiceInput = scanner.nextDouble(); 
        // Read the user input for invoice price and store it in a double variable

        Motorcycle motorcycle = new Motorcycle(); 
        // Create an instance of the Motorcycle class

        
        // Set the values obtained from user input to the corresponding fields of the motorcycle object
        motorcycle.setVIN(textInput);
        motorcycle.setEngineSize(numberInput);
        motorcycle.setInvoicePrice(invoiceInput);

        String report = motorcycle.toString(); // Get the formatted report of the motorcycle object as a String

        System.out.println(report); // Print the motorcycle report to the console
		System.out.println("Program by Hamza El Sousi"); // Print the name of the program's author
	}
}
