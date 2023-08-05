/*Assessment: Lab 3
 *Student Name: Hamza El Sousi
 *Student Number:040982818
 *Lab Professor Name: Fedor Ilitchev
 *Lab Section Number: CST_8132_303
 *Due Date: June 11th, 2023
 */

import java.util.Scanner;

public class Lab3Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// outputs request for user to input store name
		System.out.print("Enter the name of the store: ");
		String storeName = scanner.nextLine();
		// outputs request for user to input employee count
		System.out.print("Enter the number of employees: ");
		int numEmployees = scanner.nextInt();
		scanner.nextLine(); // Consume newline character
		// instance of new store with employee count args
		Store store = new Store(numEmployees);
		store.readEmployeeDetails(scanner);
		// prints store name and empoyee details
		Store.printTitle(storeName);
		store.printEmployeeDetails();

	}
}
