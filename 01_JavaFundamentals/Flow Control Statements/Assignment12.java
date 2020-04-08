import java.util.Scanner;

class Assignment12
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int i; boolean isPrime = true;

		System.out.printf("Enter an integer: ");
		int number = scanner.nextInt();
		scanner.close();

		if (number == 1)
			isPrime = false;

		if (number != 2 && number != 3)
			for (i = 2; i <= number/2; i++)
				if (number % i == 0)
				{
					isPrime = false;
					break;
				}

		if (isPrime)
			System.out.println(number + " is a Prime Number");
		else
			System.out.println(number + " is not a Prime Number");
	}
}