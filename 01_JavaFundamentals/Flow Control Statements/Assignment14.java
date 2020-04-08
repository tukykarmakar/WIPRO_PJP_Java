class Assignment14
{
	static int isPrime (int number)
	{
		if (number == 1 || number == 0)
			return 2;

		if (number != 2 && number != 3)
			for (int i = 2; i <= number/2; i++)
				if (number % i == 0)
					return 0;
	
		return 1;
	}
	public static void main(String args[])
	{
		try
		{
			int number = Integer.parseInt(args[0]);

			if (isPrime(number) == 0)
				System.out.println(number + " is not a prime number");
			else if (isPrime(number) == 1)
				System.out.println(number + " is a prime number");
			else
				System.out.println(number + " is neither prime nor composite");
		}
		catch (Exception e)
		{
			System.out.println("Please enter an integer number");
		}
	}
}