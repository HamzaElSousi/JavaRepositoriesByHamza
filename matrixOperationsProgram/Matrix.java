/**
 * Lab 2 Matrix class
 * Student Name:Hamza El Sousi	
 * Student Number:040982818
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  James Mwangi PhD.
 */

// Matrix class for Lab2Test.java
import java.util.Arrays;

public class Matrix {
    private double[][] array; // Matrix data 
    private int rows;	// number of rows 
    private int columns;  // number of columns 

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.array = new double[rows][columns]; //instance of a new empty matrix 
    }

    public Matrix(double[][] array) {
        this.rows = array.length;
        this.columns = array[0].length;
        this.array = array; // use the 2-Dim array as matrix data
    }

    public Matrix add(Matrix other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        Matrix result = new Matrix(rows, columns);// instance of a new matrix to store daata 
        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < columns; j++) {
                result.array[i][j] = array[i][j] + other.array[i][j]; // element-wise addition matrix 
            }
        }

        return result;
    }

    public Matrix sub(Matrix other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        Matrix result = new Matrix(rows, columns);		// instance of a new matrix to store data 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.array[i][j] = array[i][j] - other.array[i][j]; // element-wise subtracting matrix
            }
        }

        return result;
    }

    public Matrix mult(Matrix other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        Matrix result = new Matrix(rows, columns);	// instance of a new matrix to store data 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.array[i][j] = array[i][j] * other.array[i][j]; // element-wise multiplication 
            }
        }

        return result;
    }

    public double sum() {
        double sum = 0.0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += array[i][j]; // sum of the all matrix elements/data 
            }
        }
        return sum;
    }

    public Matrix subMatrix(int startRow, int startColumn, int length, int width) {
        if (startRow < 0 || startRow >= rows || startColumn < 0 || startColumn >= columns) {
            throw new IllegalArgumentException("Invalid start row or column");
        }

        if (startRow + length > rows || startColumn + width > columns) {
            throw new IllegalArgumentException("Submatrix dimensions exceed matrix dimensions");
        }

        Matrix result = new Matrix(length, width); // instance to create storage for submatrix 
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                result.array[i][j] = array[startRow + i][startColumn + j]; // result in submatrix 
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (double[] row : array) {
            result.append(Arrays.toString(row));
            result.append('\n');
        }
        return result.toString();
    }
}