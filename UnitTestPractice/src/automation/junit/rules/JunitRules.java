package automation.junit.rules;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;
import org.junit.rules.Stopwatch;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.rules.Verifier;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.core.Calculator;

import automation.junit.MyStopWatch;
import automation.junit.MyWatcher;

public class JunitRules {
	
	@Rule
	public TestRule watchman = new MyWatcher(); //my watcher extending test watcher , extending test rule
	
	@Rule
	public TestName name = new TestName();
	@Rule
	public Timeout time = new Timeout(30, TimeUnit.SECONDS);
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private static String sequesnce = "";
	@Rule
	public Verifier verify = new Verifier(){
		protected void verify() {
			//do some task that shows varification
			sequesnce+="verify : "+System.currentTimeMillis();
		}
	};
	@Rule
	public ErrorCollector errors = new ErrorCollector();
	@Rule
	public DisableOnDebug disableOnDebig = new DisableOnDebug(errors);
	
	@Rule
	public TemporaryFolder temp = new TemporaryFolder();
	@Rule 
	public Stopwatch watch = new MyStopWatch();
	
	private Calculator myCalculator;	
	@Before
	// @BeforeMethod
	public void setUp() throws Exception {
		myCalculator = new Calculator();
	}

	@Rule// need details examples 
	public RuleChain chain = RuleChain.outerRule(watch).around(name).around(errors);
	

	@Test(timeout=200)	
	public void test() {
		exception.expect(NullPointerException.class);
		exception.expect(IndexOutOfBoundsException.class);
		Assert.assertEquals(25, myCalculator.Add(10, 15));
	}
}
