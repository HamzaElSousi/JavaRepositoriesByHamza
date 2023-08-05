//Student Name: Hamza El Sousi
//Lab Professor: Teddy Yap
//Due date: February 17,2023
//Modified: February 16,2023
//Description: This is a program for lab exercise 3 


public class lab3Program {
	
	public static void main(String[] args) {
	    double TotalSurfaceArea;
	    HardBread hardbread1 = new HardBread();
	    HardBread hardbread2 = new HardBread(6.4, 18.7, 4.7, true);
	    String report;
	   
	    TotalSurfaceArea = hardbread1.calculateTotalSurfaceArea();
	    report = hardbread1.toString();
	    System.out.println("Hard Bread 1:");
	    System.out.println("Total Surface Area: " + String.format("%.4f", TotalSurfaceArea) );
	    //System.out.println("Total Surface Area :" + String.format("%.4f", TotalSurfaceArea)); to print 4 decimals places
	    System.out.println(hardbread1.toString());
	    
	    TotalSurfaceArea = hardbread2.calculateTotalSurfaceArea();
	    report = hardbread2.toString();
	    System.out.println("\nHard Bread 2:");
	    System.out.println("Total Surface Area: " + String.format("%.3f", TotalSurfaceArea) );
	   // System.out.println("Total Surface Area :" + String.format("%.3f",TotalSurfaceArea)) to print 3 decimals places;
	    System.out.println(hardbread2.toString());
	    System.out.println("\nProgram by Hamza El Sousi");
	   
	    
}
}