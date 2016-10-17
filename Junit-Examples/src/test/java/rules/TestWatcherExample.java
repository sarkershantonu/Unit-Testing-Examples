package rules;

import org.automation.utils.ScreenCaptureUtil;
import org.core.Calculator;
import org.junit.Assert;
import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by shantonu on 9/11/16.
 */
public class TestWatcherExample {

    @Rule
    public TestWatcher screenShot = new ScreenShotOnFailRule();
    @Test
    public void testFail(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(10,calculator.Add(5,6));

    }
}
