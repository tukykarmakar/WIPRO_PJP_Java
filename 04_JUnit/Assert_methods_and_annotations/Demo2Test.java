package junit.assignment2;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

class Demo2Test
{
	@Test
	void testPalindromeCheck()
	{
		Demo2 demo2 = new Demo2();
		assertEquals("Result", false, demo2.palindromeCheck("Hello"));
		fail("Not yet implemented");
	}
}