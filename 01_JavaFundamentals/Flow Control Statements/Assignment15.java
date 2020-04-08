class Assignment15
{
	static void sumOfDigits(int number)
	{
		int sum = 0;
		while (number != 0)
		{
			sum = sum + (number % 10);
			number = number / 10;
		}
		System.out.println(sum);
	}
	public static void main(String args[])
	{
		try
		{
			int number = Integer.parseInt(args[0]);
			sumOfDigits(number);
		}
		catch (Exception e)
		{
			System.out.println("Please enter an integer number like this - 'java Assignment15 <integer>'");
		}
	}
}