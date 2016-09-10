package runner;

import org.junit.internal.runners.InitializationError;
import org.junit.internal.runners.JUnit4ClassRunner;

/**
 * Created by shantonu on 9/10/16.
 * a custom runner example that does not validate test methods. I use this when I am returning any value forma a test where
 * default behavior of a test is to not return anything
 */
public class MyRunner extends JUnit4ClassRunner {
    public MyRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    protected void validate() throws InitializationError {
        // ignore
    }
}
