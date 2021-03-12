package org.automation.tests;

import core.Calculator;
import org.testng.annotations.*;

public abstract class BaseTest {

    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("PARENT :BeforeSuite");
    }
    @BeforeGroups
    public void beforeGroup(){
        System.out.println("PARENT :BeforeGroups");
    }

    @BeforeClass
    public  void beforeClass(){
        System.out.println("PARENT :BeforeClass");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("PARENT :BeforeTest");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("PARENT :BeforeMethod");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("PARENT :AfterClass");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("PARENT :AfterTest");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("PARENT :AfterMethod");
    }

}
