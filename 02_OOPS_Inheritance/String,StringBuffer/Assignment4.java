import java.util.Scanner;
class Assignment4
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter any string: ");
		String input = scanner.nextLine();
		scanner.close();

		if (input.length() % 2 == 0)
			System.out.println(input.substring(0, input.length()/2));
		else
			System.out.println("null");
	}
}