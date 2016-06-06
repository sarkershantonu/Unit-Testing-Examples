package runner;

import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import parameterization.ParametersTests;
import parameterization.TestParameter;
import suit.JunitSuit;


public class JunitTestRunner {
	
	public static void main(String...  args){
		//RunJunitSerially_1();
		//RunJunitSerially_2();
		ParalleTestJunit();
	}

	public static void RunJunitSerially_1(){
		Result result = null; 
		result = JUnitCore.runClasses(JunitSuit.class);
	}
	public static void RunJunitSerially_2(){
		Result result = null; 		
		JUnitCore runner = new JUnitCore();
		result = runner.run(JunitSuit.class);
		//in case you need to check fails
		for(Failure fail : result.getFailures()){
			System.out.println(fail.getTrace());
		}
	}
	public static void ParalleTestJunitPerf(){}
	public static void ParalleTestJunit(){
		Class[] clas = {ParametersTests.class, TestParameter.class};
		while(true){
		//Parallel among classes  
	      //JUnitCore.runClasses(ParallelComputer.classes(), clas);  

	      //Parallel among methods in a class  
	      //JUnitCore.runClasses(ParallelComputer.methods(), clas);  

	      //Parallel all methods in all classes  
	
	     JUnitCore.runClasses(new ParallelComputer(true, true), clas);
	      }  
	}
	public static void ParalleTestJunitTempus(){}
	public static void ParalleTestJunitConcurrency(){}
	public static void ParalleTestJunitTestLoadBalancer(){}
}
