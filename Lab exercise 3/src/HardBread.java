//Student Name: Hamza El Sousi
//Lab Professor: Teddy Yap
//Due date: February 17,2023
//Modified: February 16,2023
//Description: This is a program for lab exercise 3 


// Declaration
public class HardBread {

	private double length;
	private double height;
	private double width;
	private Boolean OliveBread;
	
	public HardBread() {
		this.length = 21.5;
		this.height = 5.3;
		this.width = 5.5;
		this.OliveBread = false;
		
		// Getter and setter
	}
	public HardBread(double length, double height, double width, Boolean OliveBread) {
		this.length = length;
		this.height = height;
		this.width = width;
		this.OliveBread = OliveBread;
		

	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public Boolean getOliveBread() {
		return OliveBread;
	}
	public void setOliveBread(Boolean oliveBread) {
		OliveBread = oliveBread;
	}
	public double calculateTotalSurfaceArea() {
		double TotalSurfaceArea;
		TotalSurfaceArea = 2 * ((this.length*this.height)+(this.height*this.width)+(this.width*this.length));
		return TotalSurfaceArea;
	}
	//  To string method, to compile all the values in the required  
	public String toString() {
		String format = "Length %.2f , Height  %.2f , Width %.2f";
		String report;
		report = String.format(format,length , height , width );
		return report;
		}
}