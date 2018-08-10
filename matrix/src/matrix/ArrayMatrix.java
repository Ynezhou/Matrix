package matrix;

/**
 * An array matrix class as a subclass of AbstractMatrix
 * Copyright (c) 2018
 * Dept. of Computer Science, UCL
 * @author Yusi Zhou
 * @version 1.0
 */
public class ArrayMatrix extends AbstractMatrix {
	/** A 2D array of doubles to store the values held in the matrix */
	private double[][] elements;
	
	/**
	 * Initialise a new matrix with all the elements set to 0.0
	 * @param
	 * @throws
	 */
	public ArrayMatrix(final int rows, final int columns) throws MatrixException {
		if(rows>0 && columns>0){
			this.elements = new double[rows][columns];
		}
		else{
			throw new MatrixException(rows, columns);
		}
	}
	
	public ArrayMatrix(double[][] content) throws MatrixException {
		// Initialise a new matrix storing the data provided by the
		// double[][] parameter. Note the data should be copied.
		if(content.length>0){
			this.elements = new double[content.length][];
		}
		else{
			throw new MatrixException("The matrix you entered is invalid.");
		}
		for(int i=0;i<content.length;i++){
			this.elements[i] = content[i].clone();
		}
	}
	
	public int getNumberOfRows() {
		// Number of rows in matrix 
		return elements.length;
	}
	
	public int getNumberOfColumns() {
		// Number of columns in matrix 
		return elements[0].length;
	}
	
	public double getElement(final int row, final int column) throws MatrixException{
		// Return the element at the specified position or throw an exception
		if(0<=row&&row<elements.length && 0<=column&&column<elements[0].length){
			return elements[row][column];
		}
		else{
			throw new MatrixException(row, column);
		}
	}
	public void setElement(final int row, final int column, final double value) 
			throws MatrixException{
		// Set the element at the specified position or throw an exception
		if(0<=row&&row<elements.length && 0<=column&&column<elements[0].length){
			elements[row][column] = value;
		}
		else{
			throw new MatrixException(row, column);
		}
	}
}
