package matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * A concrete matrix class as a subclass of AbstractMatrix
 * Copyright (c) 2018
 * Dept. of Computer Science, UCL
 * @author Yusi Zhou
 * @version 1.0
 */
public class SparseMatrix extends AbstractMatrix {
	/** A 2D array of doubles to store the values held in the matrix */
	private Map<Index, Double> elements;
	/**
	 * Initialise a new matrix with all the elements set to 0.0
	 * @param
	 * @throws
	 */
	public SparseMatrix(final int rows, final int columns) throws MatrixException {
		if(rows>0 && columns>0){
			this.elements = new HashMap<Index, Double>();
		}
		else{
			throw new MatrixException(rows, columns);
		}
	}
	
	public ArrayMatrix(double[][] content) throws MatrixException {
		
	}
	
	
	
		
	private static class Index {
		private int x = 0;
		private int y = 0;
		private int hashvalue = 0;
		
		public Index(final int x, final int y) {
		      this.x = x;
		      this.y = y;
		      hashvalue = ((x +"") + (y + "")).hashCode();
		}
		
		// Override equals and hashcode to ensure Index objects 
		// behave correctly when used as keys in a hash table. 
		@Override
		public boolean equals(final Object obj) {
			if (obj instanceof Index) {
				Index index = (Index) obj;
				return ((x == index.x) && (y == index.y)); 
			}
			else {
				return false;
			}
		}
		@Override
		public int hashCode() {
		      return hashvalue;
		    }
		}
}
