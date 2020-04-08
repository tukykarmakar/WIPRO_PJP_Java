class Assignment13
{
	static boolean isPrime (int number)
	{
		if (number == 1)
			return false;

		if (number != 2 && number != 3)
			for (int i = 2; i <= number/2; i++)
				if (number % i == 0)
					return false;
	
		return true;
	}
	public static void main(String args[])
	{
		int i, start = 10, end = 99;

		for (i = start; i <= end; i++)
			if (isPrime(i))
				System.out.printf(i + " ");
	}
}