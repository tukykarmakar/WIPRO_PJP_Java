import java.util.Scanner;

class Assignment2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an Integer: ");
		int number = sc.nextInt(); sc.close();

		if (number % 2 == 0)
			System.out.println(number + " is an Even integer.");
		else
			System.out.println(number + " is a Odd integer.");
	}
}