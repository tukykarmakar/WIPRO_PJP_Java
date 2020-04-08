package junit.assignment2;

public class Demo2
{
	public boolean palindromeCheck(String input)
	{
		StringBuffer stringBuffer = new StringBuffer(input);
		stringBuffer.reverse();
		return (input.equals(stringBuffer.toString()));
	}
}