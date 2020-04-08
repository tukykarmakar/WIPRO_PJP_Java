package junit.assignment2;

class Demo2
{
	public palindromeCheck(String input)
	{
		StringBuffer stringBuffer = new StringBuffer(input);
		stringBuffer.reverse();
		return (input.equals(stringBuffer.toString()));
	}
}