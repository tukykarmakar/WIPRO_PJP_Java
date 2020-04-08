class Assignment18
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
	static void checkIntegerPalindrome(int number)
	{
		int reversed = reverseInteger(number);

		if (reversed == number)
			System.out.println(number + " is a palindrome");
		else
			System.out.println(number + " is not a palindrome");
	}
	public static void main(String args[])
	{
		try
		{
			int number = Integer.parseInt(args[0]);
			checkIntegerPalindrome(number);
		}
		catch (Exception e)
		{
			System.out.println("Please enter an integer number");
		}
	}
}