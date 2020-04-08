import java.util.Scanner;
class Assignment5
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter any string: ");
		String input = scanner.nextLine();
		scanner.close();

		System.out.println(input.substring(1, input.length()-1));
	}
}