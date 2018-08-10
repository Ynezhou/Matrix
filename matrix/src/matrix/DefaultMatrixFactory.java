package matrix;

public class DefaultMatrixFactory implements MatrixFactory
{
	public Matrix getInstance(Class matrixClass, int numberOfRows, int numberOfColumns)
			throws MatrixException
	{
		if (matrixClass.equals(ArrayMatrix.class)) 
		{
			return new ArrayMatrix(numberOfRows,numberOfColumns); 
		}
		if (matrixClass.equals(SparseMatrix.class)) 
		{
			return new SparseMatrix(numberOfRows,numberOfColumns); 
		}
		throw new MatrixException
			("getNewInstance: Class is not a recognised matrix class");
	}
	
	public Matrix getInstance(Class matrixClass, double[][] contents)
			throws MatrixException
	{
		if (matrixClass.equals(ArrayMatrix.class)) 
		{
			return new ArrayMatrix(contents); 
		}
		if (matrixClass.equals(SparseMatrix.class)) 
		{
			return new SparseMatrix(contents); 
		}
		throw new MatrixException
		("getNewInstance: Class is not a recognised matrix class");
	}
}
