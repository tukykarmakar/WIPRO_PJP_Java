class Test
{
	public static void main(String args[])
	{
		try
		{
			int number = Integer.parseInt(args[0]);
			System.out.println("Given number: " + number);
			System.out.println("Binary equivalent: " + Integer.toBinaryString(number));
			System.out.println("Octal equivalent: " + Integer.toOctalString(number));
			System.out.println("Hexadecimal equivalent: " + Integer.toHexString(number));
		}
		catch(Exception e)
		{
			System.out.println("Please enter an integer in this format -> \"java Test <integer>\"");
		}
	}
}