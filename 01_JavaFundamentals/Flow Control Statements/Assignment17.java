class Assignment17
{
	static int reverseInteger(int number)
	{
		int remainder, reverse = 0, number1 = number;

		while (number1 != 0)
		{
			remainder = number1 % 10;
			reverse = reverse * 10 + remainder;
			number1 = number1 / 10;
		}

		return reverse;
	}
	public static void main(String args[])
	{
		try
		{
			int number = Integer.parseInt(args[0]);
			System.out.println(reverseInteger(number));
		}
		catch (Exception e)
		{
			System.out.println("Please enter an integer number");
		}
	}
}