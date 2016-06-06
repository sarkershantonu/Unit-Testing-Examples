package suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import parameterization.ParametersTests;
import parameterization.TestParameter;

@RunWith(Suite.class)
@SuiteClasses({TestParameter.class, ParametersTests.class})
public class JunitSuit {

}
