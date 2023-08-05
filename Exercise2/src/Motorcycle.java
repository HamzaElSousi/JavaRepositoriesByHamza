/*Assessment: Lab 2
 *Student Name:Hamza El Sousi
 *Lab Professor Name: Leanne Seaward
 *Lab Section Number: CST_8116_302
 *Due Date: June 2th, 2023
 */

public class Motorcycle {
    private String VIN; // Private field to store the Vehicle Identification Number (VIN)

    private int engineSize; // Private field to store the engine size (in cc)

    private double invoicePrice; // Private field to store the invoice price (in dollars)

    public String getVIN() { // Getter method to retrieve the VIN
        return VIN;
    }

    public void setVIN(String VIN) { // Setter method to set the VIN
        this.VIN = VIN;
    }

    public int getEngineSize() { 
    	// Getter method to retrieve the engine size
        return engineSize;
    }

    public void setEngineSize(int engineSize) { 
    	// Setter method to set the engine size
        this.engineSize = engineSize;
    }

    public double getInvoicePrice() { 
    	// Getter method to retrieve the invoice price
        return invoicePrice;
    }

    public void setInvoicePrice(double invoicePrice) { 
    	// Setter method to set the invoice price
        this.invoicePrice = invoicePrice;
    }

    public String toString() { 
    	// toString method to represent the object as a formatted string
        int roundedEngineSize = Math.round((engineSize+5)/10) * 10; // Rounding the engine size to the nearest 10's of cc's
        String formattedInvoicePrice = String.format("$%.2f", invoicePrice); // Formatting the invoice price with 2 decimal places
        return ("The VIN is " + VIN + "\nThe Engine size is " + roundedEngineSize + "cc\nThe Invoice price is " + formattedInvoicePrice); // Returning the formatted string representation of the object
    }
}
