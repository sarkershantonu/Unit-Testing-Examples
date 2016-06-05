package com.core;

public class Calculator {

public long Add(int num2,int num3)
{
	return (long)(num2+num3);	
}

public long Add(int num1,int num2,int num3)
{
	long res = this.Add(num2,num3);
	return (long)num1+res;	
}

public double Add(double num1,double num2,double num3)
{
	return num1+num2+num3;	
}
public Calculator()
{
	
}
}
