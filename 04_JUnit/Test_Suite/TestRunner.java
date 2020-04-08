import junit.assignment1.Demo1Test;
import junit.assignment2.Demo2Test;
import junit.assignment3.EmployeeTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner
{
	public static void main(String args[])
	{
		Result result = JUnitCore.runClasses(TestSuite.class);

		for (Failure failure : result.getFailures())
			System.out.println(failure.toString());

		System.out.println(result.wasSuccessful());
   }
}