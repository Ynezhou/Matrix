package matrix;

public abstract class AbstractMatrix implements Matrix 
{
	private static MatrixFactory factory = new DefaultMatrixFactory();
	
	private Matrix getNewMatrixInstance(Matrix kind, int numberOfRows, int numberOfColumns)
			throws MatrixException
	{
		return factory.getInstance(kind.getClass(), numberOfRows, numberOfColumns);
	}
	/**
	* Set the factory to be used for matrix creation. Note this is a static
	* method so <em>all</em> matrix objects created from now on
	* will be created by the new factory.
	* @param aFactory The factory to use.
	*/
	public static void setFactory(MatrixFactory aFactory)
	{
	    factory = aFactory;
	}
	
	public final boolean isSameSize(final Matrix m)
	{
		return (getNumberOfRows() == m.getNumberOfRows())
				&& (getNumberOfColumns() == m.getNumberOfColumns());
	}
	
	public final Matrix add(final Matrix m) throws MatrixException 
	{
		if (!isSameSize(m))
		{
			throw new MatrixException("Trying to add matrices of different sizes");
		}
		final Matrix result =
				getNewMatrixInstance(this, getNumberOfRows(), getNumberOfColumns());
		for (int row = 0; row < getNumberOfRows(); row++) 
		{
			for (int column = 0; column < getNumberOfColumns(); column++)
			{
				final double value =getElement(row, column) + m.getElement(row, column);
				result.setElement(row, column, value); 
			}
		}
		return result;
	}
	
	public final Matrix subtract(final Matrix m) throws MatrixException 
	{
		if (!isSameSize(m))
		{
			throw new MatrixException("Trying to subtract matrices of different sizes");
		}
		final Matrix result =
				getNewMatrixInstance(this, getNumberOfRows(), getNumberOfColumns());
		for (int row = 0; row < getNumberOfRows(); row++) 
		{
			for (int column = 0; column < getNumberOfColumns(); column++)
			{
				final double value =getElement(row, column) - m.getElement(row, column);
				result.setElement(row, column, value); 
			}
		}
		return result;
	}
	
	public final Matrix multiply(final Matrix m) throws MatrixException
	{
		if (getNumberOfColumns()!=m.getNumberOfRows())
		{
			throw new MatrixException("The number of columns of the first matrix should be same as "
					+ "the number of rows of the second matrix.");
		}
		final Matrix result =
				getNewMatrixInstance(this, getNumberOfRows(), m.getNumberOfColumns());
		for (int row = 0; row < getNumberOfRows(); row++) 
		{
			for (int column = 0; column < m.getNumberOfColumns(); column++)
			{
				double value = 0;
				for(int same = 0; same < getNumberOfColumns(); same++){
					value = value + getElement(row, same) * m.getElement(same, column);
				}
				result.setElement(row, column, value); 
			}
		}
		return result;
	}
}
