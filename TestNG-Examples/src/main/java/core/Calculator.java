package core;

public class Calculator {

public long add(int num2,int num3)
{
	return (long)(num2+num3);	
}

public long add(int num1,int num2,int num3)
{
	long res = this.add(num2,num3);
	return (long)num1+res;	
}
	public long add(long a, long b){return a+b;}
public double add(double num1,double num2,double num3)
{
	return num1+num2+num3;	
}
public Calculator()
{
	
}
}
