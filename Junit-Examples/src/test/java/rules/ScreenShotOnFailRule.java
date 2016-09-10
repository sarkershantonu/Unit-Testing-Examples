package rules;

import org.automation.utils.ScreenCaptureUtil;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by shantonu on 9/11/16.
 */
public class ScreenShotOnFailRule extends TestWatcher {
    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);
        ScreenCaptureUtil.capture("./Images/ScreenShotOnFail.jpg");
    }
}
