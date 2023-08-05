
/**
 * Testing Collatz Conjecture - Lab 1 
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */

import java.util.Scanner;

public class lab1test {

	public static void main(String[] args) {
		// Print title
		System.out.println("Collatz conjecture tester\n");

		// Create a Scanner object for user input
		Scanner sc = new Scanner(System.in);

		// Prompt the user for input
		System.out.print("Enter start value: ");
		int value = sc.nextInt();

		// Create a Lab1 object for generating Collatz sequences
		Lab1 lab = new Lab1();

		// Print the input value
		System.out.println("\n" + value);

		// Generate and print the Collatz sequence for the input value
		int count = 1;
		while (value != 1) {
			value = lab.generateAllValues(value);
			System.out.println(value);
			count++;
		}

		// Print the sequence length
		System.out.println("\nSequence " + count + " long");

		// Close the Scanner object
		sc.close();
	}

}
