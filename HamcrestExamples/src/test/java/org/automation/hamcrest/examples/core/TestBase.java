package org.automation.hamcrest.examples.core;

import org.automation.hamcrest.examples.Calculator;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.assertEquals;

public abstract class TestBase {
    protected Calculator calculator;
    @BeforeTest
    public void initTest(){
        calculator = new Calculator();
    }


}
