package utils;

import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyWatcher extends TestWatcher{
	private static String watchedLog = "";
	@Override
	public Statement apply(Statement base, Description des) {
		return super.apply(base, des);
	}
	
	

    @Override
    public void succeeded(Description description) {
      watchedLog += description.getDisplayName() + " " + "success!\n";
    }

    @Override
    public void failed(Throwable e, Description description) {
      watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
    }

    @Override
    public void skipped(AssumptionViolatedException e, Description description) {
      watchedLog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
    }

    @Override
    public void starting(Description description) {
      super.starting(description);
    }

    @Override
    public void finished(Description description) {
      super.finished(description);
    }
}
