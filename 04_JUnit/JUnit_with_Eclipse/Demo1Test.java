package junit.first;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.first.*;

public class Demo1Test
{
	@Test
	public void testStringConcat()
	{
		try
		{
			System.out.println("Try-block start");
			Demo1 demo1 = new Demo1();
			assertEquals("HelloWorld", demo1.stringConcat("Hello", "World"));
			System.out.println("Try-block end");
		}
		catch(Exception e)
		{
			System.out.println("Inside Catch-block");
			System.out.println(e.getMessage());
		}
	}
}