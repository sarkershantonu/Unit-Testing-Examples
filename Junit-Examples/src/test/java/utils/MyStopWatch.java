package utils;

import org.junit.AssumptionViolatedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

public class MyStopWatch extends Stopwatch{
	@Override
    protected void succeeded(long nanos, Description description) {
       
    }

    @Override
    protected void failed(long nanos, Throwable e, Description description) {
      
    }

    @Override
    protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
        
    }

    @Override
    protected void finished(long nanos, Description description) {
      
    }
}
