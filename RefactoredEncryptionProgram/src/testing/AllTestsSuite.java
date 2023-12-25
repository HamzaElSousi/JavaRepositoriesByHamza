/**
 * Student Name: Hamza El Sousi
 * Student Number: 040982818
 * Course: CST8132 Object-Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: James Mwangi PhD.
 * Lab Professor: Fedor Ilitchev
 * 
 * @version 3.0
 */
package testing;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * The AllTestsSuite class is a JUnit test suite that includes test cases from
 * both CaesarCipherTest and VigenereCipherTest classes. It allows running
 * multiple test classes together to perform comprehensive testing of the Caesar
 * cipher and Vigenere cipher implementations.
 * 
 * Note: Test suites are used to organize and run multiple test cases
 * simultaneously, making it easier to execute a group of tests at once.
 * 
 * When running JUnit it appears as 18 test cases but there are actually 24 test
 * cases, 8 are in two bulk test methods.
 * 
 * @Owner Hamza El Sousi
 * @author Hamza
 * @version 3.0
 */
@Suite
@SelectClasses({ CaesarCipherTest.class, VigenereCipherTest.class })
public class AllTestsSuite {

}
