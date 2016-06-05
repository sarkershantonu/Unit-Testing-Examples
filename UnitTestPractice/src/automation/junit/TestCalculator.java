package automation.junit;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.core.Calculator;
import org.junit.rules.*;


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
