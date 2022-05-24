package org.automation.hamcrest.examples;

public class Calculator {
    public <T extends Number> T add(T t1, T t2){
        return (T)new Double(t1.doubleValue()+t2.doubleValue());
    }
}
