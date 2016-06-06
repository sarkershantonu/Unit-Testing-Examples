package unitTests;

import org.core.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestCalculator {

	
	private Calculator myCalculator;	
	@Before
	// @BeforeMethod
	public void setUp() throws Exception {
		myCalculator = new Calculator();
	}

	

	@Test	
	public void test() {
		Assert.assertEquals(25, myCalculator.Add(10, 15));
	}

	

}
