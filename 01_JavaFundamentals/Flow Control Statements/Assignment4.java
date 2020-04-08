import java.util.Scanner;

class Assignment4
{
	public static void main(String args[])
	{
		String sorted = "";
		Scanner sc = new Scanner(System.in);

		System.out.printf("Enter a character: ");
		char first = sc.next().charAt(0);
		System.out.printf("Enter another character: ");
		char second = sc.next().charAt(0);
		sc.close();

		if (first < second)
			sorted = sorted + first + ", " + second;
		else
			sorted = sorted + second + ", " + first;

		System.out.println(sorted);
	}
}