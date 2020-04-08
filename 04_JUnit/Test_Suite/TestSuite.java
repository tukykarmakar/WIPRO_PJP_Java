import junit.assignment1.Demo1Test;
import junit.assignment2.Demo2Test;
import junit.assignment3.EmployeeTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Demo1Test.class, Demo2Test.class, EmployeeTest.class})

public class TestSuite
{}