/*Assessment: Lab 3
 *Student Name: Hamza El Sousi
 *Student Number:040982818
 *Lab Professor Name: Fedor Ilitchev
 *Lab Section Number: CST_8132_303
 *Due Date: June 11th, 2023
 */

import java.util.Scanner;

class Store {
	private Employee[] employees;

	public Store(int size) {
		employees = new Employee[size];
	}

	// outputs request for user to input employee details
	public void readEmployeeDetails(Scanner scanner) {
		for (int i = 0; i < employees.length; i++) {
			System.out.printf("Enter details for Employee %d:\n", i + 1);
			employees[i] = new Employee();
			employees[i].readEmployee(scanner);
		}
	}

	// printEmployeeDetails method to print table title "Employee Details"
	public void printEmployeeDetails() {
		System.out.println("Employee Details:");
		// Method that adds a line to separate output results
		printLine();
		System.out.printf("%-10s|%-10s|%-15s|%-15s|%-10s|%-10s|%-10s\n", "Emp #", "First Name", "Last Name", "Email",
				"Phone", "Hours", "Salary");
		printLine();

		for (Employee employee : employees) {
			System.out.printf("%-10d|%-10s|%-15s|%-15s|%-10d|%-10.2f|%-10.2f|\n", employee.getEmployeeNumber(),
					employee.getEmp().getFirstName(), employee.getEmp().getLastName(), employee.getEmp().getEmail(),
					employee.getEmp().getPhoneNumber(), employee.getNumHours(),
					employee.getNumHours() * employee.getHourlyPay());
		}
	}

	// creating a method to print line '=======' to split output results
	public static void printLine() {
		System.out.println(
				"=========================================================================================================");
	}

	public static void printTitle(String storeName) {
		printLine();
		System.out.printf("Welcome to %s Store\n", storeName);
		printLine();
	}
}
