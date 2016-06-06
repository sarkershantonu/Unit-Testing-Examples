package parameterization;

import org.core.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


/**
 * Each method in this class will run based on how many data given, no matter tests are using the data or not, the test() method will run based on items in collection. 
 * @author shantonu
 *
 */
@RunWith(Parameterized.class)
public class ParametersTests {
	private int expected;
	private int first;
	private int second;

	public ParametersTests(int expecte, int f, int s) {
		this.expected = expecte;
		this.first = f;
		this.second = s;
	}

	private Calculator myCalculator;

	@Before
	public void setUp() throws Exception {
		myCalculator = new Calculator();
	}
	@Test

	public void test() {
		Assert.assertEquals(25, myCalculator.Add(10, 15));
	}
	
	@Parameterized.Parameters(name = "Test : {index} : add({1}+{2})= Expecting {0}")
	public static Collection addNumbers() {
		return Arrays.asList(new Integer[][] { { 3, 2, 1 }, { 5, 2, 3 }, { 9, 8, 1 }, { 200, 50, 150 } });
	}
	@Test
	public void testAddWithParameters() {
		myCalculator = new Calculator();
		System.out.println("ParametersTests >>> "+first + " & " + second+" Expected = "+expected);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(expected, myCalculator.Add(first, second));
	}

}
