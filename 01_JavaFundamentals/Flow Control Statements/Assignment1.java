import java.util.Scanner;

class Assignment1
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an Integer: ");
		int number = sc.nextInt(); sc.close();

		if (number > 0)
			System.out.println(number + " is a Positive integer.");
		else if (number < 0)
			System.out.println(number + " is a Negative integer.");
		else
			System.out.println(number + " is Zero");
	}
}