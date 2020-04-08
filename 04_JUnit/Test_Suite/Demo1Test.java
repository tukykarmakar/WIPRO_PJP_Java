package junit.assignment1;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

public class Demo1Test
{
	@Test
	void testStringConcat()
	{
		Demo1 demo1 = new Demo1();
		assertEquals("Result", "HelloWorld", demo1.stringConcat("Hello", "World"));
		fail("Not yet implemented");
	}
}
