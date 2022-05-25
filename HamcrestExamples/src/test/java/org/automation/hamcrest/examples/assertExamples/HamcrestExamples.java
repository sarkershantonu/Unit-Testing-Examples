package org.automation.hamcrest.examples.assertExamples;

import org.automation.hamcrest.examples.core.TestBase;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.testng.Assert.assertEquals;

public class HamcrestExamples extends TestBase {

    @Test
    public void testNgSoftAsserts() {
        SoftAssert sa  = new SoftAssert();
        sa.assertEquals(calculator.add(5.0,5.0),10d);
        sa.assertEquals(calculator.add(5.0,6.0),10d);
        sa.assertEquals(calculator.add(7.0,6.0),10d);
        sa.assertEquals(calculator.add(2.0,5.0),7d);
        sa.assertAll();
    }

    @Test
    public void hmAssertsWithRegularAssert() {
        MatcherAssert.assertThat(calculator.add(5.0,5.0),equalTo (10d));
    }
    @Test
    public void hmTestAllOf() {
        SoftAssert sa  = new SoftAssert();
        MatcherAssert.assertThat(calculator.add(5.0,5.0).toString(),
                allOf (containsString("10.0"),
                        containsString("50" )));

        sa.assertAll();
    }
    @Test
    public void hmTestAnyOf(){
        MatcherAssert.assertThat(calculator.add(5.0,5.0).toString(),
                anyOf (containsString("10.0"),
                        containsString("50" )));
    }
}
