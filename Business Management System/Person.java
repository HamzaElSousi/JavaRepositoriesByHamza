/*Assessment: Lab 3
 *Student Name: Hamza El Sousi
 *Student Number:040982818
 *Lab Professor Name: Fedor Ilitchev
 *Lab Section Number: CST_8132_303
 *Due Date: June 11th, 2023
 */

class Person {
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;

	public Person(String firstName, String lastName, String email, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
// The following are getter methods for person details 
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public String getEmail() {
		return email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}
}
