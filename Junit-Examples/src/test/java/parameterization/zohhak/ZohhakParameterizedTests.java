package parameterization.zohhak;

import org.core.Calculator;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;

/***
 * A set of data considered in " Separated by comma " and each set also separeted by comma
 * @author shantonu
 *
 */
@RunWith(ZohhakRunner.class)
public class ZohhakParameterizedTests {
	private Calculator myCalculator;
	@Before
	public void setUp() throws Exception {
		myCalculator = new Calculator();
	}
	@TestWith(value={ " 3, 2, 1"," 5, 2, 3", " 9, 8, 1 "," 200, 50, 150 ", "null, null, null" }, separator = ",")
	public void testAddWithParameters(Integer expected, Integer first, Integer second) {
		myCalculator = new Calculator();
		System.out.println(first + " & " + second+" Expected = "+expected);
		 
		if(first==null || second==null || expected==null){
			assertNull(expected);
			assertNull(second);
			assertNull(first);
		}else{
		Assert.assertEquals(expected.intValue(), myCalculator.Add(first.intValue(), second.intValue()));
		}
	}
}
