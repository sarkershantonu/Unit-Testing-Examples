package org.automation.tests;

import core.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestDemo extends BaseTest {

    /*@BeforeSuite
    public void beforeSuite(){
        System.out.println("@BeforeSuite");
    }
    @BeforeGroups
    public void beforeGroup(){
        System.out.println("@BeforeGroups");
    }

    @BeforeClass
    public  void beforeClass(){
        System.out.println("@BeforeClass");
    }*/
    @BeforeTest
    public void beforeTest(){
        System.out.println("@BeforeTest");
        calculator = new Calculator();
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("@BeforeMethod");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("@AfterClass");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("@AfterTest");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("@AfterMethod");
    }
    @Test
    public void testAdd(){
        System.out.println("@Test");
        Assert.assertEquals(5l,calculator.add(2l,3l));
    }
}
