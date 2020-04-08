package junit.assignment2;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

public class Demo2Test
{
	@Test
	void testPalindromeCheck()
	{
		Demo2 demo2 = new Demo2();
		assertEquals("Result", false, demo2.palindromeCheck("Hello"));
		fail("Not yet implemented");
	}
}