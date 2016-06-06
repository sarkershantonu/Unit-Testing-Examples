package rules;

import org.core.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeOutExample {
	private Calculator myCalculator;

	@Before
	public void setUp() throws Exception {
		myCalculator = new Calculator();
	}

	@Rule
	public Timeout time = new Timeout(1000);
	
	//@Test(timeout = 1000) // standard using
	public void test() {

		Assert.assertEquals(25, myCalculator.Add(10, 15));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {

		Assert.assertEquals(25, myCalculator.Add(10, 15));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
