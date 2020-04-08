import java.util.Scanner;
class Assignment6
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter two strings separated by a blank space: ");
		String input[] = scanner.nextLine().split(" ");
		scanner.close();

		if (input[0].length() < input[1].length())
			System.out.println(input[0]+input[1]+input[0]);
		else
			System.out.println(input[1]+input[0]+input[1]);
	}
}