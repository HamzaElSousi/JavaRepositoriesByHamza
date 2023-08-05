/**
 * Testing Collatz Conjecture - Lab 1 
 * Student Name:Hamza El Sousi
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */

//Lab1.java
public class Lab1 {

public int generateAllValues(int value) {
	int nextValue;
	if (value % 2 == 0) {
	nextValue = value / 2;
 } 
	else {
    nextValue = value * 3 + 1;
 }
	return nextValue;
}

public void computeNextValue(int value) {
	System.out.print(value + " ");
	while (value != 1) {
	value = generateAllValues(value);
	System.out.print(value + " ");
 }
	System.out.println();
}

}