/*Assessment: Lab 3
 *Student Name: Hamza El Sousi
 *Student Number:040982818
 *Lab Professor Name: Fedor Ilitchev
 *Lab Section Number: CST_8132_303
 *Due Date: June 11th, 2023
 */

import java.util.Scanner;

class Employee {
	private int employeeNumber;
	private Person emp;
	private double numHours;
	private double hourlyPay;

	public Employee(int employeeNumber, Person emp, double numHours, double hourlyPay) {
		this.employeeNumber = employeeNumber;
		this.emp = emp;
		this.numHours = numHours;
		this.hourlyPay = hourlyPay;
	}

	public Employee() {
		// Empty constructor
	}

	public void readEmployee(Scanner scanner) {
		// takes inputs of int type value for emp#
		System.out.print("Enter employee number: ");
		employeeNumber = scanner.nextInt();
		scanner.nextLine(); // Consume newline character
		// takes input value for First name
		System.out.print("Enter first name: ");
		String firstName = scanner.nextLine();
		// takes input value for Last name
		System.out.print("Enter last name: ");
		String lastName = scanner.nextLine();
		// takes input value for email
		System.out.print("Enter email: ");
		String email = scanner.nextLine();
		// takes integer numeric value for phone number. 'Long' type is to accept long
		// numbers
		System.out.print("Enter phone number: ");
		long phoneNumber = scanner.nextLong();
		scanner.nextLine(); // Consume newline character
		// takes input double value for number of hours can be decimal Ex: '1.5' hours.
		System.out.print("Enter number of hours worked: ");
		numHours = scanner.nextDouble();
		// takes input double value for pay/hour, can be decimal input Ex: '55.5' /hour
		System.out.print("Enter hourly pay: ");
		hourlyPay = scanner.nextDouble();
		// creates instance of new person that is an employee, I believe this part is an example of composition relation
		emp = new Person(firstName, lastName, email, phoneNumber);
	}

// method to combine, format, and print employee info 
	public void printEmployee() {
		System.out.printf("Employee Number: %d\n", employeeNumber);
		System.out.printf("Name: %s\n", emp.getName());
		System.out.printf("Email: %s\n", emp.getEmail());
		System.out.printf("Phone Number: %d\n", emp.getPhoneNumber());
		System.out.printf("Salary: %.2f\n", numHours * hourlyPay);
	}
// the following are getter method for Employee details
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public Person getEmp() {
		return emp;
	}

	public double getNumHours() {
		return numHours;
	}

	public double getHourlyPay() {
		return hourlyPay;
	}
}
