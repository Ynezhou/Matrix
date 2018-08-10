package matrix;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MatrixTest {
	private Matrix aMatrix;
	private Matrix bMatrix;
	private Matrix cMatrix;
	double[][] sameSize = {{2.0,4.0,6.0}, {1.0,3.0,7.0}};
	double[][] diffSize = {{1.0,3.0}, {2.0,4.0}, {7.0,9.0}};
	/* easier to check the result
	double[][] resultAdd = {{4.0,8.0,12.0}, {2.0,6.0,14.0}};
	double[][] resultSubtract = {{0.0,0.0,0.0}, {0.0,0.0,0.0}};
	double[][] resultMultiply = {{52.0,76.0},{56.0,78.0}};
	*/
	
	@Before
	public void setUp(){
		try{
			aMatrix = new ArrayMatrix(sameSize);
			bMatrix = new ArrayMatrix(sameSize);
			cMatrix = new ArrayMatrix(diffSize);
		}
		catch(MatrixException e){
			e.getMessage();
			e.printStackTrace();
		}
	}
	@Test
	public void numberOfRowsShouldBeReturned() {
		assertThat(aMatrix.getNumberOfRows(), is(2));
	}
	
	@Test
	public void numberOfColumnsShouldBeReturned(){
		assertThat(aMatrix.getNumberOfColumns(), is(3));
	}
	
	@Test
	public void elementShouldBeReturned(){
		try{
			assertThat(aMatrix.getElement(0, 0), is(2.0));
		}
		catch (MatrixException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	@Test
	public void exceptionOfGetElementShouldBeReturned(){
		try{
			aMatrix.getElement(-1, 0);
		}
		catch (MatrixException e) {
			assertThat(e.getMessage(), is("Attempt to access invalid element (-1,0)"));
		}
	}
	
	@Test
	public void elementShouldBeSet(){
		try {
			aMatrix.setElement(0, 0, 3.0);
			assertThat(aMatrix.getElement(0, 0), is(3.0));
		} catch (MatrixException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	@Test
	public void exceptionOfSetElementShouldBeReturned(){
		try{
			aMatrix.setElement(0, -1, 3.0);
		}
		catch(MatrixException e){
			assertThat(e.getMessage(), is("Attempt to access invalid element (0,-1)"));
		}
	}
	
	@Test
	public void elementsShouldBeAdded(){
		try {
			assertThat(aMatrix.add(bMatrix).getElement(0, 0), is(4.0));
		} catch (MatrixException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	@Test
	public void incompatibleSizesAreAdded(){
		try {
			aMatrix.add(cMatrix);
		} catch (MatrixException e) {
			assertThat(e.getMessage(), is("Trying to add matrices of different sizes"));
		}
	}
	
	@Test
	public void elementsShouldBeSubtracted(){
		try {
			assertThat(aMatrix.subtract(bMatrix).getElement(0, 0), is(0.0));
		} catch (MatrixException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	@Test
	public void incompatibleSizesAreSubtracted(){
		try {
			aMatrix.subtract(cMatrix);
		} catch (MatrixException e) {
			assertThat(e.getMessage(), is("Trying to subtract matrices of different sizes"));
		}
	}
	
	@Test
	public void elementsShouldBeMultiplied(){
		try {
			assertThat(aMatrix.multiply(cMatrix).getElement(0, 1), is(76.0));
		} catch (MatrixException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	@Test
	public void incompatibleSizesAreMultiplied(){
		try {
			aMatrix.multiply(bMatrix);
		} catch (MatrixException e) {
			assertThat(e.getMessage(), is("The number of columns of the first matrix should be same as "
					+ "the number of rows of the second matrix."));
		}
	}
}
